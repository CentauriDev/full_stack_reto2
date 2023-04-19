import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import io.serps.core.GoogleSearch;
import io.serps.exceptions.SerpApiClientException;

public class HttpRequestsScholarAPI {
    public static void main(String[] args) {
        try {
            // Set the search parameters
            Map<String, String> parameter = new HashMap<>();
            parameter.put("engine", "google_scholar");
            parameter.put("q", "biology");
            parameter.put("api_key", "919aa173c602e9a03604e83a1575ca23cd1dfea864b4baba79d19a2909edc1a7");

            // Create a GoogleSearch object with the search parameters
            GoogleSearch search = new GoogleSearch(parameter);

            // Get the JSON results from the API
            String jsonString = search.getJsonString();

            // Create a URL object with the author ID you want to retrieve data for
            URL url = new URL(
                    "https://scholar.google.com/citations?user=6165916694c6c7025deef5ab&hl=en&cstart=0&pagesize=100");

            // Open an HttpURLConnection with the GET method
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response from the server
            System.out.println(response.toString());
        } catch (SerpApiClientException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

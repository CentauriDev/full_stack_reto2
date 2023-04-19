import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestExample {
    public static void main(String[] args) {
        try {
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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

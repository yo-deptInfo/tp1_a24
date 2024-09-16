package cal335.meteo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherMapService implements ApiService {
    private final String API_KEY = "9f23a99453e6d7497516222f24551b13";
    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    @Override
    public String obtenirDonneesMeteoActuelle(String ville) {
        try {
            URL url = new URL(BASE_URL + "weather?q=" + ville + "&appid=" + API_KEY + "&lang=fr&units=metric");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();
            return content.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
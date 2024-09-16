package cal335.meteo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherMapService {
    //TODO Votre clé API
    private final String API_KEY = "";
    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    public String obtenirDonneesPrevisionsHoraires(String ville) {
        //TODO Complétez le code afin de construire le bon endpoint
        String endpoint = "";
        return envoyerRequete(endpoint);
    }

    private String envoyerRequete(String endpoint) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
            }

            in.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
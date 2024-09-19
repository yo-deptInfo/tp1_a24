package cal335.meteo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherMapService {
    private final String API_KEY = "";
    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/";


    public String obtenirDonneesPrevisionsHoraires(String ville) {
        String endpoint = "";
        return envoyerRequete(endpoint);
    }

    private String envoyerRequete(String endpoint) {
        StringBuilder reponse = new StringBuilder();
        try {
            URL urlFinale = new URL(BASE_URL + endpoint);
            HttpURLConnection connexionHttp = (HttpURLConnection) urlFinale.openConnection();
            connexionHttp.setRequestMethod("GET");

            BufferedReader entrant = new BufferedReader(new InputStreamReader(connexionHttp.getInputStream()));
            String ligneRecue;

            while ((ligneRecue = entrant.readLine()) != null) {
                reponse.append(ligneRecue);
            }

            entrant.close();
            connexionHttp.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reponse.toString();
    }
}
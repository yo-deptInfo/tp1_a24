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
        String endpoint = "weather?q=" + ville + "&appid=" + API_KEY + "&lang=fr&units=metric";
        return envoyerRequete(endpoint);
    }

    @Override
    public String obtenirDonneesPrevisionsHoraires(String ville) {
        String endpoint = "forecast?q=" + ville + "&appid=" + API_KEY + "&lang=fr&units=metric";
        return envoyerRequete(endpoint);
    }

    private String envoyerRequete(String endpoint) {
        StringBuilder reponse = new StringBuilder();
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection connexion = (HttpURLConnection) url.openConnection();
            connexion.setRequestMethod("GET");

            BufferedReader entrant = new BufferedReader(new InputStreamReader(connexion.getInputStream()));
            String ligneRecue;

            while ((ligneRecue = entrant.readLine()) != null) {
                reponse.append(ligneRecue);
            }

            entrant.close();
            connexion.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reponse.toString();
    }
}
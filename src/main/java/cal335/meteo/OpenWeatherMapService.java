package cal335.meteo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpenWeatherMapService implements ApiService {
    private final String apiKey = "VOTRE_CLEF_API";

    @Override
    public String obtenirDonneesMeteo(String ville) {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + ville + "&appid=" + apiKey + "&units=metric";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder infoString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    infoString.append(scanner.nextLine());
                }
                scanner.close();

                return infoString.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public MeteoActuelle convertirJsonEnMeteoActuelle(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(json);

            MeteoActuelle meteoActuelle = new MeteoActuelle();
            meteoActuelle.setVille(rootNode.path("name").asText());
            meteoActuelle.setTemperature(rootNode.path("main").path("temp").asDouble());
            meteoActuelle.setHumidite(rootNode.path("main").path("humidity").asInt());
            meteoActuelle.setDescription(rootNode.path("weather").get(0).path("description").asText());

            return meteoActuelle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PrevisionsHoraires> convertirJsonEnListePrevisionsHoraires(String json) {
        List<PrevisionsHoraires> listePrevisionsHoraires = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(json);
            JsonNode previsionsArray = rootNode.path("list");

            for (JsonNode previsionNode : previsionsArray) {
                PrevisionsHoraires prevision = new PrevisionsHoraires();
                prevision.setHeure(previsionNode.path("dt_txt").asText());
                prevision.setTemperature(previsionNode.path("main").path("temp").asDouble());
                prevision.setHumidite(previsionNode.path("main").path("humidity").asInt());
                prevision.setDescription(previsionNode.path("weather").get(0).path("description").asText());
                listePrevisionsHoraires.add(prevision);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listePrevisionsHoraires;
    }
}
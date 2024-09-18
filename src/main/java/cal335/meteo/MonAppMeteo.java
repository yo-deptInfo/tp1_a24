package cal335.meteo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
;

public class MonAppMeteo {

    static  ApiService serviceMeteo;

    public static void main(String[] args) {
        serviceMeteo = new OpenWeatherMapService();
        String donneesMeteo = serviceMeteo.obtenirDonneesMeteoActuelle("Montreal");
        MeteoActuelle meteoActuelle = deserializerMeteoActuelle(donneesMeteo);
        System.out.println(meteoActuelle);

        // Obtenir données pour les prévisions horaires
        String previsionHoraireJson = serviceMeteo.obtenirDonneesPrevisionsHoraires("Montreal");
        List<Condition> conditions = deserialiserPrevisionsHoraire(previsionHoraireJson);
        PrevisionsHoraire previsionsHoraire = new PrevisionsHoraire("Montreal", conditions);
        System.out.println(previsionsHoraire);

    }

    protected static MeteoActuelle deserializerMeteoActuelle(String donneesMeteo) {
        JSONObject json = new JSONObject(donneesMeteo);

        String temperature = String.valueOf(json.getJSONObject("main").getDouble("temp"));
        String humidite = String.valueOf(json.getJSONObject("main").getInt("humidity"));
        String pression = String.valueOf(json.getJSONObject("main").getInt("pressure"));
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");

        LocalDateTime dateHeure = LocalDateTime.ofEpochSecond(json.getLong("dt"), 0, ZoneOffset.UTC);

        Condition condition = new Condition(temperature, humidite, pression, description, dateHeure);
        return new MeteoActuelle("Montreal", condition);
    }

    protected static List<Condition> deserialiserPrevisionsHoraire(String previsionHoraireJson) {
        JSONObject json = new JSONObject(previsionHoraireJson);
        JSONArray previsionsArray = json.getJSONArray("list");

        List<Condition> conditions = new ArrayList<>();
        for (int i = 0; i < previsionsArray.length(); i++) {
            JSONObject prevision = previsionsArray.getJSONObject(i);

            String temperature = String.valueOf(prevision.getJSONObject("main").getDouble("temp"));
            String humidite = String.valueOf(prevision.getJSONObject("main").getInt("humidity"));
            String pression = String.valueOf(prevision.getJSONObject("main").getInt("pressure"));
            String description = prevision.getJSONArray("weather").getJSONObject(0).getString("description");
//            LocalDateTime dateHeure = LocalDateTime.ofEpochSecond(json.getLong("dt"), 0, ZoneOffset.UTC);
            LocalDateTime dateHeure = LocalDateTime.parse(prevision.getString("dt_txt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Condition condition = new Condition(temperature, humidite, pression, description, dateHeure);
            conditions.add(condition);
        }
        return conditions;
    }

}

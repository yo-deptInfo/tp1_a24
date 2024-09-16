package cal335.meteo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
;

public class MonAppMeteo {

    static OpenWeatherMapService serviceMeteo;

    public static void main(String[] args) {
        serviceMeteo = new OpenWeatherMapService();

        // Obtenir données pour les prévisions horaires
        String previsionHoraireJson = serviceMeteo.obtenirDonneesPrevisionsHoraires("Montreal");
        List<Condition> conditions = construireCondidtionsPourPrevisionsHoraire(previsionHoraireJson);
        PrevisionsHoraire previsionsHoraire = new PrevisionsHoraire("Montreal", conditions);
        System.out.println(previsionsHoraire);

    }

    //LocalDateTime dateHeure = LocalDateTime.ofEpochSecond(json.getLong("dt"), 0, ZoneOffset.UTC);

    private static List<Condition> construireCondidtionsPourPrevisionsHoraire(String previsionHoraireJson) {
        JSONObject json = new JSONObject(previsionHoraireJson);
        JSONArray previsionsArray = json.getJSONArray("list");

        List<Condition> conditions = new ArrayList<>();
        for (int i = 0; i < previsionsArray.length(); i++) {
            JSONObject prevision = previsionsArray.getJSONObject(i);

            String temperature = String.valueOf(prevision.getJSONObject("main").getDouble("temp"));
            String humidite = String.valueOf(prevision.getJSONObject("main").getInt("humidity"));
            String pression = String.valueOf(prevision.getJSONObject("main").getInt("pressure"));
            String description = prevision.getJSONArray("weather").getJSONObject(0).getString("description");
            LocalDateTime dateHeure = LocalDateTime.parse(prevision.getString("dt_txt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Condition condition = new Condition(temperature, humidite, pression, description, dateHeure);
            conditions.add(condition);
        }
        return conditions;
    }

}

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


    public static void main(String[] args) {

        String critereRecherche = "Montreal";

        // Obtenir données pour les prévisions horaires
        String previsionHoraireJson = serviceMeteo.obtenirDonneesPrevisionsHoraires(critereRecherche);
        PrevisionsHoraire previsionsHoraire = deserialiserPrevisionsHoraire(previsionHoraireJson, critereRecherche);
        System.out.println(previsionsHoraire);

        OpenWeatherMapService serviceMeteo = new OpenWeatherMapService();
        String donneesMeteo = serviceMeteo.obtenirDonneesMeteoActuelle(critereRecherche);
        MeteoActuelle meteoActuelle = deserialiserMeteoActuelle(donneesMeteo, critereRecherche);
        System.out.println(meteoActuelle);

    }

    protected static PrevisionsHoraire deserialiserPrevisionsHoraire(String donneesPrevisionsHoraires, String ville) {

        JSONObject donnees = new JSONObject(donneesPrevisionsHoraires);

        JSONArray previsions;
        previsions = donnees.getJSONArray("list");

        // Extraction des informations sur les conditions prévues
        JSONObject prevision;
        List<Condition> conditions = new ArrayList<>();
        for (int i = 0; i < previsions.length(); i++) {
            prevision = previsions.getJSONObject(i);

            String temperature = String.valueOf(prevision.getJSONObject("main").getDouble("temp"));
            String humidite = String.valueOf(prevision.getJSONObject("main").getInt("humidity"));
            String pression = String.valueOf(prevision.getJSONObject("main").getInt("pressure"));
            String description = prevision.getJSONArray("weather").getJSONObject(0).getString("description");
            LocalDateTime dateHeure = LocalDateTime.parse(prevision.getString("dt_txt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Condition condition = new Condition(temperature, humidite, pression, description, dateHeure);
            conditions.add(condition);

        }

        // Extraction des informations de localisation
        JSONObject infoVille;
        infoVille = donnees.getJSONObject("city");
        // La suite, c'est à vous...

        Localisation localisation = null;
        return new PrevisionsHoraire(localisation, conditions);
    }

    protected static MeteoActuelle deserialiserMeteoActuelle(String donneesMeteoActuelle, String ville) {

        JSONObject donnees = new JSONObject(donneesMeteoActuelle);

        // Je vous épargne la manipulation des dates pour le moment ...
        LocalDateTime dateHeure = LocalDateTime.ofEpochSecond(donnees.getLong("dt"), 0, ZoneOffset.UTC);

        // Désérialisation à implémenter

        return null;
    }

}

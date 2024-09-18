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

        String critereRecherche = "Montreal";

        serviceMeteo = new OpenWeatherMapService();
        String donneesMeteo = serviceMeteo.obtenirDonneesMeteoActuelle(critereRecherche);
        MeteoActuelle meteoActuelle = deserialiserMeteoActuelle(donneesMeteo, critereRecherche);
        System.out.println(meteoActuelle);

        // Obtenir données pour les prévisions horaires
        String previsionHoraireJson = serviceMeteo.obtenirDonneesPrevisionsHoraires(critereRecherche);
        PrevisionsHoraire previsionsHoraire = deserialiserPrevisionsHoraire(previsionHoraireJson, critereRecherche);
        System.out.println(previsionsHoraire);

    }

    protected static MeteoActuelle deserialiserMeteoActuelle(String donneesMeteoActuelle, String ville) {

        JSONObject jsonMeteoActuelle = new JSONObject(donneesMeteoActuelle);

        // Extraction des informations sur la condition Actuelle
        String temperature = String.valueOf(jsonMeteoActuelle.getJSONObject("main").getDouble("temp"));
        String humidite = String.valueOf(jsonMeteoActuelle.getJSONObject("main").getInt("humidity"));
        String pression = String.valueOf(jsonMeteoActuelle.getJSONObject("main").getInt("pressure"));
        String description = jsonMeteoActuelle.getJSONArray("weather").getJSONObject(0).getString("description");
        LocalDateTime dateHeure = LocalDateTime.ofEpochSecond(jsonMeteoActuelle.getLong("dt"), 0, ZoneOffset.UTC);
        Condition condition = new Condition(temperature, humidite, pression, description, dateHeure);

        // Extraction des informations de localisation
        long id = jsonMeteoActuelle.getLong("id");
        String pays = jsonMeteoActuelle.getJSONObject("sys").getString("country");
        double latitude = jsonMeteoActuelle.getJSONObject("coord").getDouble("lat");
        double longitude = jsonMeteoActuelle.getJSONObject("coord").getDouble("lon");
        int fuseauHoraire = jsonMeteoActuelle.getInt("timezone"); // fuseau horaire en secondes

        Localisation localisation = new Localisation(id, ville, pays, latitude, longitude, fuseauHoraire);
        return new MeteoActuelle(localisation, condition);
    }

    protected static PrevisionsHoraire deserialiserPrevisionsHoraire(String donneesPrevisionsHoraires, String ville) {

        JSONObject jsonPrevisionsHoraires;
        JSONObject prevision;
        JSONObject infoVille;
        JSONArray previsionsArray;

        jsonPrevisionsHoraires = new JSONObject(donneesPrevisionsHoraires);
        previsionsArray = jsonPrevisionsHoraires.getJSONArray("list");

        // Extraction des informations sur les conditions prévues
        List<Condition> conditions = new ArrayList<>();
        for (int i = 0; i < previsionsArray.length(); i++) {
            prevision = previsionsArray.getJSONObject(i);
            String temperature = String.valueOf(prevision.getJSONObject("main").getDouble("temp"));
            String humidite = String.valueOf(prevision.getJSONObject("main").getInt("humidity"));
            String pression = String.valueOf(prevision.getJSONObject("main").getInt("pressure"));
            String description = prevision.getJSONArray("weather").getJSONObject(0).getString("description");
            LocalDateTime dateHeure = LocalDateTime.parse(prevision.getString("dt_txt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Condition condition = new Condition(temperature, humidite, pression, description, dateHeure);
            conditions.add(condition);

        }

        // Extraction des informations de localisation
        infoVille = jsonPrevisionsHoraires.getJSONObject("city");
        Long id = infoVille.getLong("id");
        String nomVille = infoVille.getString("name");
        String pays = infoVille.getString("country");
        double latitude = infoVille.getJSONObject("coord").getDouble("lat");
        double longitude = infoVille.getJSONObject("coord").getDouble("lon");
        double fuseauHoraire = infoVille.getDouble("timezone");

        Localisation localisation = new Localisation(id, nomVille, pays, latitude, longitude, fuseauHoraire);
        return new PrevisionsHoraire(localisation, conditions);
    }

}

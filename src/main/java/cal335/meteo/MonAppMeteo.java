package cal335.meteo;

import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
;

public class MonAppMeteo {

    static  ApiService serviceMeteo;

    public static void main(String[] args) {

        serviceMeteo = new OpenWeatherMapService();
        String donneesMeteo = serviceMeteo.obtenirDonneesMeteoActuelle("Montreal");
        MeteoActuelle meteoActuelle = deserializerMeteoActuelle(donneesMeteo);
        System.out.println(meteoActuelle);


    }

    private static MeteoActuelle deserializerMeteoActuelle(String donneesMeteo) {
        JSONObject json = new JSONObject(donneesMeteo);

        double temperature = json.getJSONObject("main").getDouble("temp");
        double humidite = json.getJSONObject("main").getDouble("humidity");
        double pression = json.getJSONObject("main").getDouble("pressure");
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");

        LocalDateTime dateHeure = LocalDateTime.ofEpochSecond(json.getLong("dt"), 0, ZoneOffset.UTC);

        Condition condition = new Condition(temperature, humidite, pression, description, dateHeure);
        return new MeteoActuelle("Montreal", condition);
    }

}

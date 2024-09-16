package cal335.meteo;

public class MeteoActuelle extends Meteo {
    @Override
    public void afficherDetails() {
        System.out.println("Ville: " + ville);
        System.out.println("Température: " + temperature + "°C");
        System.out.println("Humidité: " + humidite + "%");
        System.out.println("Description: " + description);
    }
}

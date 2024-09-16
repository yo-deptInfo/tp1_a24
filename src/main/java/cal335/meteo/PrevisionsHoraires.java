package cal335.meteo;

public class PrevisionsHoraires extends Meteo {
    private String heure;

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Ville: " + ville);
        System.out.println("Heure: " + heure);
        System.out.println("Température: " + temperature + "°C");
        System.out.println("Humidité: " + humidite + "%");
        System.out.println("Description: " + description);
    }
}

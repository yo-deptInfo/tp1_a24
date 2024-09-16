package cal335.meteo;

public abstract class Meteo {
    protected String ville;
    protected double temperature;
    protected int humidite;
    protected String description;

    // Méthodes communes
    public abstract void afficherDetails();

    // Getters et Setters encapsulant les attributs
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidite() {
        return humidite;
    }

    public void setHumidite(int humidite) {
        this.humidite = humidite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

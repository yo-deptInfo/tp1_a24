package cal335.meteo;

public abstract class Meteo {
    private String localisation;

    public Meteo(String localisation) {
        this.localisation = localisation;
    }

    public String getLocalisation() {
        return localisation;
    }

}

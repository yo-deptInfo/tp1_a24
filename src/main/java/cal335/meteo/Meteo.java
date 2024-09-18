package cal335.meteo;

public abstract class Meteo {
//    private String localisation;
    private Localisation localisation;

    public Meteo(Localisation localisation) {
        this.localisation = localisation;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

}

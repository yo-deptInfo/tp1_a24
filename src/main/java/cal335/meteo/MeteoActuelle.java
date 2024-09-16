package cal335.meteo;

public class MeteoActuelle extends Meteo  {
    private Condition condition;

    public MeteoActuelle(String localisation, Condition condition) {
        super(localisation);
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "MeteoActuelle{" +
                "localisation='" + getLocalisation() + '\'' +
                ", condition=" + condition +
                '}';
    }
}

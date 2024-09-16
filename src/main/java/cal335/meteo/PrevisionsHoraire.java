package cal335.meteo;

import java.util.List;

public class PrevisionsHoraire extends Meteo {
    private List<Condition> conditions;

    public PrevisionsHoraire(String localisation, List<Condition> conditions) {
        super(localisation);
        this.conditions = conditions;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    @Override
    public String toString() {
        return "PrevisionsHoraire{" +
                "localisation='" + getLocalisation() + '\'' +
                ", conditions=" + conditions +
                '}';
    }
}

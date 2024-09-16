package cal335.meteo;

import java.util.List;

public class PrevisionsHoraire{

    private String localisation;
    private List<Condition> conditions;

    public PrevisionsHoraire(String localisation, List<Condition> conditions) {
        this.localisation = localisation;
        this.conditions = conditions;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    @Override
    public String toString() {
        // TODO Implémetez cette méthode
        //  afin qu'elle permette l'affichage des prévisions
        return "";
    }
}

package cal335.meteo;

import java.time.LocalDateTime;

public class Condition {

    private double temperature;
    private double humidite;
    private double pression;
    private String description;
    private LocalDateTime dateHeure;

    public Condition(double temperature, double humidite, double pression, String description, LocalDateTime dateHeure) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        this.description = description;
        this.dateHeure = dateHeure;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "temperature='" + temperature + '\'' +
                ", humidite='" + humidite + '\'' +
                ", pression='" + pression + '\'' +
                ", description='" + description + '\'' +
                ", dateHeure=" + dateHeure +
                '}';
    }
}

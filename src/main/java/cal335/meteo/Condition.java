package cal335.meteo;

import java.time.LocalDateTime;

public class Condition {

    private String temperature;
    private String humidite;
    private String pression;
    private String description;
    private LocalDateTime dateHeure;

    public Condition(String temperature, String humidite, String pression, String description, LocalDateTime dateHeure) {
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

package cal335.meteo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MonAppMeteoTest {

    @Test
    public void testDeserializerMeteoActuelle() {
        String json = "{...}"; // JSON string pour la météo actuelle
        MeteoActuelle meteoActuelle = MonAppMeteo.deserializerMeteoActuelle(json);
        assertNotNull(meteoActuelle);
        assertEquals("Montreal", meteoActuelle.getLocalisation());
        assertNotNull(meteoActuelle.getCondition());
    }

    @Test
    public void testDeserialiserPrevisionsHoraire() {
        String json = "{...}"; // JSON string pour les prévisions horaires
        List<Condition> conditions = MonAppMeteo.deserialiserPrevisionsHoraire(json);
        assertNotNull(conditions);
        assertFalse(conditions.isEmpty());
    }

}

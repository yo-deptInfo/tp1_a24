package cal335.meteo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class MeteoActuelleTest {

    private MeteoActuelle meteoActuelle;
    private Condition condition;
    private LocalDateTime now;

    @BeforeEach
    public void setUp() {
        now = LocalDateTime.now();
        condition = new Condition("20", "75", "1020", "peu nuageux", now);
        meteoActuelle = new MeteoActuelle("Montreal", condition);
    }

    @Test
    public void testToString() {
        String expected = "MeteoActuelle{localisation='Montreal', condition=" + condition.toString() + "}";
        assertEquals(expected, meteoActuelle.toString());
    }

    @Test
    public void testGetCondition() {
        assertEquals(condition, meteoActuelle.getCondition());
    }

    @Test
    public void testGetLocalisation() {
        assertEquals("Montreal", meteoActuelle.getLocalisation());
    }
}

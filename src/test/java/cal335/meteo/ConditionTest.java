package cal335.meteo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ConditionTest {

    private Condition condition;
    private LocalDateTime now;

    @BeforeEach
    public void setUp() {
        now = LocalDateTime.now();
        condition = new Condition("20", "75", "1020", "peu nuageux", now);
    }

    @Test
    public void testToString() {
        String expected = "Condition{temperature='20', humidite='75', pression='1020', description='peu nuageux', dateHeure=" + now + "}";
        assertEquals(expected, condition.toString());
    }

    @Test
    public void testGetters() {
        assertEquals("20", condition.getTemperature());
        assertEquals("75", condition.getHumidite());
        assertEquals("1020", condition.getPression());
        assertEquals("peu nuageux", condition.getDescription());
        assertEquals(now, condition.getDateHeure());
    }

}

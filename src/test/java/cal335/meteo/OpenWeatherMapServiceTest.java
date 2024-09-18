package cal335.meteo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OpenWeatherMapServiceTest {
    private OpenWeatherMapService serviceMeteo;

    @BeforeEach
    public void setUp() {
        serviceMeteo = new OpenWeatherMapService();
    }

    @Test
    public void testObtenirDonneesMeteoActuelle() {
        String response = serviceMeteo.obtenirDonneesMeteoActuelle("Montreal");
        assertNotNull(response);
    }

    @Test
    public void testObtenirDonneesPrevisionsHoraires() {
        String response = serviceMeteo.obtenirDonneesPrevisionsHoraires("Montreal");
        assertNotNull(response);
    }

}

package cal335.meteo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class MonAppMeteoTest {

    String jsonActuel;
    String jsonPrevision;

    @BeforeEach
    public void setUp() throws IOException {
        // Chemin vers le fichier JSON dans src/test/resources
        String cheminFichierActuel= getClass().getClassLoader().getResource("testMeteoActuelle.json").getPath();
        String cheminFichierPrevision = getClass().getClassLoader().getResource("testPrevisionHoraire.json").getPath();

        // Lire le contenu du fichier JSON dans une chaîne de caractères
        jsonActuel = new String(Files.readAllBytes(Paths.get(cheminFichierActuel)));
        jsonPrevision = new String(Files.readAllBytes(Paths.get(cheminFichierPrevision)));


    }

    @Test
    public void testDeserializerMeteoActuelle() {
        MeteoActuelle meteoActuelle = MonAppMeteo.deserialiserMeteoActuelle(jsonActuel, "Montréal");
        assertNotNull(meteoActuelle);
        assertEquals("Montreal", meteoActuelle.getLocalisation());
        assertNotNull(meteoActuelle.getCondition());
    }

    @Test
    public void testDeserialiserPrevisionsHoraire() {
        PrevisionsHoraire previsionsHoraire = MonAppMeteo.deserialiserPrevisionsHoraire(jsonPrevision, "Montréal");
        assertNotNull(previsionsHoraire);
        assertNotNull(previsionsHoraire.getConditions());
        assertFalse(previsionsHoraire.getConditions().isEmpty());
    }

}

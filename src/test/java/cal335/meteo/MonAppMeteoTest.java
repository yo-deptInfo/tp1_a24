package cal335.meteo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MonAppMeteoTest {
//
//    String jsonActuel = "{...}";
//

    String jsonPrevision;// = "";


    @BeforeEach
    public void setUp() throws IOException {
        // Chemin vers le fichier JSON dans src/test/resources
        String cheminFichierJson = getClass().getClassLoader().getResource("testPrevisionHoraire.json").getPath();
        // Lire le contenu du fichier JSON dans une chaîne de caractères
        jsonPrevision = new String(Files.readAllBytes(Paths.get(cheminFichierJson)));


    }

    @Test
    public void testDeserializerMeteoActuelle() {
        String json = "{...}"; // JSON string pour la météo actuelle
//        MeteoActuelle meteoActuelle = MonAppMeteo.deserializerMeteoActuelle(json);
//        assertNotNull(meteoActuelle);
//        assertEquals("Montreal", meteoActuelle.getLocalisation());
//        assertNotNull(meteoActuelle.getCondition());
    }

    @Test
    public void testDeserialiserPrevisionsHoraire() {
//        String json = "{...}"; // JSON string pour les prévisions horaires
        PrevisionsHoraire previsionsHoraire = MonAppMeteo.deserialiserPrevisionsHoraire(jsonPrevision, "Montréal");
        assertNotNull(previsionsHoraire);
        assertNotNull(previsionsHoraire.getConditions());
        assertFalse(previsionsHoraire.getConditions().isEmpty());
    }

}

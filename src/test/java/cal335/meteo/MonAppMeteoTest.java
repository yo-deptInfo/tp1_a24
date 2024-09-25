package cal335.meteo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class MonAppMeteoTest {

    String jsonActuel;
    String jsonPrevision;
    Localisation localisationAttendue;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException {
        recupererJson();
        recupererLocalisationCommune();

    }

    private void recupererJson() throws IOException, URISyntaxException {
        // Chemin vers le fichier JSON dans src/test/resources
        String cheminMeteoActuelle =
                Paths.get(getClass().getClassLoader().getResource("testMeteoActuelle.json").toURI()).toString();
        String cheminPrevisionHoraire =
                Paths.get(getClass().getClassLoader().getResource("testPrevisionHoraire.json").toURI()).toString();

        // Lire le contenu du fichier JSON dans une chaîne de caractères
        jsonActuel = new String(Files.readAllBytes(Paths.get(cheminMeteoActuelle)));
        jsonPrevision = new String(Files.readAllBytes(Paths.get(cheminPrevisionHoraire)));

    }

    private void recupererLocalisationCommune() {
        localisationAttendue =
                new Localisation(6077243.0, "Montréal", "CA", 45.5088, -73.5878, -14400.0);
    }

    @Test
    public void testDeserializerMeteoActuelle() {
        MeteoActuelle meteoActuelle = MonAppMeteo.deserialiserMeteoActuelle(jsonActuel, "Montréal");
        assertNotNull(meteoActuelle);
        assertNotNull(meteoActuelle.getLocalisation());
        assertEquals(localisationAttendue.toString(), meteoActuelle.getLocalisation().toString());
        assertNotNull(meteoActuelle.getCondition());
    }

    @Test
    public void testDeserialiserPrevisionsHoraire() {
        PrevisionsHoraire previsionsHoraire = MonAppMeteo.deserialiserPrevisionsHoraire(jsonPrevision, "Montréal");
        assertNotNull(previsionsHoraire);
        assertNotNull(previsionsHoraire.getLocalisation());
        assertEquals(localisationAttendue.toString(), previsionsHoraire.getLocalisation().toString());
        assertNotNull(previsionsHoraire.getConditions());
        assertFalse(previsionsHoraire.getConditions().isEmpty());
        assertEquals(40, previsionsHoraire.getConditions().size());
    }

}

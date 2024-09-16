package cal335.meteo;

import java.util.List;

public class MonAppMeteo {
    public static void main(String[] args) {
        String ville = "Paris";  // Vous pouvez remplacer par n'importe quelle ville

        // Initialisation du service
        OpenWeatherMapService service = new OpenWeatherMapService();

        // Obtenir et afficher la météo actuelle
        String meteoActuelleJson = service.obtenirDonneesMeteo(ville);
        MeteoActuelle meteoActuelle = service.convertirJsonEnMeteoActuelle(meteoActuelleJson);
        if (meteoActuelle != null) {
            meteoActuelle.afficherDetails();
        }

        // Obtenir et afficher les prévisions horaires
        String previsionsHorairesJson = service.obtenirDonneesMeteo(ville); // Normalement vous utiliserez un autre endpoint pour les prévisions
        List<PrevisionsHoraires> previsionsHoraires = service.convertirJsonEnListePrevisionsHoraires(previsionsHorairesJson);
        for (PrevisionsHoraires prevision : previsionsHoraires) {
            prevision.afficherDetails();
        }
    }
}

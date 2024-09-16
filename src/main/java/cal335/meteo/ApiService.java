package cal335.meteo;

public interface ApiService {

    String obtenirDonneesMeteoActuelle(String ville);

    String obtenirDonneesPrevisionsHoraires(String ville);

}

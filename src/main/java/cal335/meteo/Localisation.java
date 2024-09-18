    package cal335.meteo;

    public class Localisation {

        Long id;
        String ville;
        String pays;
        double latitude;
        double longitude;
        double fuseauHoraire;

        public Localisation(Long id, String ville, String pays, double latitude, double longitude, double fuseauHoraire) {
            this.id = id;
            this.ville = ville;
            this.pays = pays;
            this.latitude = latitude;
            this.longitude = longitude;
            this.fuseauHoraire = fuseauHoraire;
        }
    }

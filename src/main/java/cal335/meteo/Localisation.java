    package cal335.meteo;

    public class Localisation {

        double id;
        String ville;
        String pays;
        double latitude;
        double longitude;
        double fuseauHoraire;

        public Localisation(double id, String ville, String pays, double latitude, double longitude, double fuseauHoraire) {
            this.id = id;
            this.ville = ville;
            this.pays = pays;
            this.latitude = latitude;
            this.longitude = longitude;
            this.fuseauHoraire = fuseauHoraire;
        }

        @Override
        public String toString() {
            return "Localisation{" +
                    "id=" + id +
                    ", ville='" + ville + '\'' +
                    ", pays='" + pays + '\'' +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", fuseauHoraire=" + fuseauHoraire +
                    '}';
        }
    }

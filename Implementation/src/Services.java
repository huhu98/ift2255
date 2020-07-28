public class Services {

    private String titre;
    private Numero numPro;
    private Temps date;
    private Temps debut;
    private Temps fin;
    private Temps heure;
    private Temps semaine;
    private int capacite;
    private double prix;
    private String comment;
    private Numero code;
    private Presence presences;
    private boolean serviceExiste = false;

    public Services(String titre, Numero numPro, Temps debut, Temps fin, Temps heure, Temps semaine,
                    int capacite, double prix, Numero code, Presence presences, boolean serviceExiste ) {
        this.titre = titre;
        this.numPro = numPro;
        this.debut = debut;
        this.fin = fin;
        this.heure = heure;
        this.semaine = semaine;
        this.capacite = capacite;
        this.prix = prix;
        this.code = code;
        this.presences = presences;
        this.serviceExiste = serviceExiste;
    }
    public String getContenu(String champ) {
        String val = "";
        String vraie = "oui";
        String faux = "non";
        String numero = code.toString();
        String numeroPro = numPro.toString();
        String present = presences.toString();
        String hr = heure.toString();
        String fini = fin.toString();
        String commence = debut.toString();
        String sem = semaine.toString();
        String nbrPlace = "" + capacite;
        String coût = "" + prix;

        switch(champ) {
            case "titre":
                val = this.titre;
                break;
            case "serviceExiste":
                if(this.serviceExiste == true) {
                    val = vraie;
                } else {
                    val = faux;
                }
                break;
            case "code":
                val = numero;
                break;
            case "numPro":
                val = numeroPro;
                break;
            case "presences":
                val = present;
                break;
            case "heure":
                val = hr;
                break;
            case "fin":
                val = fini;
                break;
            case "debut":
                val = commence;
                break;
            case "semaine":
                val = sem;
                break;
            case "prix":
                val = coût;
                break;
            case "capacite":
                val = nbrPlace;
                break;
        }
        return val;
   }
    public boolean estService() {
        serviceExiste = true;
        return serviceExiste;
    }
    public boolean pasService() {
        serviceExiste = false;
        return serviceExiste;
    }
//
//    public String setContenu(String champ, String valeur){}
//
//    public Seance getSeance(Temps date){}
//
//    public void addSeance (){}

    // get set comments presences serviceExiste

}

import java.util.HashMap;

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
    private HashMap<Numero, String> seance = new HashMap<Numero, String>();

    public Services(String titre, Numero numPro, Temps debut, Temps fin, Temps heure, Temps semaine,
                    int capacite, double prix, Numero code, Presence presences, boolean serviceExiste, Temps date ) {
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
        this.date = date;
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
        String jour = date.toString();
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
            case "date":
                val = jour;
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
//    public void setContenu(String champ, String valeur){}
//
   public Temps getSeance(Temps date,Numero code, String titre){ seance.get(code); return date;}
//
   public void removeSeance (Numero code, String titre) {
        seance.remove(code, titre);
    }
   public void addSeance (Numero code, String titre ) {
        seance.put(code, titre);
        System.out.println(seance);
   }

    // get set comments presences serviceExiste

}

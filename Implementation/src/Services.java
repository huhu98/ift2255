import java.util.HashMap;

public class Services {

    private String titre;
    private String numPro;
    private Temps date;
    private Temps debut;
    private Temps fin;
    private Temps heure;
    private Temps semaine;
    private int capacite;
    private double prix;
    private String comment;
    private String code;
    private Presence presences;
    private boolean serviceExiste = false;
    private HashMap<String, String> seance = new HashMap<String, String>();

    public Services(String titre, String numPro, Temps debut, Temps fin, Temps heure, Temps semaine,
                    int capacite, double prix, String code, Presence presences, boolean serviceExiste, Temps date ) {
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
   public void setContenu(String champ, String value){
       String val = "";
       switch(champ) {
           case "titre":
               val = value;
               break;
           case "serviceExiste":
               if (val.equalsIgnoreCase("true")) {
                   val = value;
               }
               if (val.equalsIgnoreCase("false")) {
                   val = value;
               }
           case "code":
               val = value;
               break;
           case "numPro":
               val = value;
               break;
           case "prix":
               val = value;
               break;
           case "presences":
               val = value;
               break;
           case "capacite":
               val = value;
               break;
           case "debut":
               val = value;
               break;
           case "fin":
               val = value;
               break;
           case "heure":
               val = value;
               break;
           case "semaine":
               val = value;
               break;
           case "date":
               val = value;
               break;
       }
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
   public Temps getSeance(Temps date,String code, String titre){ seance.get(code); return date;}
//
   public void removeSeance (String code, String titre) {
        seance.remove(code, titre);
    }
   public void addSeance (String code, String titre ) {
        seance.put(code, titre);
        System.out.println(seance);
   }

    // get set comments presences serviceExiste

}

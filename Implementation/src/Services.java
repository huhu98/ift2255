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
                    int capacite, double prix) {
        this.titre = titre;
        this.numPro = numPro;
        this.debut = debut;
        this.fin = fin;
        this.heure = heure;
        this.semaine = semaine;
        this.capacite = capacite;
        this.prix = prix;
    }

//    public String getContenu(){}
//
//    public String setContenu(String champ, String valeur){}
//
//    public Seance getSeance(Temps date){}
//
//    public void addSeance (){}

    // get set comments presences serviceExiste

}

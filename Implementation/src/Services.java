import org.graalvm.compiler.lir.LIRInstruction;

public class Services {

    private String titre;
    private Numero numPro;
    private Temps date;
    private Temps debut;
    private Temps fin;
    private Heure heure;
    private Semaine semaine;
    private int capacite;
    private double prix;
    private String comment;
    private Presence presences;
    private boolean serviceExiste = false;

    public Services(String titre, Numero numPro, Temps date, Temps debut, Temps fin, Heure heure, Semaine semaine,
                    int capacite, double prix) {
        this.titre = titre;
        this.numPro = numPro;
        this.date = date;
        this.debut = debut;
        this.fin = fin;
        this.heure = heure;
        this.semaine = semaine;
        this.capacite = capacite;
        this.prix = prix;
    }

    public String getContenu(){}

    // pas sur
//    public String setContenu(){}

    public addSeance(){}
    public Seance getSeance(Temps date){}
    public void addSeance (){}

    // get set comments presences serviceExiste

}

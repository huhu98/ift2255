import java.io.*;
import java.util.*;

public class Comptable {

    private HashMap<String, Membre> membres;
    private HashMap<String, Professionnel> pros;
    private HashMap<String, List<Seance>> fournie;
    private HashMap<String, List<Seance>> participe;
    private HashMap<String , Services> repService;

    public Comptable(ClientControl cc, ServiceControl sc) {
        this.membres = cc.getRepMembre();
        this.pros = cc.getRepPro();
        this.fournie = sc.getRepFournie();
        this.participe = sc.getRepInscrit();
        this.repService = sc.getRepService();

    }

    public void fichierTEF() {

    }
    
    public void rapportSynthese(){
    	
    }
    
    public void factureClient() {
    	
    }
    public void facturePro() {
    	
    }
    public double fraistotal() {
    	double montant = 0;
    	return montant;
    }
    
}


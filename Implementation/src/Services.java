import java.util.HashMap;

public class Services {
	private HashMap<String, Seance> seances = new HashMap<String, Seance>();
    
	private String titre;
	private int code;
    private String numPro;
    private String debut;
    private String fin;
    private String heure;
    private String jour;
    private int capacite;
    private double prix;
    private String comment;
    
    public Services(String titre, int code, String numPro, String debut, String fin, String heure, String jour,
                    int capacite, double prix, String comment) {
        this.titre = titre;
        this.code = code; // 3 chiffres
        this.numPro = numPro;
        this.debut = debut;
        this.fin = fin;
        this.heure = heure;
        this.jour = jour;
        this.capacite = capacite;
        this.prix = prix;
        this.comment = comment;
    }
    public String getContenu(String champ) {
    	String result = null;
        switch(champ) {
            case "titre":
            	result = this.titre;
                break;
            case "code":
            	int codeService = this.code;
            	result = Integer.toString(codeService);
            case "numPro":
                result = this.numPro;
                break;
            case "debut":
            	result = this.debut;
                break;
            case "fin":
            	result = this.fin;
                break;
            case "heure":
            	result = this.heure;
            case "jour":
            	result = this.jour;
                break;
            case "prix":
            	double cout = this.prix;
            	result = Double.toString(cout);
                break;
            case "capacite":
            	int espace = this.capacite;
            	result = Integer.toString(espace);
                break;
            case "comment":
            	result = this.comment;
        }
        return result;
   }
   public void setContenu(String champ, String value){
       switch(champ) {
           case "titre":
               this.titre = value;
               break;
           case "debut":
               this.debut= value;
               break;
           case "fin":
               this.fin = value;
               break;
           case "heure":
               this.heure = value;
               break;
           case "jour":
               this.jour = value;
               break;
           case "prix":
               this.prix = Double.parseDouble(value);
               break;
           case "capacite":
               this.capacite = Integer.parseInt(value);
               break;
           case "comment":
        	   this.comment = value;
        	   break;           
       }
   }
   public void addSeance() {
	   int nombreSeance = 0;
	   //calculer la difference de date pour avoir un nombre de semaine que le service va recurrer
	   //calculer la date de chacun
	   //genCodeSeance pour les i nombres de semaine xxxiipp
	   //creer seance avec la date
	   //put codeSeance et Seance(date) dans Hashmap
   }
   public String genCodeSeance(int i) {
	   String numSeance = Integer.toString(i);
	   String codeSeance = null;
	   String codeService = this.getContenu("code"); 
	   String numP2 = this.getContenu(numPro);
	   codeSeance = codeService+numSeance+numP2.substring(numP2.length()-2);
	   return codeSeance;
   }
}
   

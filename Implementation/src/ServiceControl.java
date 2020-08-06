import java.util.*;

public class ServiceControl {
    private HashMap<String, Seance> repSeances = new HashMap<String, Seance>();
    private HashMap<String, Services> repServices = new HashMap<String, Services>();
    private HashMap<String, List<Seance>> seanceInscrit = new HashMap<String, List<Seance>>();
    private HashMap<String, List<Seance>> seanceFournie = new HashMap<String, List<Seance>>();
    
    
    public HashMap<String, Seance> getRepSeance(){
    	return this.repSeances;
    }
    public HashMap<String, Services> getRepService(){
    	return this.repServices;
    }
    public Services getService(String code) {
    	return this.repServices.get(code);
    }
    public Seance getSeance(String codeSeance) {
    	return this.repSeances.get(codeSeance);
    }
    public void replaceSeance(String codeSeance,Seance s) {
    	this.repSeances.replace(codeSeance, s);
    }
    public boolean serviceExist(String code) {
    	return this.repServices.containsKey(code);
    }
    public boolean seanceExist(String code) {
    	return this.repSeances.containsKey(code);
    }
    public String serviceCode() {
    	String code = Numero.genererNum(3);
		return code;
    	
    }
    public void ajoutService(String titre, String numPro, String debut, String fin, String heure, String jour,
            String capacite, String prix, String comment) {
    	
    	String code = serviceCode();
    	if(getService(code) != null){
    		System.out.print("Code de service existe déja");
    		
    	}else {
    		
    	//Creer le service
    	Services s = new Services(code,titre,numPro,debut,fin,heure,Integer.parseInt(jour),Integer.parseInt(capacite),Double.parseDouble(prix),comment);
    	
    	//Mettre le service dans le repertoire de service
    	this.repServices.put(String.valueOf(code), s);
    	
    	//Creer les seances associées et les mettre dans le repertoire de seance
    	HashMap<String,Seance> sub = s.addSeance();
    	this.repSeances.putAll(sub);
    	
    	//Afficher les codes de seances
    	System.out.println("Code de service:"+code+"\n");
    	String reply = s.printService();
    	System.out.print(reply);
    	}
    	
    }
    public void modifierService( String code, String champ, String value) {
	    //champs modifiable: heure prix capacite comment
	    if(champ.matches("prix|heure|capacite|comment")) {
	    	Services s = getService(code);
		    s.setContenu(champ, value);
		    repServices.replace(code, s);
	   }else {
	    	System.out.println("Le champ"+champ+"n'est pas modifiable individullement.\n Supprimer le service "+code+"et en créer un nouveau SVP.");
	   }
    	
    }
    
    /**
     * Méthode pour supprimer un service.
     * Prend le code de service et supprimer le service de répertoire de services.
     * Trouve les codes de séance commencé par le code de service et les supprimer de répertoire de séances.
     * 
     * @param code code de service de 3 chiffres
     */
    public void supService(String code){
	    this.repServices.remove(code);
	    this.repSeances.entrySet().removeIf(e -> e.getKey().substring(0, 3).equals(code));
    }
    
    
    
    public void inscritSeance(String numM, String codeSeance) {
    	Seance s = getSeance(codeSeance);
    	s.ajoutInscrit(numM);
    	replaceSeance(codeSeance, s);
    	s.printInscription(codeSeance, numM);
    	
    	if(!seanceInscrit.containsKey(numM)) {
        	List<Seance> inscritListe = new ArrayList<Seance>();
        	inscritListe.add(s);
        	this.seanceInscrit.put(numM, inscritListe);
        	
        }else {
        	List<Seance> inscritListe = seanceInscrit.get(numM);
        	inscritListe.add(s);
        	this.seanceInscrit.replace(numM, inscritListe);
        }
    	
    }
    
    public void consultInscrit(String numP,String codeSeance) {
    	Seance s = getSeance(codeSeance);
    	if(s.getContenu("numP").equals(numP)) {
    		System.out.println( s.getContenu("inscriptions"));
    	}else {
    		System.out.println("Le numéro de professionnel ne correspond pas à la code de séance.");
    	}
    }
    public void confirmPresence(String numM, String codeSeance) {
    	Seance sc = getSeance(codeSeance);
    	List<String> membreInscrits = sc.getInscrit();
    	if (membreInscrits.contains(numM)) {
    		sc.ajoutPresence(numM);
    		String numP = sc.getContenu("numP");
    		if(!seanceFournie.containsKey(numP)) {
   	    		List<Seance> fournit = new ArrayList<Seance>();
	    		fournit.add(sc);
	    		seanceFournie.put(numP, fournit);
    		}else {
    			List<Seance> fournit = seanceFournie.get(numP);
    			fournit.add(sc);
    			seanceFournie.replace(numP, fournit);
    		}
    		System.out.println("Présence confirmée,");
    	}else{
    		System.out.println("Numéro de membre invalide.");
    	}
    }
    public void printRepService() {
    	String result = "";
    	for(Services s : getRepService().values()) {
    		String service = s.printService();
    		result += service+"\n";
    	}
    	System.out.print(result);
    }
}

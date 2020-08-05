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
    
    public void ajoutService(String code, String titre, String numPro, String debut, String fin, String heure, String jour,
            String capacite, String prix, String comment) {
    	
    	if(getService(code) != null){
    		System.out.print("Code de service existe déja");
    		
    	}else {
    		
    	//Creer le service
    	Services s = new Services(Integer.parseInt(code),titre,numPro,debut,fin,heure,Integer.parseInt(jour),Integer.parseInt(capacite),Double.parseDouble(prix),comment);
    	
    	//Mettre le service dans le repertoire de service
    	this.repServices.put(String.valueOf(code), s);
    	
    	//Creer les seances associées et les mettre dans le repertoire de seance
    	HashMap<String,Seance> sub = s.addSeance();
    	this.repSeances.putAll(sub);
    	
    	//Afficher les codes de seances
    	String reply = "Numéros des séances: "+printKeys(sub);
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
    
    public void supService(String code){
	    this.repServices.remove(code);
	    this.repSeances.entrySet().removeIf(e -> e.getKey().substring(0, 3).equals(code));
    }
    
    
    
    public String printKeys(HashMap<String, Seance> sub) {
    	String result="";
    	
    	for ( String key : sub.keySet() ) {
    	    result += "\n"+key;
    	}
		return result;
    	
    }
    public void inscritSeance(String numM, String codeSeance) {
    	Seance s = getSeance(codeSeance);
    	s.ajoutInscrit(numM);
    	replaceSeance(codeSeance, s);
    	
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
    
    public String consultInscrit(String numP,String codeSeance) {
    	Seance s = getSeance(codeSeance);
    	if(s.getContenu("numP").equals(numP)) {
    		return s.getContenu("inscriptions");
    	}else {
    		return "Le numéro de professionnel ne correspond pas à la code de séance.";
    	}
    }
    public boolean confirmPresence(String numM, String codeSeance) {
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
    		return true;
    	}else{
    		return false;
    	}
    }
}

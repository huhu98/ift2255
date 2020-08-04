import java.util.*;

public class ServiceControl {
    private HashMap<String, Seance> seances = new HashMap<String, Seance>();
    private HashMap<String, List<Seance>> seanceInscrit = new HashMap<String, List<Seance>>();
    private HashMap<String, List<Seance>> seanceFournie = new HashMap<String, List<Seance>>();

    public String ajoutService(int code, String titre, String numPro, String debut, String fin, String heure, int jour,
            int capacite, double prix, String comment) {
    	
    	String reply = "";
		return reply;
    	
    }
    public String afficheService(String codeSeance) {
    	String s = "";
		return s;
    	
    }
    /*    public String ajoutService(String codeSeance, Services service) {
            services.put(codeSeance, service);
            System.out.println(services.toString());
            return services.toString();
        }
        public void creerSeances(titre,numPro,debut,fin, heure,jour,capacite,prix,comment){
            service = new Services(titre,numPro,debut,fin,heure,jour,capacite,prix,comment);
            System.out.println(service.toString());
            return service;
        }
        

    public void modifierService(String champ, String codeSeance, String value) {
        if (seances.containsKey(codeSeance)) {
            Service s1 = seances.get(codeSeance);
            s1.setContenu(champ, value);
            seances.replace(codeSeance, s1);
            System.out.println(seances.toString());
        }
    }

    public void supService(String codeSeance, Services service) {
        seances.remove(codeSeance, service);
        System.out.println(seances.toString());
    }

    public Services getService(String codeSeance) {
        return seances.get(codeSeance);
    }

    public String toStringHashMap(Temps date) {//temps date?
        return seances.toString();
    }

    public void inscritSeance(String numM, String codeSeance) {
        seanceInscrit.put(numM, Collections.singletonList(codeSeance));
    }

    public void consultInscrit(String numPro, Services service) {
        seanceFournie.put(numPro, Collections.singletonList(service));
    }

    public boolean confirmPresence(String numM) {
        return seanceInscrit.containsKey(numM);
    }
    
*/
}

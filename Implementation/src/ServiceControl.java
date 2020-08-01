import java.util.*;

public class ServiceControl extends Services {
    private HashMap<String, Services> services = new HashMap<String, Services>();
    private HashMap<String, List<String>> seanceInscrit = new HashMap<String, List<String>>();
    private HashMap<String, List<Services>> seanceFournie = new HashMap<String, List<Services>>();
    private ArrayList <String> codeService = new ArrayList<String>();

    public ServiceControl(String titre, String numPro, Temps debut, Temps fin, Temps heure, Temps semaine, int capacite, double prix, String code, Presence presences, boolean serviceExiste, Temps date) {
        super(titre, numPro, debut, fin, heure, semaine, capacite, prix, code, presences, serviceExiste, date);
    }
    // rendre code seance etc.. private
    public String ajoutService(String codeSeance, Services service) {
        services.put(codeSeance, service);
        System.out.println(services.toString());
        return services.toString();
    }
    public Services creerSeances(String codeSeance, Services service, String titre, String numPro, Temps debut, Temps fin, Temps heure, Temps semaine, int capacite, double prix, String code, Presence presences, boolean serviceExiste, Temps date) {
        service = new Services(titre, numPro, debut, fin, heure, semaine, capacite, prix, code, presences, serviceExiste, date);
        System.out.println(service.toString());
        return service;
    }
    public void putService(String codeSeance, Services service){
        services.put(codeSeance,service);
        System.out.println(services.toString());
    }
    public void modifieService(String champ, String codeSeance, String value){
        if(services.containsKey(codeSeance)) {
            Services s1 = services.get(codeSeance);
            s1.setContenu(champ, value);
            services.replace(codeSeance, s1);
            System.out.println(services.toString());
        }
    }
    public void supService(String codeSeance, Services service){
        services.remove(codeSeance, service);
        System.out.println(services.toString());
    }
    public Services getService(String codeSeance) { return services.get(codeSeance); }
    public String toStringHashMap(Temps date) {//temps date?
        return services.toString();
    }
    public void insrcitSeance(String numM, String codeSeance) {
        seanceInscrit.put(numM, Collections.singletonList(codeSeance));
    }
    public void consultInscrit(String numPro , Services service) {
        seanceFournie.put(numPro, Collections.singletonList(service));
    }
    public boolean confirmPresence(String numM) {
        return seanceInscrit.containsKey(numM);
    }

}

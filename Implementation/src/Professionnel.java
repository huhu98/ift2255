import java.util.HashMap;

public class Professionnel extends Client {

    private HashMap<String, String> services = new HashMap<String, String>();
    //private Numero serviceCode; public?


    public Professionnel(String nom, String adresse,String ville, String province, String codePostal, String email) {
        super(nom, adresse, ville, province, codePostal, email);
        this.services = services;
    }

    public void addSeance(String code, String titre) {
        services.put(code, titre);
    }
}

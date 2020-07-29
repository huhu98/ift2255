import java.util.HashMap;

public class Professionnel extends Client {

    private HashMap<Numero, String> services = new HashMap<Numero, String>();
    //private Numero serviceCode; public?


    public Professionnel(String nom, String adresse, String email, String codePostal, String ville, String province) {
        super(nom, adresse, email, codePostal, ville, province);
        this.services = services;
    }

    public void addSeance(Numero code, String titre) {
      services.put(code, titre);
    }
}

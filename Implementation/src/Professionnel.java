import java.util.HashMap;

/**
 * @author Maxime Lechasseur
 * Classe qui sert à créer une Professionnel.
 */
public class Professionnel extends Client {

    private HashMap<String, String> services = new HashMap<String, String>();
    //private Numero serviceCode; public?

    /**
     * Constructeur d'un nouveau professionnel.
     * @param nom
     * @param adresse
     * @param ville
     * @param province
     * @param codePostal
     * @param email
     */
    public Professionnel(String nom, String adresse,String ville, String province, String codePostal, String email) {
        super(nom, adresse, ville, province, codePostal, email);
        this.services = services;
    }

    /**
     * Methode qui ajoute un service dans le HashMap services d'un professionnel.
     * @param code
     * @param titre
     */
    public void addSeance(String code, String titre) {
        services.put(code, titre);
    }
}

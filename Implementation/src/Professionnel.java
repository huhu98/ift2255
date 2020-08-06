/**
 * @author Maxime Lechasseur
 * Classe qui sert à créer une Professionnel.
 */
public class Professionnel extends Client {

    /**
     * Constructeur d'un nouveau professionnel.
     *
     * @param nom
     * @param adresse
     * @param ville
     * @param province
     * @param codePostal
     * @param email
     */
    public Professionnel(String nom, String adresse, String ville, String province, String codePostal, String email) {
        super(nom, adresse, ville, province, codePostal, email);
    }
}

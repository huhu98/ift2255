/**
 * @author Maxime Lechasseur
 * Classe qui sert à créer une Membre.
 */
public class Membre extends Client {

    private boolean suspendu = false;
    private Services[] services;

    /**
     * Constructeur d'un nouveau membre.
     * @param nom
     * @param adresse
     * @param ville
     * @param province
     * @param codePostal
     * @param email
     * @param suspendu
     */
    public Membre(String nom, String adresse,String ville, String province, String codePostal, String email, boolean suspendu) {
        super(nom, adresse, ville, province, codePostal, email);
        this.suspendu = suspendu;
    }

    /**
     * Methode qui gère l'état de l'inscription du membre.
     * @return un boolean.
     */
    public boolean estSuspendu() {
        suspendu = true;
        return this.suspendu;
    }

    public boolean getSuspendu(boolean suspendu) {
        return suspendu;
    }

}

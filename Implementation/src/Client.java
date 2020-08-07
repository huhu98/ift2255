/**
 * @author Maxime Lechasseur
 * Classe abstraite qui sert à créer un Client.
 */
public abstract class Client {
    private String nom;
    private String adresse;
    private String email;
    private String codePostal;
    private String province;
    private String ville;

    /**
     * Constructeur d'un nouveau client.
     *
     * @param nom
     * @param adresse
     * @param ville
     * @param province
     * @param codePostal
     * @param email
     */
    public Client(String nom, String adresse, String ville, String province, String codePostal, String email) {
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.email = email;
        this.nom = nom;
        this.ville = ville;
        this.province = province;
    }

    public String getContenu(String champ) {
        String val = "";
        switch (champ) {
            case "nom":
                val = this.nom;
                break;
            case "adresse":
                val = this.adresse;
                break;
            case "email":
                val = this.email;
                break;
            case "codePostal":
                val = this.codePostal;
                break;
            case "ville":
                val = this.ville;
                break;
            case "province":
                val = this.province;
                break;
        }
        return val;
    }

    public void setContenu(String champ, String value) {
        switch (champ) {
            case "nom":
                this.nom = value;
                break;
            case "adresse":
                this.adresse = value;
                break;
            case "email":
                this.email = value;
                break;
            case "codePostal":
                this.codePostal = value;
                break;
            case "ville":
                this.ville = value;
                break;
            case "province":
                this.province = value;
                break;
        }
    }

}

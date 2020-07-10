public class Membre {
    private String nom;
    private String adresse;
    private String email;
    private String codePostal;
    private boolean suspendu = false;

    public Membre(String nom, String adresse, String email, String codePostal){
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.codePostal = codePostal;
    }

    public boolean isSuspendu() {
        return suspendu;
    }
}

public class Membre extends Client {

    private boolean suspendu = false;
    private Services[] services;

    // besoin de plus d'info sur ce que membre va faire exemple : numero(meme?)
    public Membre(String nom, String adresse,String ville, String province, String codePostal, String email, boolean suspendu) {
        super(nom, adresse, ville, province, codePostal, email);
        this.suspendu = suspendu;
    }

    public boolean estSuspendu() {
        suspendu = true;
        return this.suspendu;
    }

    public boolean getSuspendu(boolean suspendu) {
        return suspendu;
    }

}

public class Membre extends Client {

    private boolean suspendu = false;
    private Services[] services;
// besoin de plus d'info sur ce que membre va faire exemple : numero(meme?)
    public Membre(String nom, String adresse, String email, String codePostal, String numero, String ville, String province, boolean suspendu) {
        super(nom, numero, email, adresse, ville, codePostal, province);
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

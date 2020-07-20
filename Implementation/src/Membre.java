public class Membre {

    private boolean suspendu = false;
    private Services[] services;

    public Membre(String nom, String adresse, String email, String codePostal) {

    }

    public boolean estSuspendu() {
        return this.suspendu;
    }
}

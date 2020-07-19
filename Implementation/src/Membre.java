public class Membre {
    private boolean suspendu = false;
    private Inscription[] inscriptions;

    public Membre(String nom, String adresse, String email, String codePostal) {

    }

    public boolean estSuspendu() {
        return this.suspendu;
    }
}

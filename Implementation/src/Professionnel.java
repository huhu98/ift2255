public class Professionnel extends Client {

    private Services[] services;

    public Professionnel(String nom, String adresse, String email, String codePostal) {
        super(nom, adresse, email, codePostal);
    }

    public void addSeance(Services services) {

    }
}

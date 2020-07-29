import java.util.HashMap;

public class ClientControl extends Client{
    private HashMap<String, Membre> membres = new HashMap<String, Membre>();
    private HashMap<String, Professionnel> pro = new HashMap<String, Professionnel>();
    private String nom;
    private String adresse;
    private String email;
    private String codePostal;
    private String ville;
    private String province;
    private boolean suspendu;

    public ClientControl(String nom, String adresse, String email, String codePostal, String ville, String province) {
        super(nom, adresse, email, codePostal, ville, province);
        this.membres = membres;
        this.pro = pro;
    }
    
    public String ajoutMembre(String numM, Membre membre) {
        membre = new Membre(nom, adresse, email, codePostal, ville, province, suspendu);
        membres.put(numM, membre);
        return membres.toString();
    }

    public String ajoutPro(String numP, Professionnel professionnel) {
        professionnel = new Professionnel(nom, adresse, email, codePostal, ville, province);
        pro.put(numP, professionnel);
        return pro.toString();
    }

    public void modifierMembre(String champ, String numM, String value) {
        if(membres.containsKey(numM)) {
            Membre m1 = membres.get(numM);
            m1.setContenu(champ, value);
            membres.replace(numM, m1);
        }
    }

    public void modifierPro(String champ, String numP, String value) {
        if(membres.containsKey(numP)) {
            Professionnel p1 = pro.get(numP);
            p1.setContenu(champ, value);
            pro.replace(numP, p1);
        }
    }

    public void supMembre(String numM) { membres.remove(numM); }

    public void supPro(String numP) { pro.remove(numP); }

    public Membre getMembre(String numM) { return membres.get(numM); }

    public Professionnel getPro(String numP) { return pro.get(numP); }

    public boolean validationNumM(String numM) { return membres.containsKey(numM); }

    public boolean validationNumP(String numP) { return pro.containsKey(numP);}

}

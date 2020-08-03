import java.util.HashMap;

public class ClientControl {
    private HashMap<String, Membre> membres = new HashMap<String, Membre>();
    private HashMap<String, Professionnel> pro = new HashMap<String, Professionnel>();

   /* public ClientControl() {
        this.membres = new HashMap<>();
        this.pro = new HashMap<>();
    }*/


    public String ajoutMembre(String nom, String adresse, String email, String codePostal, String ville, String province) {
        Membre membre = new Membre(nom, adresse, email, codePostal, ville, province, false);
        String numM = Numero.genererNum(9);
        membres.put(numM, membre);
        System.out.println(membres);
        return membres.toString();
    }

    public String ajoutPro(String nom, String adresse, String email, String codePostal, String ville, String province) {
        Professionnel professionnel = new Professionnel(nom, adresse, email, codePostal, ville, province);
        String numP = Numero.genererNum(9);
        pro.put(numP, professionnel);
        System.out.println(pro);
        return pro.toString();
    }

    public void modifierMembre(String champ, String numM, String value) {
        if (membres.containsKey(numM)) {
            Membre m1 = membres.get(numM);
            m1.setContenu(champ, value);
            membres.replace(numM, m1);
            System.out.println(membres);
        }
    }

    public void modifierPro(String champ, String numP, String value) {
        if (membres.containsKey(numP)) {
            Professionnel p1 = pro.get(numP);
            p1.setContenu(champ, value);
            pro.replace(numP, p1);
            System.out.println(pro);
        }
    }

    public void supMembre(String numM) {
        membres.remove(numM);
    }

    public void supPro(String numP) {
        pro.remove(numP);
    }

    public Membre getMembre(String numM) {
        return membres.get(numM);
    }

    public Professionnel getPro(String numP) {
        return pro.get(numP);
    }

    public boolean validationNumM(String numM) {
        return membres.containsKey(numM);
    }

    public boolean validationNumP(String numP) {
        return pro.containsKey(numP);
    }

}

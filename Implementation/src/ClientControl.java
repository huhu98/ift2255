import java.util.HashMap;

public class ClientControl {
    private HashMap<String, Membre> membres = new HashMap<String, Membre>();
    private HashMap<String, Professionnel> pro = new HashMap<String, Professionnel>();

    public String ajoutMembre(String nom, String adresse,String ville, String province, String codePostal, String email) {
        Membre membre = new Membre(nom, adresse, ville, province, codePostal, email, false);
        String numM = Numero.genererNum(9);
        membres.put(numM, membre);
        return numM;
    }

    public String ajoutPro(String nom, String adresse,String ville, String province, String codePostal, String email) {
        Professionnel professionnel = new Professionnel(nom, adresse, ville, province, codePostal, email);
        String numP = Numero.genererNum(7);
        String digit =  ""+ pro.size();
        if (digit.length() == 1) {
            digit = "0" + digit;
        }
        numP += digit;
        pro.put(numP, professionnel);
        return numP;
    }

    public void modifierMembre(String numM, String champ, String value) {
        if (membres.containsKey(numM)) {
            Membre m1 = membres.get(numM);
            m1.setContenu(champ, value);
            membres.replace(numM, m1);
        }
    }

    public void modifierPro(String numP, String champ, String value) {
        if (pro.containsKey(numP)) {
            Professionnel p1 = pro.get(numP);
            p1.setContenu(champ, value);
            pro.replace(numP, p1);
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
    public String afficheMembre(String numM) {
        Membre m = this.getMembre(numM);
        String nom = "nom: "+m.getContenu("nom");
        String adresse ="adresse: "+ m.getContenu("adresse");
        String ville = "ville: "+m.getContenu("ville");
        String province ="province: " +m.getContenu("province");
        String codeP = "code postal: " + m.getContenu("codePostal");
        String email = "email:"+ m.getContenu("email");
        String result = nom+"\n"+adresse+"\n"+ville+"\n"+province+"\n"+codeP+"\n"+email;
        return result;
    }

    public String affichePro(String numP) {
        Professionnel p1 = this.getPro(numP);
        String nom = "nom: "+p1.getContenu("nom");
        String adresse ="adresse: "+ p1.getContenu("adresse");
        String ville = "ville: "+p1.getContenu("ville");
        String province ="province: " +p1.getContenu("province");
        String codeP = "code postal: " + p1.getContenu("codePostal");
        String email = "email:"+ p1.getContenu("email");
        String result = nom+"\n"+adresse+"\n"+ville+"\n"+province+"\n"+codeP+"\n"+email;
        return result;
    }

    public void testMembre() {
        for (String key: membres.keySet()) {
            System.out.println("key : " + key);
            System.out.println("value : " + membres.get(key));
        }
    }

    public void testPro() {
        for (String key: pro.keySet()) {
            System.out.println("key : " + key);
            System.out.println("value : " + pro.get(key));
        }
    }

}

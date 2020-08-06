import java.util.HashMap;

/**
 * @author Maxime Lechasseur
 * Classe qui sert à la gestion des informations des membres et professionnels
 */
public class ClientControl {
    private HashMap<String, Membre> membres = new HashMap<String, Membre>();
    private HashMap<String, Professionnel> pro = new HashMap<String, Professionnel>();

    /**
     * Methode qui ajoute un membre dans le HashMap membres.
     * @param nom
     * @param adresse
     * @param ville
     * @param province
     * @param codePostal
     * @param email
     * @return le numero du membre.
     */
    public String ajoutMembre(String nom, String adresse,String ville, String province, String codePostal, String email) {
        Membre membre = new Membre(nom, adresse, ville, province, codePostal, email, false);
        String numM = Numero.genererNum(9);
        membres.put(numM, membre);
        return numM;
    }

    /**
     * Methode qui ajoute un pro dans le HashMap pro incluant une clé de 9 chiffres et ses informations.
     * @param nom
     * @param adresse
     * @param ville
     * @param province
     * @param codePostal
     * @param email
     * @return Le numéro assigné au professionnel sous la forme d'un string.
     */
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

    /**
     * Méthode qui permet de modifier les informations a l'intérieur du HashMap membres.
     * @param numM
     * @param champ Attribut que l'on veut changer dans le membre.
     * @param value La nouvelle valeur attribuée.
     */
    public void modifierMembre(String numM, String champ, String value) {
        if (membres.containsKey(numM)) {
            Membre m1 = membres.get(numM);
            m1.setContenu(champ, value);
            membres.replace(numM, m1);
        }
    }

    /**
     * Méthode qui permet de modifier les informations a l'intérieur du HashMap pro.
     * @param numP
     * @param champ Attribut que l'on veut changer dans le professionnel.
     * @param value La nouvelle valeur attribuée.
     */
    public void modifierPro(String numP, String champ, String value) {
        if (pro.containsKey(numP)) {
            Professionnel p1 = pro.get(numP);
            p1.setContenu(champ, value);
            pro.replace(numP, p1);
        }
    }

    /**
     * Méthode qui permet de supprimer un membre de notre choix.
     * @param numM
     */
    public void supMembre(String numM) {
        membres.remove(numM);
    }

    /**
     * Méthode qui permet de supprimer un professionnel de notre choix.
     * @param numP
     */
    public void supPro(String numP) {
        pro.remove(numP);
    }

    public Membre getMembre(String numM) {
        return membres.get(numM);
    }

    public Professionnel getPro(String numP) {
        return pro.get(numP);
    }

    /**
     * Méthode qui valide la présence du numéro du membre dans le HashMap membres.
     * @param numM
     * @return Un boolean sur l'état de la présence du numéro.
     */
    public boolean validationNumM(String numM) {
        return membres.containsKey(numM);
    }

    /**
     * Méthode qui valide la présence du numéro du professionnel dans le HashMap pro.
     * @param numP
     * @return Un boolean sur l'état de la présence du numéro.
     */
    public boolean validationNumP(String numP) {
        return pro.containsKey(numP);
    }

    /**
     * Méthode qui confirme les informations entrés lors d'ajoutMembre.
     * @author Qiao Wang
     * @param numM numéro de membre
     * @return Les informations explicites du membre entrés
     */
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

    /**
     * Méthode qui confirme les informations entrés lors d'ajoutPro.
     * @param numP
     * @return Les informations explicites du professionnel entrés
     */
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

    /**
     * Methode qui test le HashMap membres en assurant la presence d'un membre avec un numero comme key.
     * affiche la clé et la valeur du membre dans le HashMap.
     */
    public void printRepMembres() {
        for (String key: membres.keySet()) {
            System.out.println(afficheMembre(key));
        }
    }

    /**
     * Methode qui test le HashMap pro en assurant la presence d'un pro avec un numero comme key.
     * affiche la clé et la valeur du professionnel dans le HashMap.
     */
    public void printRepPros() {
        for (String key: pro.keySet()) {
            System.out.println(affichePro(key));
        }
    }
    
    public HashMap<String, Membre> getRepMembre(){
    	HashMap<String, Membre> m = this.membres;
    	return m;
    }
    
    public HashMap<String, Professionnel> getRepPro(){
    	HashMap<String, Professionnel> p = this.pro;
    	return p;
    }
    
    /**
     * Methode pour l'authentification d'un membre
     * @author Qiao Wang
     * @param numM	numéro de membre
     * @param email	courriel de membre
     */
    public void validationAcces(String numM,String email) {
    	if(validationNumM(numM)) {
	    	Membre m = getMembre(numM);
	    	String courriel = m.getContenu("email");
	    	String nom = m.getContenu("nom");
	    	if(courriel.equals(email)) {
	    		System.out.println("Validé.\n Bonjour, "+nom+".");
	    	}else {
	    		System.out.println("Courriel invalide.");
	    	}
    	}else {
    		System.out.println("Numéro de membre invalide.");
    	}
    }

}

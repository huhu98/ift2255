import java.util.*;

/**
 * @author Qiao Wang
 */
public class ServiceControl {
    private HashMap<String, Seance> repSeances = new HashMap<String, Seance>();
    private HashMap<String, Services> repServices = new HashMap<String, Services>();
    private HashMap<String, List<Seance>> seanceInscrit = new HashMap<String, List<Seance>>();
    private HashMap<String, List<Seance>> seanceFournie = new HashMap<String, List<Seance>>();
    private Numero numero;

    /**
     * @return le répertoire des séances
     */
    public HashMap<String, Seance> getRepSeance() {
        HashMap<String, Seance> rs = this.repSeances;
        return rs;
    }

    /**
     * @return le répertoire des services
     */
    public HashMap<String, Services> getRepService() {
        HashMap<String, Services> rss = this.repServices;
        return rss;
    }

    /**
     * @return le répertoire des séances inscrites par les membres
     */
    public HashMap<String, List<Seance>> getRepInscrit() {
        HashMap<String, List<Seance>> ri = this.seanceInscrit;
        return ri;
    }

    /**
     * @return le répertoire des séances fournies par les professionnels
     */
    public HashMap<String, List<Seance>> getRepFournie() {
        HashMap<String, List<Seance>> rf = this.seanceFournie;
        return rf;
    }

    public Services getService(String code) {
        Services s = this.repServices.get(code);
        return s;
    }

    public Seance getSeance(String codeSeance) {
        Seance s = this.repSeances.get(codeSeance);
        return s;
    }

    /**
     * Mise à jour de séance dans le répertoire de séances
     *
     * @param codeSeance code de séance
     * @param s          la nouvelle séance
     */
    public void replaceSeance(String codeSeance, Seance s) {
        this.repSeances.replace(codeSeance, s);
    }

    /**
     * Déterminer si le service existe
     *
     * @param code code de service
     * @return true si le répertoire de service contient le code de service comme clé,
     * false sinon.
     */
    public boolean serviceExist(String code) {
        return this.repServices.containsKey(code);
    }

    /**
     * Déterminer si la séance existe
     *
     * @param code code de séance
     * @return true si le répertoire de séance contient le code de séance comme clé,
     * false sinon.
     */
    public boolean seanceExist(String code) {
        return this.repSeances.containsKey(code);
    }

    /**
     * Générer le code de service
     *
     * @return le code de service en 3 chiffres
     */
    public String serviceCode() {
        return Numero.genererNum(3);
    }

    /**
     * Méthode pour ajouter un service dans le répertoire de service
     * Générer un code de service tant qu'il est unique
     * Créer le service avec les attributs passés en argument
     * Mettre le service dans le répertoire de service
     * Mettre ses séances associées dans le répertoire de séance
     * Afficher le service avec ses attributs et ses codes de séances
     *
     * @param titre
     * @param numPro   numéro de professionnel
     * @param debut    la date du début de service
     * @param fin      la date du fin de service
     * @param heure    l'heure que le service aura lieu
     * @param jour     le jour de semaine que le service aura lieu
     * @param capacite l'espace maximale pour les inscriptions
     * @param prix     le frais d'une séance
     * @param comment  commentaire facultatif
     */
    public void ajoutService(String titre, String numPro, String debut, String fin, String heure, String jour, String capacite, String prix, String comment) {

        String code = serviceCode();
        while (serviceExist(code)) {
            code = serviceCode();
        }

        //Creer le service
        Services s = new Services(code, titre, numPro, debut, fin, heure, Integer.parseInt(jour), Integer.parseInt(capacite), Double.parseDouble(prix), comment);

        //Mettre le service dans le repertoire de service
        this.repServices.put(String.valueOf(code), s);

        //Creer les seances associées et les mettre dans le repertoire de seance
        HashMap<String, Seance> sub = s.addSeance();
        this.repSeances.putAll(sub);

        //Afficher les codes de seances
        System.out.println("Code de service:" + code);
        String reply = s.printService();
        System.out.print(reply);
    }

    /**
     * Méthode pour mettre à jour les attributs d'un service
     *
     * @param code  code de service en 3 chiffres
     * @param champ le champ à changer
     * @param value la nouvelle valeur du champ
     */
    public void modifierService(String code, String champ, String value) {
        //champs modifiable: heure prix capacite comment
        if (champ.matches("prix|heure|capacite|comment")) {
            Services s = getService(code);
            s.setContenu(champ, value);
            repServices.replace(code, s);
        } else {
            System.out.println("Le champ" + champ + "n'est pas modifiable individullement.\n Supprimer le service " + code + "et en créer un nouveau SVP.");
        }

    }

    /**
     * Méthode pour supprimer un service.
     * Prend le code de service et supprimer le service de répertoire de services.
     * Trouve les codes de séance commencé par le code de service et les supprimer de répertoire de séances.
     *
     * @param code code de service de 3 chiffres
     */
    public void supService(String code) {
        this.repServices.remove(code);
        this.repSeances.entrySet().removeIf(e -> e.getKey().substring(0, 3).equals(code));
    }


    /**
     * Méthode pour inscrire un membre à une séance
     * Mettre à jour la liste d'inscription de la séance
     * Mettre à jour la répertoire de séance
     * Ajouter le numéro de membre et la séance dans le HashMap seanceInscrit
     *
     * @param numM       numéro de membre
     * @param codeSeance code de séance en 7 chiffres
     */
    public void inscritSeance(String numM, String codeSeance) {
        Seance s = getSeance(codeSeance);
        s.ajoutInscrit(numM);
        replaceSeance(codeSeance, s);
        System.out.println(s.printInscription(codeSeance, numM));

        if (!seanceInscrit.containsKey(numM)) {
            List<Seance> inscritListe = new ArrayList<Seance>();
            inscritListe.add(s);
            this.seanceInscrit.put(numM, inscritListe);

        } else {
            List<Seance> inscritListe = seanceInscrit.get(numM);
            inscritListe.add(s);
            this.seanceInscrit.replace(numM, inscritListe);
        }
    }

    /**
     * Méthode pour consulter les inscriptions à une séance
     *
     * @param numP       numéro de professionnel
     * @param codeSeance code de séance en 7 chiffres
     */
    public void consultInscrit(String numP, String codeSeance) {
        Seance s = getSeance(codeSeance);
        if (s.getContenu("numP").equals(numP)) {
            System.out.println("Membre inscrits: " + s.getContenu("inscriptions"));
        } else {
            System.out.println("Le numéro de professionnel ne correspond pas à la code de séance.");
        }
    }

    /**
     * Méthode pour confirmer la présence d'un membre à une séance
     * Si le membre est dans le répertoire des séances inscrities,
     * mettre la séance dans le le répertoire des séances fournie pour le professionnel.
     * Afficher la confirmation.
     * Sinon, afficher le raison.
     *
     * @param numM       numéro de membre
     * @param codeSeance code de séance en 7 chiffres
     */
    public void confirmPresence(String numM, String codeSeance) {
        Seance sc = getSeance(codeSeance);
        List<String> membreInscrits = sc.getInscrit();
        if (membreInscrits.contains(numM)) {
            sc.ajoutPresence(numM);
            String numP = sc.getContenu("numP");
            if (!seanceFournie.containsKey(numP)) {
                List<Seance> fournit = new ArrayList<Seance>();
                fournit.add(sc);
                seanceFournie.put(numP, fournit);
            } else {
                List<Seance> fournit = seanceFournie.get(numP);
                fournit.add(sc);
                seanceFournie.replace(numP, fournit);
            }
            System.out.println("Présence confirmée,");
            System.out.println(sc.printInscription(codeSeance, numM));
        } else {
            System.out.println("Numéro de membre invalide.");
        }
    }

    /**
     * Afficher le répertoire de service
     */
    public void printRepService() {
        String result = "";
        for (Services s : getRepService().values()) {
            String service = s.printService();
            result += service + "\n";
        }
        System.out.print(result);
    }
}

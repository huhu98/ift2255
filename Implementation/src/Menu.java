import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Devoir 2 IFT 2255
 * Maxime Lechasseur 20129433
 * Qiao Wang 20095140
 * Han Zhang 20144330
 */
public class Menu {
	private ClientControl clientControl = new ClientControl();
    private ServiceControl serviceControl =new ServiceControl();
    
    /**
     * Le menu principale
     */
	public void menuMain() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------\n" +
		"------------------------------  Accueil  -----------------------------\n" +
        "----------------------------------------------------------------------\n\n" +
        "Veuillez choisir l'action voulue en entrant le numéro correspondant et\n" +
        "appuyez ensuite sur ENTER :\n\n" +
        "1 - Application mobile\n" +
        "2 - Centre de Données #GYM\n" +
        "quitter - pour quitter\n"
        );
        System.out.print("Action voulue: \n");
        
        while (true) {
            switch (scanner.nextLine()) {
                case "1": {
                	menuMobile(scanner);
                	break;
                }
                case "2":{
                	menuComptoir(scanner);
                	break;
                }
                case "quitter": {
                    System.out.println("Fermeture du programme #GYM");
                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Erreur, veuiller réessayer.");
                }
            }
        }
	}
	
	/**
	 * Le menu pour le comptoir de #GYM
	 * @param scanner 
	 */
	public void menuComptoir(Scanner scanner) {
		String bienvenuGYM = "----------------------------------------------------------------------\n" +
                "----------------------  Centre de Données #GYM  ----------------------\n" +
                "----------------------------------------------------------------------\n\n" +
                "Veuillez choisir l'action voulue en entrant le numéro correspondant et\n" +
                "appuyez ensuite sur ENTER :\n\n" +
                "1 - ajouter/mettre à jour/supprimer un membre\n" +
                "2 - ajouter/mettre à jour/supprimer un service\n" +
                "3 - ajouter/mettre à jour/supprimer un professionel\n" +
                "4 - inscription à un service\n" +
                "5 - confirmer la présence à une séance\n" +
                "6 - consulter les inscriptions\n" +
                "7 - procédure comptable\n" +
                "quitter - pour quitter\n";
        System.out.println(bienvenuGYM);
        System.out.print("Action voulue: \n");
        
        while (true) {
            switch (scanner.nextLine()) {
                case "1": {
                	gestionMembre(scanner);
                	break;	
                }
                case "2":{
                	gestionService(scanner);
                	break;
                }
                case "3":{
                	gestionPro(scanner);
                	break;
                }
                case "4":{
                	inscriptSeance(scanner);
                	break;
                }
                case "5":{
                	confirmPresence(scanner);
                	break;
                }
                case "6":{
                	consultInscrit(scanner);
                	break;
                }
                case "7":{
                	procedureComptable(scanner);
                	break;
                }
                case "quitter": {
                    System.out.println("Fermeture du programme #GYM");
                    scanner.close();
                    return;
                }
                default:
                    System.out.println("Erreur, veuiller réessayer.");
            
            }
        }
	}
	
	/**
	 * Le menu pour l'app mobile
	 * @param scanner 
	 */
	public void menuMobile(Scanner scanner) {
	}
			
	/**
	 * Le sous-menu pour la gestion de membre
	 * Interagit entre l'utilisateur et le Centre de donnée pour les membres
	 * @param scanner
	 */
	public void gestionMembre(Scanner scanner) {
		System.out.println("Vous avez choisi : ajouter/mettre à jour/supprimer un membre\n" +
                "Veuillez choisir l'action voulue en entrant la lettre correspondante et\n" +
                "appuyez ensuite sur ENTER :\n" +
                "a - ajouter un membre\n" +
                "b - mettre à jour un membre\n" +
                "c - supprimer un membre\n" +
                "quitter - pour quitter\n"
        );
        System.out.print("Action voulue: \n");
        switch (scanner.nextLine()) {
	        case "a": {
	        	String[] membreInfo = ajoutClient(scanner);
	        	System.out.println("Ajout confirmé, voici le numéro du membre :");
	            String numeroM = clientControl.ajoutMembre(membreInfo[0], membreInfo[1], membreInfo[2], membreInfo[3], membreInfo[4], membreInfo[5]);
	            System.out.println(numeroM);
	            System.out.println(clientControl.afficheMembre(numeroM));
	            break;
	        }
	        case "b": {
	        	String num = verifieNum(scanner);
	        	if(num.equals("error")) {
	        		System.out.println("Invalide.");
	        		break;
	        	}
	        	String[] membreMAJ = modifieClient(num,scanner);
	            clientControl.modifierMembre(membreMAJ[0], membreMAJ[1], membreMAJ[2]);
	            System.out.println("Mise à jour du membre confirmée");
	            System.out.println(clientControl.afficheMembre(membreMAJ[0]));
	        	break;
	        }
	        case "c":{
	        	String num = verifieNum(scanner);
	        	if(num.equals("error")) {
	        		System.out.println("Invalide.");
	        		break;
	        	}
	        	supClient(num, scanner);
	        	break;
	        }
	        case "quitter": {
	        	System.out.println("Fermeture du programme #GYM");
	            return;
	        }
	        default:
	        	System.out.println("Erreur, veuiller réessayer.");
	    }
	}
	
	/**
	 * Le sous-menu pour la gestion de pro.
	 * Interagit entre l'utilisateur et le Centre de donnée pour les professionnels
	 * @param scanner
	 */
	public void gestionPro(Scanner scanner) {
		System.out.println("Vous avez choisi : ajouter/mettre à jour/supprimer un professionnel\n" +
                "Veuillez choisir l'action voulue en entrant la lettre correspondante et\n" +
                "appuyez ensuite sur ENTER :\n" +
                "a - ajouter un professionnel\n" +
                "b - mettre à jour un professionnel\n" +
                "c - supprimer un professionnel\n" +
                "quitter - pour quitter\n"
        );

        System.out.print("Action voulue: \n");
        switch (scanner.nextLine()) {
        
        case "a": {
        	String[] proInfo = ajoutClient(scanner);
        	System.out.println("Ajout confirmé, voici le numéro du professionnel :");
            String numeroP = clientControl.ajoutPro(proInfo[0], proInfo[1], proInfo[2],proInfo[3], proInfo[4], proInfo[5]);
            System.out.println(numeroP);
            System.out.println(clientControl.afficheMembre(numeroP));
            break;
    		
        }
        case "b": {
        	String num = verifieNum(scanner);
        	if(num.equals("error")) {
        		System.out.println("Invalide.");
        		break;
        	}
        	String[] proMAJ = modifieClient(num,scanner);
            clientControl.modifierPro(proMAJ[0], proMAJ[1], proMAJ[2]);
            System.out.println("Mise à jour du professionnel confirmée");
            System.out.println(clientControl.afficheMembre(proMAJ[0]));
        	break;
        }
        case "c":{
        	String num = verifieNum(scanner);
        	if(num.equals("error")) {
        		System.out.println("Invalide.");
        		break;
        	}
        	supClient(num, scanner);
        }
        case "quitter": {
        	System.out.println("Fermeture du programme #GYM");
            return;
        }
        default:
        	System.out.println("Erreur, veuiller réessayer.");
    	}
	}
	
	/**
	 * Le sous-menu pour la gestion des services
	 * Interagit entre l'utilisateur et la répertoire de services
	 * @param scanner
	 */
	private void gestionService(Scanner scanner) {
		System.out.println("Vous avez choisi : ajouter/mettre à jour/supprimer un service\n" +
                "Veuillez choisir l'action voulue en entrant la lettre correspondante et\n" +
                "appuyez ensuite sur ENTER :\n" +
                "a - ajouter un service\n" +
                "b - mettre à jour un service\n" +
                "c - supprimer un service\n" +
                "quitter - pour quitter\n"
        );
        System.out.print("Action voulue: \n");
        switch (scanner.nextLine()) {
	        case "a": {
	        	ajoutService(scanner);
	        	break;
	        }
	        case "b":{
	        	modifieService(scanner);
	        	break;
	        }
	        case "c":{
	        	supService(scanner);
	        	break;
	        }
	        case "quitter": {
                System.out.println("Fermeture du programme #GYM");
                return;
            }
            default:
                System.out.println("Erreur, veuiller réessayer.");
        }
	}
	
	
	/**
	 * l'option ajouter un service
	 * @param scanner
	 */
	public void ajoutService(Scanner scanner) {
		String[] serviceInfo = new String[8];
        System.out.println("Veuillez entrer le titre du service :");
        serviceInfo[0] = scanner.nextLine();
        System.out.println("Veuillez entrer le numéro du professionnel :");
        String numPro = scanner.nextLine();
        while (numPro.length() != 9) {
            System.out.println(
                    "Erreur, le numéro du membre est composé de 9 chiffres\n" +
                            "Veuillez réessayer :");
            numPro = scanner.nextLine();
        }
        serviceInfo[1] = numPro;
        System.out.println("Veuillez entrer le début du service (JJ-MM-AAAA):");
        serviceInfo[2] = scanner.nextLine();
        System.out.println("Veuillez entrer la fin du service (JJ-MM-AAAA):");
        serviceInfo[3] = scanner.nextLine();
        System.out.println("Veuillez entrer l'heure du service (HH:MM) :");
        serviceInfo[4] = scanner.nextLine();
        System.out.println("Veuillez entrer la récurrence hebdomadaire en numéro(1:lundi, 2:mardi,...) :");
        serviceInfo[5] = scanner.nextLine();
        System.out.println("Veuillez entrer la capacité maximale (max 30) :");
        serviceInfo[6] = scanner.nextLine();
        System.out.println("Veuillez entrer le prix (max 100.0$) :");
        serviceInfo[7] = scanner.nextLine();
        System.out.println("Veuillez entrer les commentaires pour ce service :");
        serviceInfo[8] = scanner.nextLine();
        System.out.println("Ajout confirmé, voici le code de service et les code de séances associées:");
        serviceControl.ajoutService(serviceInfo[0], serviceInfo[1],serviceInfo[2],serviceInfo[3],serviceInfo[4], serviceInfo[5], serviceInfo[6], serviceInfo[7], serviceInfo[8]);
		
	}
	
	/**
	 * l'option modifier un service
	 * @param scanner
	 */
	private void modifieService(Scanner scanner) {
		String[] serviceMAJ = new String[3];
        System.out.println("Veuillez entrer le numéro du service de 3 chiffres:");
        serviceMAJ[0] = scanner.nextLine();
        System.out.println("Veuillez entrer un des champs ci-dessous que vous voulez changer :\n heure\n prix\n capacite\n comment");
        serviceMAJ[1] = scanner.nextLine();
        System.out.println("Veuillez entrer la nouvelle valeur voulue :");
        serviceMAJ[2] = scanner.nextLine();
        if(serviceControl.serviceExist(serviceMAJ[0])) {
	        serviceControl.modifierService(serviceMAJ[0], serviceMAJ[1], serviceMAJ[2]);
	        System.out.println("Mise à jour du service confirmée");
	        
        }else {
        	System.out.println("Code de service Invalide");
        }
		
	}
	
	/**
	 * l'option supprimer un service
	 * @param scanner
	 */
	public void supService(Scanner scanner) {
		 System.out.println("Veuillez entrer le numéro du service à supprimer");
		 String codeSupp =scanner.nextLine();
		 if(serviceControl.serviceExist(codeSupp)) {
			 serviceControl.supService(codeSupp);
	         System.out.println("Service supprimé.");
		 }else {
			 System.out.println("Code de service Invalide");
		 }
	}

	/**
	 * l'option ajouter un client
	 * @param scanner 
	 */
	public String[] ajoutClient(Scanner scanner) {
		
		String[] membreInfo = new String[6];

        System.out.println("Veuillez entrer son nom :");
        String nom = scanner.nextLine();
        while (nom.length() > 25) {
            System.out.println(
                    "Erreur, le nom doit comporter 25 lettres maximum.\n" +
                            "Veuillez réessayer :");
            nom = scanner.nextLine();
        }
        membreInfo[0] = nom;

        System.out.println("Veuillez entrer son adresse :");
        String adresse = scanner.nextLine();
        while (adresse.length() > 25) {
            System.out.println(
                    "Erreur, l'adresse doit comporter 25 caractères maximum.\n" +
                            "Veuillez réessayer :");
            adresse = scanner.nextLine();
        }
        membreInfo[1] = adresse;
        
        System.out.println("Veuillez entrer sa ville :");
        String ville = scanner.nextLine();
        while (ville.length() > 14) {
            System.out.println(
                    "Erreur, la ville doit comporter 14 caractères maximum.\n" +
                            "Veuillez réessayer :");
            ville = scanner.nextLine();
        }
        membreInfo[2] = ville;

        System.out.println("Veuillez entrer sa province :");
        String province = scanner.nextLine();
        while (province.length() > 2) {
            System.out.println(
                    "Erreur, la ville doit comporter 2 caractères maximum.\n" +
                            "Veuillez réessayer :");
            province = scanner.nextLine();
        }
        membreInfo[3] = province;
        
        System.out.println("Veuillez entrer son codePostal :");
        String codePostal = scanner.nextLine();
        while (codePostal.length() > 6) {
            System.out.println(
                    "Erreur, le code postal doit comporter 6 caractères maximum.\n" +
                            "Veuillez réessayer :");
            codePostal = scanner.nextLine();
        }
        membreInfo[4] = codePostal;

        System.out.println("Veuillez entrer son email :");
        String email = scanner.nextLine();
        if (null != email) {
            String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            while (!((Matcher) matcher).matches()) {
                System.out.println("Erreur le courriel doit être sous la forme qui suit - Hanlanouille@hotmail.ca :");
                email = scanner.nextLine();
                matcher = pattern.matcher(email);
            }
        }
        membreInfo[5] = email;
        
        return membreInfo;
		
	}
	
	/**
	 * l'option mofidier un client
	 * @param num 
	 * @param scanner 
	 * @return les cod
	 */
	public String[] modifieClient(String num, Scanner scanner) {
		String[] membreMAJ = new String[3];
        membreMAJ[0] = num;

        System.out.println("Veuillez choisir le champ que vous voulez modifier :\n" +
                "a - nom\n" +
                "b - adresse\n" +
                "c - email\n" +
                "d - codePostal\n" +
                "e - ville\n" +
                "f - province"
        );

        String champ = "";
        String champScan = scanner.nextLine();
        while (!champScan.equals("a") && !champScan.equals("b") && !champScan.equals("c") && !champScan.equals("d") && !champScan.equals("e") && !champScan.equals("f")) {
            System.out.println(
                    "Erreur, vous devez choisir un des champs suivants :\n" +
                            "a - nom\n" +
                            "b - adresse\n" +
                            "c - email\n" +
                            "d - codePostal\n" +
                            "e - ville\n" +
                            "f - province\n" +
                            "Veuillez réessayer :");
            champScan = scanner.nextLine();
        }

        switch (champScan) {
            case "a": {
                champ = "nom";
                break;
            }
            case "b": {
                champ = "adresse";
                break;
            }
            case "c": {
                champ = "email";
                break;
            }
            case "d": {
                champ = "codePostal";
                break;
            }
            case "e": {
                champ = "ville";
                break;
            }
            case "f": {
                champ = "province";
                break;
            }
        }

        membreMAJ[1] = champ;
        System.out.println("Veuillez choisir la nouvelle valeur voulue :");
        String res = scanner.nextLine();
        switch (champ) {
            case "nom": {
                while (res.length() > 25) {
                    System.out.println(
                            "Erreur, le nom doit comporter 25 lettres maximum.\n" +
                                    "Veuillez réessayer :");
                    res = scanner.nextLine();
                }
                membreMAJ[2] = res;
                break;
            }
            case "adresse": {
                while (res.length() > 25) {
                    System.out.println(
                            "Erreur, l'adresse doit comporter 25 caractères maximum.\n" +
                                    "Veuillez réessayer :");
                    res = scanner.nextLine();
                }
                membreMAJ[2] = res;
                break;
            }
            case "email": {
                if (null != res) {
                    String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(res);
                    while (!((Matcher) matcher).matches()) {
                        System.out.println("Erreur le courriel doit être sous la forme qui suit - Hanlanouille@hotmail.ca :");
                        res = scanner.nextLine();
                        matcher = pattern.matcher(res);
                    }
                }
                membreMAJ[2] = res;
                break;
            }
            case "codepostal": {
                while (res.length() > 6) {
                    System.out.println(
                            "Erreur, le code postal doit comporter 6 caractères maximum.\n" +
                                    "Veuillez réessayer :");
                    res = scanner.nextLine();
                }
                membreMAJ[2] = res;
                break;
            }
            case "ville": {
                while (res.length() > 14) {
                    System.out.println(
                            "Erreur, la ville doit comporter 14 caractères maximum.\n" +
                                    "Veuillez réessayer :");
                    res = scanner.nextLine();
                }
                membreMAJ[2] = res;
                break;
            }
            case "province": {
                while (res.length() > 2) {
                    System.out.println(
                            "Erreur, la ville doit comporter 2 caractères maximum.\n" +
                                    "Veuillez réessayer :");
                    res = scanner.nextLine();
                }
                membreMAJ[2] = res;
                break;
            }
        }
        membreMAJ[2] = res;
        System.out.println(Arrays.toString(membreMAJ));
        return membreMAJ;
		
	}
	
	/**
	 * l'option supprimer un client
	 */
	public void supClient(String numSupp,Scanner scanner) {
		
		if(clientControl.validationNumM(numSupp)) {
			clientControl.supMembre(numSupp);
		}else if(clientControl.validationNumP(numSupp)) {
			clientControl.supPro(numSupp);
		}
		System.out.println("Membre supprimé.");
	}
	
	/**
	 * Verifier si le numero de membre ou de professionnel existe
	 * @param scanner 
	 * @return le numero de membre ou de professionnel s'il existe,
	 * 		   "error" sinon. 		
	 */
	public String verifieNum(Scanner scanner) {
		System.out.println("Veuillez entrez votre numéro de membre/pro");
		String numero = scanner.nextLine();
        while (numero.length() != 9) {
            System.out.println(
                    "Erreur, le numéro doit comporter 9 chiffres.\n" +
                            "Veuillez réessayer :");
            numero = scanner.nextLine();
        }
        if(clientControl.validationNumM(numero)|| clientControl.validationNumP(numero)) {
        	System.out.println("Validé.");
        	return numero;
        }else { 
        	return "error";
        }
	}
	/**
	 * l'option inscrire à une séance
	 * @param scanner
	 */
	public void inscriptSeance(Scanner scanner) {
		String[] inscription = new String[2];
        System.out.println("Vous avez choisi : inscription à une service\n"
        					+"Voici le Répertoire des Services\n");
        consultService();
        System.out.println("Veuillez enter le code de séance choisi par le membre :");
        inscription[0] = scanner.nextLine();
        System.out.println("Numéro du membre :");
        inscription[1] = scanner.nextLine();
        if(clientControl.validationNumM(inscription[1])&& serviceControl.seanceExist(inscription[0])) {
        	serviceControl.inscritSeance(inscription[0], inscription[1]);
        }else {
        	System.out.println("Code de séance ou le numéro du membre invalide.");
        }
	}
	
	/**
	 * l'option consulter la répertoire des services
	 */
	public void consultService() {
		serviceControl.printRepService();
	}
	
	/**
	 * l'option consulter les inscriptions pour une séance
	 * @param scanner
	 */
	public void consultInscrit(Scanner scanner) {
		String[] consultation = new String[2];
        System.out.println("Vous avez choisi : consulter les inscriptions");
        System.out.println("Numéro du professionnel :");
        consultation[0] = scanner.nextLine();
        System.out.println("Numéro de la séance :");
        consultation[1] = scanner.nextLine();
        if(serviceControl.seanceExist(consultation[1])) {
        	serviceControl.consultInscrit(consultation[0], consultation[1]);
        }else {
        	System.out.println("Code de séance invalide.");
        }
	}
	
	/**
	 * l'option confirmer la présence d'un membre pour une séance
	 * @param scanner
	 */
	public void confirmPresence(Scanner scanner) {
		String[] confirmation = new String[2];
        System.out.println("Vous avez choisi : confirmer la présence à une séance\n");
        System.out.println("Numéro du membre :");
        confirmation[0] = scanner.nextLine();
        System.out.println("Numéro de la séance :");
        confirmation[1] = scanner.nextLine();
        
        if(serviceControl.seanceExist(confirmation[0])) {
            serviceControl.confirmPresence(confirmation[0], confirmation[1]);
        }else {
        	System.out.println("Code de séance invalide.");
        }
	}
	
	/**
	 * le sous-menu de prpcédure comptable
	 * @param scanner
	 */
	private void procedureComptable(Scanner scanner) {
		System.out.println("Vous avez choisi : procédure comptable");
		
	}
	
	/**
	 * l'option générer un rapport synthèse de la semaine
	 */
	public void rapportSeamine(Scanner scanner) {
		
	}
	
	/**
	 * l'option générer des fichier TEF pour les professionnels
	 */
	public void rapportTEF(Scanner scanner) {
		
	}
	
	/**
	 * l'option générer la facture pour chaque membre
	 */
	public void recuClient(Scanner scanner) {
		
	}
	
	/**
	 * l'option générer la facture pour chaque professionnel
	 */
	public void recuPro(Scanner scanner) {
		
	}
}
    
import java.util.Scanner;

/**
 * Devoir 2 IFT 2255
 * Maxime Lechasseur 20129433
 * Qiao Wang 20095140
 * Han Zhang 20144330
 */
public class Main {

    public static void main(String[] args) {
        Centre centre = new Centre();
        Scanner scanner = new Scanner(System.in);
        String bienvenu = "\n" +
                "----------------------------------------------------------------------\n" +
                "----------------------  Centre de Données #GYM  ----------------------\n" +
                "----------------------------------------------------------------------\n\n" +
                "Veuillez choisir l'action voulue en entrant le numéro correspondant et\n" +
                "appuyez ensuite sur ENTER :\n\n" +
                "1 - ajouter/mettre à jour/supprimer un membre\n" +
                "2 - ajouter/mettre à jour/supprimer un service\n" +
                "3 - inscription à un service\n" +
                "4 - confirmer la présence à une séance\n" +
                "5 - consulter les inscriptions\n" +
                "6 - procédure comptable\n" +
                "quitter - pour quitter\n";
        System.out.println(bienvenu);

        System.out.print("Action voulue: \n");
        while (true) {
            switch (scanner.nextLine()) {
                case "1": {
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
                            String[] membreInfo = new String[4];
                            System.out.println("Veuillez entrer son nom :");
                            membreInfo[0] = scanner.nextLine();
                            System.out.println("Veuillez entrer son adresse :");
                            membreInfo[1] = scanner.nextLine();
                            System.out.println("Veuillez entrer son email :");
                            membreInfo[2] = scanner.nextLine();
                            System.out.println("Veuillez entrer son codePostal :");
                            membreInfo[3] = scanner.nextLine();
                            System.out.println("Ajout confirmé, voici son numéro de membre :");
//                            centre.ajoutClient(membreInfo[0],membreInfo[1],membreInfo[2],membreInfo[3]);
                            System.out.println(bienvenu);
                            break;
                        }
                        case "b": {
                            String[] membreMAJ = new String[3];
                            System.out.println("Veuillez entrer son numéro de membre :");
                            membreMAJ[0] = scanner.nextLine();
                            System.out.println("Veuillez choisir un des champs ci dessous que vous voulez changer :" +
                                    "nom, adresse, email, codePostal");
                            membreMAJ[1] = scanner.nextLine();
                            System.out.println("Veuillez choisir la nouvelle valeur voulue :");
                            membreMAJ[2] = scanner.nextLine();
//                            centre.modifierClient(membreMAJ[0], membreMAJ[1], membreMAJ[2]);
                            System.out.println("Mise à jour du membre confirmée");
                            System.out.println(bienvenu);
                            break;
                        }
                        case "c": {
                            System.out.println("Veuillez entrer numéro de membre à supprimer");
                            String numero = scanner.nextLine();
//                            centre.supClient(scanner.nextLine());
                            System.out.println("Membre supprimé.");
                            System.out.println(bienvenu);
                            break;
                        }
                        case "quitter": {
                            System.out.println("Fermeture du programme #GYM");
                            return;
                        }
                        default:
                            System.out.println("Erreur, veuiller réessayer.");
                    }
                    break;
                }
                case "2": {
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
                            String[] serviceInfo = new String[8];
                            System.out.println("Veuillez entrer le titre du service :");
                            serviceInfo[0] = scanner.nextLine();
                            System.out.println("Veuillez entrer le numéro du professionnel :");
                            serviceInfo[1] = scanner.nextLine();
                            System.out.println("Veuillez entrer le début du service (JJ-MM-AAAA):");
                            serviceInfo[2] = scanner.nextLine();
                            System.out.println("Veuillez entrer la fin du service (JJ-MM-AAAA):");
                            serviceInfo[3] = scanner.nextLine();
                            System.out.println("Veuillez entrer l'heure du service (HH:MM) :");
                            serviceInfo[4] = scanner.nextLine();
                            System.out.println("Veuillez entrer la récurrence hebdomadaire :");
                            serviceInfo[5] = scanner.nextLine();
                            System.out.println("Veuillez entrer la capacité maximale (max 30) :");
                            serviceInfo[6] = scanner.nextLine();
                            System.out.println("Veuillez entrer le prix (max 100$) :");
                            serviceInfo[7] = scanner.nextLine();
                            System.out.println("Ajout confirmé, voici le numéro de service :");
//                            centre.ajoutClient(membreInfo[0],membreInfo[1],membreInfo[2],membreInfo[3]);
                            System.out.println(bienvenu);
                            break;
                        }
                        case "b": {
                            String[] serviceMAJ = new String[3];
                            System.out.println("Veuillez entrer le numéro du service :");
                            serviceMAJ[0] = scanner.nextLine();
                            System.out.println("Veuillez choisir un des champs ci dessous que vous voulez changer :" +
                                    "titre, numPro, debut, fin, heure, semaine, capacite, prix");
                            serviceMAJ[1] = scanner.nextLine();
                            System.out.println("Veuillez choisir la nouvelle valeur voulue :");
                            serviceMAJ[2] = scanner.nextLine();
//                            centre.modifierService(serviceMAJ[0], serviceMAJ[1], serviceMAJ[2]);
                            System.out.println("Mise à jour du service confirmée");
                            System.out.println(bienvenu);
                        }
                        case "c": {
                            System.out.println("Veuillez entrer le numéro du service à supprimer");
                            String service = scanner.nextLine();
//                            centre.supClient(scanner.nextLine());
                            System.out.println("Service supprimé.");
                            System.out.println(bienvenu);
                            break;
                        }
                        case "quitter": {
                            System.out.println("Fermeture du programme #GYM");
                            return;
                        }
                        default:
                            System.out.println("Erreur, veuiller réessayer.");
                    }
                    break;
                }
                case "3": {
                    String[] inscription = new String[2];
                    System.out.println("Vous avez choisi : inscription à une service\n");
                    System.out.println("Voici les services offerts : ");
                    System.out.println("1234567 - badminton\n");
                    System.out.println("Service choisi par le membre :");
                    inscription[0] = scanner.nextLine();
                    System.out.println("Numéro du membre :");
                    inscription[1] = scanner.nextLine();
//                    centre.inscritSeance(inscription[0], inscription[1]);
                    System.out.println("Le membre est inscrit.");
                    System.out.println(bienvenu);
                    break;
                }
                case "4": {
//                    System.out.println(java.time.LocalDate.now()); pour la date
//                    System.out.println(java.time.LocalTime.now()); pour l'heure
                    String[] confirmation = new String[2];
                    System.out.println("Vous avez choisi : confirmer la présence à une séance\n");
                    System.out.println("Numéro du membre :");
                    confirmation[0] = scanner.nextLine();
                    System.out.println("Numéro de la séance :");
                    confirmation[1] = scanner.nextLine();
//                    centre.confirmPresence(confirmation[0], java.time.LocalDate.now(), confirmation[1]);
                    System.out.println("Présence confirmée");
                    System.out.println(bienvenu);
                    break;
                }
                case "5": {
                    String[] consultation = new String[2];
//                    consultInscrit(String numPro, String code)
                    System.out.println("Vous avez choisi : consulter les inscriptions");
                    System.out.println("Numéro du professionnel :");
                    consultation[0] = scanner.nextLine();
                    System.out.println("Numéro de la séance :");
                    consultation[1] = scanner.nextLine();
//                    centre.consultInscrit(consultation[0],consultation[1]);
                    System.out.println(bienvenu);
                    break;
                }
                case "6": {
                    System.out.println("Vous avez choisi : procédure comptable");
//                    System.out.println(centre.comptable());
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
}

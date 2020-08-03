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
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientControl clientControl = new ClientControl();
        ServiceControl serviceControl = new ServiceControl();

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
                    System.out.println("----------------------------------------------------------------------\n" +
                            "------------------------  Application Mobile  ------------------------\n" +
                            "----------------------------------------------------------------------\n\n" +
                            "Veuillez choisir l'action voulue en entrant le numéro correspondant et\n" +
                            "appuyez ensuite sur ENTER :\n\n" +
                            "1 - Accès à l'interface membre\n" +
                            "2 - Accès à l'interface professionnel\n" +
                            "quitter - pour quitter\n");
                    switch (scanner.nextLine()) {
                        case "1": {

                            //on verifie le numero du membre first

                            System.out.println("----------------------------------------------------------------------\n" +
                                    "-------------------------  Interface Membre  -------------------------\n" +
                                    "----------------------------------------------------------------------\n\n" +
                                    "Veuillez choisir l'action voulue en entrant le numéro correspondant et\n" +
                                    "appuyez ensuite sur ENTER :\n\n" +
                                    "1"
                            );

                            break;
                        }
                        case "2": {

                            //on verifie le numero du professionnel first

                            System.out.println("----------------------------------------------------------------------\n" +
                                    "------------------------  Application Mobile  ------------------------\n" +
                                    "----------------------------------------------------------------------\n\n" +
                                    "Veuillez choisir l'action voulue en entrant le numéro correspondant et\n" +
                                    "appuyez ensuite sur ENTER :\n\n" +
                                    "1"
                            );
                            break;
                        }
                        case "quitter": {
                            System.out.println("Fermeture de l'application mobile");
                            return;
                        }
                        default: {
                            System.out.println("Erreur, veuiller réessayer.");
                        }
                    }

                    break;
                }
                case "2": {
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
                                        String adresseM = scanner.nextLine();
                                        while (adresseM.length() > 25) {
                                            System.out.println(
                                                    "Erreur, l'adresse doit comporter 25 caractères maximum.\n" +
                                                            "Veuillez réessayer :");
                                            adresseM = scanner.nextLine();
                                        }
                                        membreInfo[1] = adresseM;

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
                                        System.out.println("Veuillez entrer son codePostal :");
                                        String codePostal = scanner.nextLine();
                                        while (codePostal.length() > 6) {
                                            System.out.println(
                                                    "Erreur, le code postal doit comporter 6 caractères maximum.\n" +
                                                            "Veuillez réessayer :");
                                            codePostal = scanner.nextLine();
                                        }
                                        membreInfo[4] = codePostal;

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

                                        System.out.println("Ajout confirmé, voici le numéro du membre :");
                                        String numeroM = clientControl.ajoutMembre(membreInfo[0], membreInfo[1], membreInfo[2], membreInfo[3], membreInfo[4], membreInfo[5]);
                                        System.out.println(numeroM);
                                        System.out.println(clientControl.afficheMembre(numeroM));
                                        System.out.println(bienvenuGYM);
                                        break;
                                    }
                                    case "b": {
                                        String[] membreMAJ = new String[3];
                                        System.out.println("Veuillez entrer le numéro du membre :");

                                        String numM = scanner.nextLine();
                                        while (numM.length() != 9) {
                                            System.out.println(
                                                    "Erreur, le numéro du membre est composé de 9 chiffres\n" +
                                                            "Veuillez réessayer :");
                                            numM = scanner.nextLine();
                                        }
                                        //TODO
                                        //il faut verifier si le numero existe
                                        membreMAJ[0] = numM;

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
                                        clientControl.modifierMembre(membreMAJ[0], membreMAJ[1], membreMAJ[2]);
                                        System.out.println("Mise à jour du membre confirmée");
                                        System.out.println(clientControl.afficheMembre(membreMAJ[0]));
                                        System.out.println(bienvenuGYM);
                                        break;
                                    }
                                    case "c": {
                                        System.out.println("Veuillez entrer numéro du membre à supprimer");
                                        String numSupp = scanner.nextLine();
                                        while (numSupp.length() != 9) {
                                            System.out.println(
                                                    "Erreur, le numéro du membre est composé de 9 chiffres\n" +
                                                            "Veuillez réessayer :");
                                            numSupp = scanner.nextLine();
                                        }

                                        //verifier numero

                                        clientControl.supMembre(numSupp);
                                        System.out.println("Membre supprimé.");
                                        System.out.println(bienvenuGYM);
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
                                        String[] proInfo = new String[6];
                                        System.out.println("Veuillez entrer son nom :");
                                        String nom = scanner.nextLine();
                                        while (nom.length() > 25) {
                                            System.out.println(
                                                    "Erreur, le nom doit comporter 25 lettres maximum.\n" +
                                                            "Veuillez réessayer :");
                                            nom = scanner.nextLine();
                                        }
                                        proInfo[0] = nom;

                                        System.out.println("Veuillez entrer son adresse :");
                                        String adresseM = scanner.nextLine();
                                        while (adresseM.length() > 25) {
                                            System.out.println(
                                                    "Erreur, l'adresse doit comporter 25 caractères maximum.\n" +
                                                            "Veuillez réessayer :");
                                            adresseM = scanner.nextLine();
                                        }
                                        proInfo[1] = adresseM;

                                        System.out.println("Veuillez entrer son email :");
                                        proInfo[5] = scanner.nextLine();

                                        System.out.println("Veuillez entrer son codePostal :");
                                        String codePostal = scanner.nextLine();
                                        while (codePostal.length() > 6) {
                                            System.out.println(
                                                    "Erreur, le code postal doit comporter 6 caractères maximum.\n" +
                                                            "Veuillez réessayer :");
                                            codePostal = scanner.nextLine();
                                        }
                                        proInfo[4] = codePostal;

                                        System.out.println("Veuillez entrer sa ville :");
                                        String ville = scanner.nextLine();
                                        while (ville.length() > 14) {
                                            System.out.println(
                                                    "Erreur, la ville doit comporter 14 caractères maximum.\n" +
                                                            "Veuillez réessayer :");
                                            ville = scanner.nextLine();
                                        }
                                        proInfo[2] = ville;

                                        System.out.println("Veuillez entrer sa province :");
                                        String province = scanner.nextLine();
                                        while (province.length() > 2) {
                                            System.out.println(
                                                    "Erreur, la ville doit comporter 2 caractères maximum.\n" +
                                                            "Veuillez réessayer :");
                                            province = scanner.nextLine();
                                        }
                                        proInfo[3] = province;

                                        System.out.println("Ajout confirmé, voici le numéro de professionnel :");
                                        String numeroP = clientControl.ajoutPro(proInfo[0], proInfo[1], proInfo[2], proInfo[3], proInfo[4], proInfo[5]);
                                        System.out.println(numeroP);
                                        System.out.println(clientControl.affichePro(numeroP));
                                        System.out.println(bienvenuGYM);
                                        break;
                                    }
                                    case "b": {
                                        String[] proMAJ = new String[3];
                                        System.out.println("Veuillez entrer le numéro du professionnel :");

                                        String numP = scanner.nextLine();
                                        while (numP.length() != 9) {
                                            System.out.println(
                                                    "Erreur, le numéro du professionnel est composé de 9 chiffres\n" +
                                                            "Veuillez réessayer :");
                                            numP = scanner.nextLine();
                                        }
                                        //TODO
                                        //il faut verifier si le numero existe
                                        proMAJ[0] = numP;

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

                                        proMAJ[1] = champ;
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
                                                proMAJ[2] = res;
                                                break;
                                            }
                                            case "adresse": {
                                                while (res.length() > 25) {
                                                    System.out.println(
                                                            "Erreur, l'adresse doit comporter 25 caractères maximum.\n" +
                                                                    "Veuillez réessayer :");
                                                    res = scanner.nextLine();
                                                }
                                                proMAJ[2] = res;
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
                                                proMAJ[2] = res;
                                                break;
                                            }
                                            case "codepostal": {
                                                while (res.length() > 6) {
                                                    System.out.println(
                                                            "Erreur, le code postal doit comporter 6 caractères maximum.\n" +
                                                                    "Veuillez réessayer :");
                                                    res = scanner.nextLine();
                                                }
                                                proMAJ[2] = res;
                                                break;
                                            }
                                            case "ville": {
                                                while (res.length() > 14) {
                                                    System.out.println(
                                                            "Erreur, la ville doit comporter 14 caractères maximum.\n" +
                                                                    "Veuillez réessayer :");
                                                    res = scanner.nextLine();
                                                }
                                                proMAJ[2] = res;
                                                break;
                                            }
                                            case "province": {
                                                while (res.length() > 2) {
                                                    System.out.println(
                                                            "Erreur, la ville doit comporter 2 caractères maximum.\n" +
                                                                    "Veuillez réessayer :");
                                                    res = scanner.nextLine();
                                                }
                                                proMAJ[2] = res;
                                                break;
                                            }
                                        }
                                        proMAJ[2] = res;
                                        System.out.println(Arrays.toString(proMAJ));
                                        clientControl.modifierPro(proMAJ[0], proMAJ[1], proMAJ[2]);
                                        System.out.println("Mise à jour du professionnel confirmée");
                                        System.out.println(clientControl.affichePro(proMAJ[0]));
                                        System.out.println(bienvenuGYM);
                                        break;
                                    }
                                    case "c": {
                                        System.out.println("Veuillez entrer numéro du professionnel à supprimer");
                                        String numSupp = scanner.nextLine();
                                        while (numSupp.length() != 9) {
                                            System.out.println(
                                                    "Erreur, le numéro du professionnel est composé de 9 chiffres\n" +
                                                            "Veuillez réessayer :");
                                            numSupp = scanner.nextLine();
                                        }

                                        //verifier numero
                                        clientControl.supPro(numSupp);
                                        System.out.println("professionnel supprimé.");
                                        System.out.println(bienvenuGYM);
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
                                        String numPro = scanner.nextLine();
                                        while (numPro.length() != 9) {
                                            System.out.println(
                                                    "Erreur, le numéro du membre est composé de 9 chiffres\n" +
                                                            "Veuillez réessayer :");
                                            numPro = scanner.nextLine();
                                        }
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
                                        //ajoutService
                                        System.out.println(bienvenuGYM);
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
                                        serviceControl.modifierService(serviceMAJ[0], serviceMAJ[1], serviceMAJ[2]);
                                        System.out.println("Mise à jour du service confirmée");
                                        System.out.println(bienvenuGYM);
                                    }
                                    case "c": {
                                        System.out.println("Veuillez entrer le numéro du service à supprimer");
//                                      serviceControl.supService(scanner.nextLine());
                                        System.out.println("Service supprimé.");
                                        System.out.println(bienvenuGYM);
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
                            case "4": {
                                String[] inscription = new String[2];
                                System.out.println("Vous avez choisi : inscription à une service\n");
                                System.out.println("Voici les services offerts : ");
                                System.out.println("1234567 - badminton\n");
                                System.out.println("Service choisi par le membre :");
                                inscription[0] = scanner.nextLine();
                                System.out.println("Numéro du membre :");
                                inscription[1] = scanner.nextLine();
                                serviceControl.inscritSeance(inscription[0], inscription[1]);
                                System.out.println("Le membre est inscrit.");
                                System.out.println(bienvenuGYM);
                                break;
                            }
                            case "5": {
//                    System.out.println(java.time.LocalDate.now()); pour la date
//                    System.out.println(java.time.LocalTime.now()); pour l'heure
                                String[] confirmation = new String[2];
                                System.out.println("Vous avez choisi : confirmer la présence à une séance\n");
                                System.out.println("Numéro du membre :");
                                confirmation[0] = scanner.nextLine();
                                System.out.println("Numéro de la séance :");
                                confirmation[1] = scanner.nextLine();
//                    serviceControl.confirmPresence(confirmation[0], confirmation[1]);
                                System.out.println("Présence confirmée");
                                System.out.println(bienvenuGYM);
                                break;
                            }
                            case "6": {
                                String[] consultation = new String[2];
                                System.out.println("Vous avez choisi : consulter les inscriptions");
                                System.out.println("Numéro du professionnel :");
                                consultation[0] = scanner.nextLine();
                                System.out.println("Numéro de la séance :");
                                consultation[1] = scanner.nextLine();
//                                serviceControl.consultInscrit(consultation[0], consultation[1]);
                                System.out.println(bienvenuGYM);
                                break;
                            }
                            case "7": {
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
                case "quitter": {
                    System.out.println("Fermeture du programme #GYM");
                    return;
                }
                default: {
                    System.out.println("Erreur, veuiller réessayer.");
                }
            }
        }
    }
}

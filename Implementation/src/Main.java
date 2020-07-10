import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" +
                "----------------------------------------------------------------------\n" +
                "----------------------  Centre de Données #GYM  ----------------------\n" +
                "----------------------------------------------------------------------\n\n" +
                "Veuillez choisir l'action voulue en entrant le numéro correspondant et\n" +
                "ensuite appuyez sur ENTER :\n\n" +
                "1 - ajouter/mettre à jour/supprimer un membre\n" +
                "2 - ajouter/mettre à jour/supprimer un service\n" +
                "3 - inscription à une séance\n" +
                "4 - confirmer présence à une séance\n" +
                "5 - procédure comptable\n"
        );

        System.out.print("Action voulue: \n");
        while (true) {
            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("bravo");
                    String next = scanner.nextLine();
                    if (next.equals("1b")) {
                        System.out.println("woohooooo");
                    }
                    break;
                }
                case "2": {
                    System.out.println("hello");
                    break;
                }
                case "3": {
                    System.out.println("boo");
                    break;
                }
                case "close": {
                    System.out.println("Fermeture du programme #GYM");
                    return;
                }
                default:
                    System.out.println("Erreur, veuiller réessayer.");
            }
        }
    }
}

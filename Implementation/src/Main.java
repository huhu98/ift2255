import java.util.Scanner;

public class Main {

    static String numRandom(int longueur) {
        String x = "";
        for (int i = 0; i < longueur; i++) {
            int random = (int) (Math.random() * 10);
            x = x + random;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" +
                "----------------------------------------------------------------------\n" +
                "----------------------  Centre de Données #GYM  ----------------------\n" +
                "----------------------------------------------------------------------\n\n" +
                "Veuillez choisir l'action voulue en entrant le numéro correspondant et\n" +
                "ensuite appuyez sur ENTER :\n\n" +
                "1 -\n" +
                "2 -\n" +
                "3 -\n" +
                "4 -\n" +
                "5 -\n" +
                "6 -\n" +
                "7 -\n" +
                "8 -\n" +
                "9 -\n"
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

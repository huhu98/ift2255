public class Numero {

    private int longueur;

    public Numero(int longueur) {
        this.longueur = longueur;
    }

    public String getNumero() {
        return genererNum(longueur);
    }

    public static String genererNum(int longueur) {
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < longueur; i++) {
            int random = (int) (Math.random() * 10);
            num.append(random);
        }
        return num.toString();
    }

}

import java.io.*;
import java.util.*;

/**
 * Class pour les créations de fichiers
 *
 * @author Qiao
 */
public class Comptable {

    private final HashMap<String, Professionnel> pros;
    private final HashMap<String, List<Seance>> fournie;
    private final HashMap<String, List<Seance>> participe;
    private final HashMap<String, Services> repService;
    private final ClientControl cc;

    public Comptable(ClientControl cc, ServiceControl sc) {
        this.cc = cc;
        this.pros = cc.getRepPro();
        this.fournie = sc.getRepFournie();
        this.participe = sc.getRepInscrit();
        this.repService = sc.getRepService();

    }

    /**
     * Créer un fichier text pour chaque professionnel.
     */
    public void fichierTEF() {
        File dir = new File("TEF");
        dir.mkdirs();
        for (Map.Entry<String, List<Seance>> pair : fournie.entrySet()) {
            String[] tef = contenuTEF(pair);
            CreerFichier(dir, "TEF" + tef[1], tef[0]);
        }
    }

    /**
     * Le contenu de fichier TEF qui contient:
     * le nom du professionnel
     * le numéro du professionnel
     * le montant à lui transférer
     *
     * @param pair paire de numéro pro et la liste de séances
     * @return
     */
    public String[] contenuTEF(Map.Entry<String, List<Seance>> pair) {
        String[] tef = new String[2];
        String numP = pair.getKey();
        List<Seance> s = pair.getValue();
        Professionnel p = pros.get(numP);
        String nom = p.getContenu("nom");
        double montant = fraisPro(s);
        tef[0] = "le nom: " + nom + "\n" +
                "le numéro: " + numP + "\n" +
                "le montant à transférer: " + montant + "\n\n";
        tef[1] = numP;

        return tef;

    }


    /**
     * Créer un rapport décrit 	la liste de tous les professionnels qui doivent être payés cette semaine-là,
     * le nombre de services de chacun
     * le total de leurs frais pour cette semaine-là
     * <p>
     * À la fin du rapport:		total des frais
     */
    public void rapportSynthese() {
        File dir = new File("rapport");
        dir.mkdirs();
        String rapport = "";
        double total = 0;
        for (Map.Entry<String, List<Seance>> pair : fournie.entrySet()) {
            String[] tef = contenuTEF(pair);
            rapport += tef[0];

            List<Seance> s = pair.getValue();
            double montant = fraisPro(s);
            total += montant;
        }
        rapport += "Total de frais à transférer: " + total;
        CreerFichier(dir, "rapport", rapport);

    }

    /**
     * Nom du membre (25 lettres)
     * Numéro du membre (9 chiffres)
     * Adresse du membre (25 caractères)
     * Ville du membre (14 caractères)
     * Province du membre (2 lettres)
     * Code postal du membre (6 caractères).
     * Pour chaque service fourni, les détails suivants sont requis :
     * Date du service (JJ-MM-AAAA)
     * Nom du professionnel (25 lettres)
     * Nom du service (20 caractères).
     */
    public void factureClient() {
        File dir = new File("Facture_Client");
        dir.mkdirs();

        for (Map.Entry<String, List<Seance>> pair : participe.entrySet()) {
            String numM = pair.getKey();
            String info = cc.afficheMembre(numM);
            String facture = "\n";

            List<Seance> listSeance = pair.getValue();

            for (Seance s : listSeance) {
                if (Temps.dateInrange(Temps.mtn(), Temps.semProchaine(), s.getContenu("date"))) {
                    String date = s.getContenu("date");
                    String numP = s.getContenu("numP");
                    String nomP = pros.get(numP).getContenu("nom");
                    String codeService = s.getContenu("code").substring(0, 3);
                    Services service = repService.get(codeService);
                    String titre = service.getContenu("titre");
                    facture += "Date du service: " + date +
                            "\n Nom du professionnel: " + nomP +
                            "\n Nom du service: " + titre + "\n";
                }
            }
            facture = info + facture;
            CreerFichier(dir, "Facture_" + numM, facture);
        }
    }

    /**
     * Nom du professionnel (25 lettres)
     * Numéro du professionnel (9 chiffres)
     * Adresse du professionnel (25 caractères)
     * Ville du professionnel (14 caractères)
     * Province du professionnel (2 lettres)
     * Code postal du professionnel (6 caractères).
     * Pour chaque service fourni, les détails suivants sont requis :
     * Date et heure à laquelle les données étaient reçues par l'ordinateur (JJ-MM-AAAA HH:MM:SS)
     * Nom du membre (25 caractères)
     * Numéro du membre (9 chiffres)
     * Code de la séance (7 chiffres)
     * Montant à payer (jusqu'à 999.99$), si facturé par inscription, sinon un seul montant est affiché.
     */
    public void facturePro() {
        File dir = new File("Facture_Pro");
        dir.mkdirs();

        for (Map.Entry<String, List<Seance>> pair : fournie.entrySet()) {
            String numP = pair.getKey();
            String info = cc.affichePro(numP);
            String facture = "\n";

            List<Seance> listSeance = pair.getValue();

            for (Seance s : listSeance) {
                if (Temps.dateInrange(Temps.mtn(), Temps.semProchaine(), s.getContenu("date"))) {
                    String date = s.getContenu("date");
                    String numM = s.getContenu("presences");
                    String codeSeance = s.getContenu("code");
                    String prix = s.getContenu("prix");
                    facture += "Date du séance: " + date +
                            "\n Numéros des membres: " + numM +
                            "\n Code de la séance: " + codeSeance +
                            "\n Montant à payer: " + prix + "\n";
                }
            }
            facture = info + facture;
            CreerFichier(dir, "Facture_" + numP, facture);
        }

    }

    /**
     * Get le frais de séance
     *
     * @param codeSeance code de séance
     * @return le frais d'un séance
     */
    public double fraisSeance(String codeSeance) {
        String code = codeSeance.substring(0, 3);
        Services s = repService.get(code);
        double montant = Double.parseDouble(s.getContenu("prix"));
        return montant;
    }

    /**
     * Calculer le frais total à verser pour un pro pour ses services fournie dans la semaine
     *
     * @param listSeance liste de séances fournies
     * @return le frais total à verser pour un pro pour ses services fournie dans la semaine
     */
    public double fraisPro(List<Seance> listSeance) {
        double montant = 0;
        for (Seance s : listSeance) {
            if (Temps.dateInrange(Temps.mtn(), Temps.semProchaine(), s.getContenu("date"))) {
                String codeSeance = s.getContenu("code");
                montant += fraisSeance(codeSeance);
            }
        }
        return montant;
    }

    /**
     * Créer le fichier dans le disque
     *
     * @param dir      directoire
     * @param nomFiche nom de Fichier
     * @param contenu  le contenu dans le fichier
     */
    public void CreerFichier(File dir, String nomFiche, String contenu) {
        try {
            File f = new File(dir, nomFiche + ".txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenu);
            bw.flush();
            fw.close();
        } catch (IOException g) {
            g.printStackTrace();
            System.out.println("erreur fichier");
        }
    }
}


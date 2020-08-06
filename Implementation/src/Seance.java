import java.time.*;
import java.util.*;

/**
 * @author Qiao Wang
 */
public class Seance {

    private LocalDate date;
    private List<String> inscriptions = new ArrayList<String>();
    private List<String> presences = new ArrayList<String>();
    private String numP;
    private String code;

    public Seance(LocalDate date, String numP, String code) {
        this.numP = numP;
        this.date = date;
        this.code = code;

    }

    /**
     * Ajouter le numéro de membre à la liste de présence
     *
     * @param numM numéro de membre
     */
    public void ajoutPresence(String numM) {
        presences.add(numM);
    }

    /**
     * Ajouter le numéro de membre à la liste des inscriptions
     *
     * @param numM numéro de membre
     */
    public void ajoutInscrit(String numM) {
        inscriptions.add(numM);
    }

    public List<String> getPresence() {
        return this.presences;
    }

    public List<String> getInscrit() {
        return this.inscriptions;
    }

    public String getContenu(String champ) {
        String value = "";
        switch (champ) {
            case "presences":
                value = String.join("\n", getPresence());
                break;
            case "inscriptions":
                value = String.join("\n", getInscrit());
                break;
            case "date":
                value = this.date.toString();
                break;
            case "numP":
                value = this.numP;
                break;
            case "code":
                value = this.code;
                break;
            default:
                value = null;
        }
        return value;
    }

    /**
     * Afficher les détails de séance et le numéro de membre
     * pour former un confirmation d'inscription
     *
     * @param codeSeance code séance
     * @param numM numéro de membre
     * @return affichage de confirmation d'inscription
     */
    public String printInscription(String codeSeance, String numM) {
        String recu = "Date et heure actuelles: " + Temps.mtn() +
                "\nDate à laquelle du service qui sera fourni: " + getContenu("date") +
                "\nNuméro du professionnel: " + getContenu("numP") +
                "\nNuméro du membre: " + numM +
                "\nCode de la séance " + getContenu("code");

        return recu;
    }
}

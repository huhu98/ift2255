import java.time.*;
import java.util.*;

public class Seance {

    private LocalDate date;
    private List<String> inscriptions = new ArrayList<String>();
    private List<String> presences = new ArrayList<String>();

    public Seance(LocalDate date) {
        this.date = date;

    }

    public void ajoutPresence(String numM) {
        presences.add(numM);
    }

    public void ajoutInscrit(String numM) {
        inscriptions.add(numM);
    }

    public String getContenu(String champ) {
        String value = "";
        switch (champ) {
            case "presences":
                String listP = String.join(", ", this.presences);
                value = listP;
                break;
            case "inscriptions":
                String listI = String.join(", ", this.inscriptions);
                value = listI;
                break;
            case "date":
                value = this.date.toString();
                break;
            default:
                value = null;
        }
        return value;
    }
}

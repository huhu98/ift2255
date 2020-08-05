import java.time.*;
import java.util.*;

public class Seance {

    private LocalDate date;
    private List<String> inscriptions = new ArrayList<String>();
    private List<String> presences = new ArrayList<String>();
	private String numP;

    public Seance(LocalDate date, String numP) {
        this.date = date;
        this.numP = numP;
    }

    public void ajoutPresence(String numM) {
        presences.add(numM);
    }
    public List<String> getPresence(){
    	return this.presences;
    }
    public List<String> getInscrit() {
    	return this.inscriptions;
    }

    public void ajoutInscrit(String numM) {
        inscriptions.add(numM);
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
            default:
                value = null;
        }
        return value;
    }
}

import java.time.*;
import java.util.*;

public class Seance {

    private LocalDate date;
    private List<String> inscriptions = new ArrayList<String>();
    private List<String> presences = new ArrayList<String>();
	private String numP;
	private String code;

    public Seance(LocalDate date, String numP,String code) {
    	this.code = code;
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
            	break;
            case "code":
            	value = this.code;
            default:
                value = null;
        }
        return value;
    }
    public void printSeance() {
    	
    }
    public String printInscription(String codeSeance,String numM) {
    	String recu = "Date et heure actuelles: "+Temps.mtn()+
    			"Date à laquelle du service qui sera fourni: "+getContenu("date")+
    			"Numéro du professionnel: "+getContenu("numP")+
    			"Numéro du membre: "+numM+
    			"Code de la séance "+getContenu("code");
    			
    	return recu;
    }
}

import java.util.*; 
public class Seance {

    private String date;
    private List<String> inscriptions = new ArrayList<String>();
    private List<String> presences = new ArrayList<String>();

    public Seance(String date) {
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
            	String listP = String.join(", ", presences);
                value = listP;
                break;
            case "inscriptions":
            	String listI = String.join(", ", inscriptions);
                value = listI;
                break;
            case "date":
                value = date;
                break;
            default:
            	value = null;
        }
        return value;
    }
}

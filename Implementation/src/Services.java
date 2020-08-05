import java.text.DecimalFormat;
import java.time.*;
import java.time.format.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Services {

    private String titre;
    private int code;
    private String numPro;
    private String debut;
    private String fin;
    private String heure;
    private int jour;
    private int capacite;
    private double prix;
    private String comment;

    public Services(int code, String titre, String numPro, String debut, String fin, String heure, int jour,
                    int capacite, double prix, String comment) {
    	this.code = code; // 3 chiffres
    	this.titre = titre;
        this.numPro = numPro;
        this.debut = debut;
        this.fin = fin;
        this.heure = heure;
        this.jour = jour;
        this.capacite = capacite;
        this.prix = prix;
        this.comment = comment;
    }
    
    public HashMap<String, Seance> addSeance() {
    	HashMap<String, Seance> seances = new HashMap<String, Seance>();
    	
    	List<LocalDate> dates = dateSeance(this.debut,this.fin,this.jour);
    	
        for(int i = 0; i < dates.size(); i++) {
        	Seance s = new Seance(dates.get(i),this.numPro);
        	String codeSeance = genCodeSeance(i);
        	seances.put(codeSeance, s);
        }
        return seances;
    }
   
    
   
    

    public String getContenu(String champ) {
        String result = null;
        switch (champ) {
            case "titre":
                result = this.titre;
                break;
            case "code":
                int codeService = this.code;
                result = Integer.toString(codeService);
            case "numPro":
                result = this.numPro;
                break;
            case "debut":
                result = this.debut;
                break;
            case "fin":
                result = this.fin;
                break;
            case "heure":
                result = this.heure;
            case "jour":
            	int day = this.jour;
                result = DayOfWeek.of(day).getDisplayName(TextStyle.FULL, Locale.FRENCH);
                break;
            case "prix":
                double cout = this.prix;
                result = Double.toString(cout);
                break;
            case "capacite":
                int espace = this.capacite;
                result = Integer.toString(espace);
                break;
            case "comment":
                result = this.comment;
        }
        return result;
    }
      
    /*
     * Le titre et le code de Service en 3 chiffres sont dépendantes de l'un à l'autre.
     * La date debut et fin, et la recurrence semaine sont aussi dépendantes de l'un à l'autre.
     * On ne les modifie pas individuellement.
     * Si l'utilisateur veut changer l'un de champ mentionné en haut, il doit supprimer le service et
     * en créer un nouveau pour que le système calcule de nouveau le nombre, la date et le numero de Seance.
     * */
    public void setContenu(String champ, String value) {
        switch (champ) {
            case "heure":
                this.heure = value;
                break;
            case "prix":
                this.prix = Double.parseDouble(value);
                break;
            case "capacite":
                this.capacite = Integer.parseInt(value);
                break;
            case "comment":
                this.comment = value;
                break;
        }
    }
    
    public List<LocalDate> dateSeance(String debut, String fin, int jour) {
    	//Initialize une arraylist des dates de seances
    	List<LocalDate> dates = new ArrayList<LocalDate>(); 
    	
    	//Convertir debut et fin de String "dd-mm-yyyy" en LocalDate
    	DateTimeFormatter format = DateTimeFormatter.ofPattern("d-MM-yyyy");
    	LocalDate start = LocalDate.parse(debut, format);
    	LocalDate end = LocalDate.parse(fin, format);
    	
    	//Trouver le premier date de Seance apres le debut
    	LocalDate startday = start.with(TemporalAdjusters.next(DayOfWeek.of(jour)));
    	
    	//Trouver le dernier date de Seance avant la fin
    	LocalDate endday =end.with(TemporalAdjusters.previous(DayOfWeek.of(jour)));
    	
    	//Ajouter la date du premier seance dans arraylisy
    	dates.add(startday);
    	
    	//Ajouter les dates de seances entre le premier et le dernier seances
    	while (endday.isAfter(startday)) {
    		LocalDate tmpday = startday;
    		tmpday = tmpday.plusWeeks(1);
    		startday = tmpday;
    		dates.add(startday);
    	}
    	return dates;
    }

    

    public String genCodeSeance(int i) {
        String numSeance = new DecimalFormat("00").format(i);
        String codeService = this.getContenu("code");
        String numP2 = this.getContenu(numPro);
        String codeSeance = codeService + numSeance + numP2.substring(numP2.length()- 2);
        return codeSeance;
    }
}
   

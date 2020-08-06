import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Temps {


	public static String mtn() {
		return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
	}
	
	
	public static List<LocalDate> dateSeance(String debut, String fin, int jour) {
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
}

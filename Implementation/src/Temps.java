import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Temps {

    /**
     * Methode pour formatter la date et l'heure de maintenant
     *
     * @return la date et l'heure de maintenant (dd-MM-yyyy HH:mm:ss)
     */
    public static String mtn() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    }
    public static String today() {
    	LocalDate today = LocalDate.now();
    	return today.toString();
    }
    public static String semProchaine() {
    	 LocalDate today = LocalDate.now();
    	 LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
    	 DateTimeFormatter format = DateTimeFormatter.ofPattern("d-MM-yyyy");
         String formatted = nextWeek.format(format);
    	 return formatted;
    	
    }
    /**
     * Methode pour calculer les dates de récurrence hebdomadaire dans un durée
     *
     * @param debut la date du début
     * @param fin   la date de la fin
     * @param jour  la récurrence hebdo
     * @return dates
     */
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
        LocalDate endday = end.with(TemporalAdjusters.previous(DayOfWeek.of(jour)));

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
    
    public static boolean dateInrange(String debut,String fin, String date) {
    	 DateTimeFormatter format = DateTimeFormatter.ofPattern("d-MM-yyyy");
    	 LocalDate start = LocalDate.parse(debut, format);
         LocalDate end = LocalDate.parse(fin, format);
         LocalDate testDate = LocalDate.parse(date, format);
         
    	return	!(testDate.isBefore(start) || testDate.isAfter(end));
    }
}

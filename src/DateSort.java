import java.time.LocalDate;
import java.util.Comparator;

public class DateSort implements Comparator<SportClub> {

    @Override
    public int compare(SportClub a,SportClub b){
        LocalDate localDate1 = LocalDate.parse(((FootBallClub)a).getDate());        //parse date string to loacalDate data type
        LocalDate localDate2 = LocalDate.parse(((FootBallClub)b).getDate());
        return localDate1.compareTo(localDate2);
    }
}

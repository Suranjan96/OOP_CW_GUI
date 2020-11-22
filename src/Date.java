import java.util.Comparator;

public class Date implements Comparator<FootBallClub> {

    public int compare(FootBallClub c, FootBallClub d){
        return c.getDate().compareTo(d.getDate());
    }
}

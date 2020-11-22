import java.util.Comparator;

public class Score implements Comparator<FootBallClub> {

    public int compare(FootBallClub c, FootBallClub d){
        return c.getScored()-d.getScored();
    }
}

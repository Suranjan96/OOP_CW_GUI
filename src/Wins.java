import java.util.Comparator;

public class Wins implements Comparator<FootBallClub> {

    public int compare(FootBallClub a, FootBallClub b){
        return a.getWins()-b.getWins();
    }



}

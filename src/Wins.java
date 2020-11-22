import java.util.Comparator;

public class Wins implements Comparator<FootBallClub> {

    public int compare(FootBallClub wins1, FootBallClub wins2){
        return wins1.getWins()-wins2.getWins();
    }




}

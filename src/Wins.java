import java.util.Comparator;

public class Wins implements Comparator<SportClub> {

    public int compare(SportClub wins1, SportClub wins2){
        return ((FootBallClub)wins1).getWins()-((FootBallClub)wins2).getWins();
    }




}

import java.util.Comparator;

public class WinsSort implements Comparator<SportClub> {

    public int compare(SportClub wins1, SportClub wins2){
        return ((FootBallClub)wins2).getWins()-((FootBallClub)wins1).getWins();
    }




}

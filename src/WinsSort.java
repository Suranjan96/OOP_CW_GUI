import java.util.Comparator;

public class WinsSort implements Comparator<SportsClub> {

    public int compare(SportsClub wins1, SportsClub wins2){
        return ((FootBallClub)wins2).getWins()-((FootBallClub)wins1).getWins();
    }




}

import java.util.Comparator;

public class ScoreSort implements Comparator<SportsClub> {

    public int compare(SportsClub score1, SportsClub score2){
        int compareScore1 = ((FootBallClub)score1).getScored();
        int compareScore2 = ((FootBallClub)score2).getScored();

        if (compareScore1<compareScore2){
            return 1;
        }else if (compareScore1>compareScore2){
            return -1;
        }else {
            return 0;
        }
    }


}

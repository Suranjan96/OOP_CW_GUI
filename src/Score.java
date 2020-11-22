import java.util.Comparator;

public class Score implements Comparator<SportClub> {

    public int compare(SportClub score1,SportClub score2){
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

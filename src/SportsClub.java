import java.io.Serializable;

public class SportsClub implements Serializable {
    private String clubName1;
    private String clubName2;
    private String location;
    private String foundedYear;

    public SportsClub(String clubName1, String clubName2, String location, String foundedYear) {
        this.clubName1 = clubName1;
        this.clubName2 = clubName2;
        this.location = location;
        this.foundedYear = foundedYear;
    }

    public String getClubName1() {
        return clubName1;
    }

    public void setClubName1(String clubName1) {
        this.clubName1 = clubName1;
    }

    public String getClubName2() {
        return clubName2;
    }

    public void setClubName2(String clubName2) {
        this.clubName2 = clubName2;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(String foundedYear) {
        this.foundedYear = foundedYear;
    }

    public static boolean clubChecker(String clubName){      //duplicate club names checking
        if((clubName!=null) && clubName.matches("^[a-zA-Z]*$")){
            for (SportsClub name : PremierLeagueManager.premierLeague){
                if (name.getClubName1().equalsIgnoreCase(clubName)){
                    System.out.println("Duplicate club name!!");
                    return false;
                }
            }
            return true;
        }
        else {
            System.out.println("Invalid input..... please try again");
            return false;
        }
    }
}

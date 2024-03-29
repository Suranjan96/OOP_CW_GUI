import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager  {
    public static List<SportsClub> premierLeague = new ArrayList<>() ;   // premier league array list all clubs statistics storing in this array
    public static List<SportsClub> matches = new ArrayList<>();          // all played matches storing in this array

    @Override
    public void createNewClub(SportsClub footBallClub)  {
        premierLeague.add(footBallClub);
        System.out.println("\nNumber of club registered: "+premierLeague.size());       //promot message how many club were exciting
        System.out.println("Number of free slots : "+(20-premierLeague.size()));

    }

    @Override
    public void deleteClub(String clubName) {
        if (premierLeague.size() >= 1) {        //there should be at least one club to delete
            boolean nameCheck = false;
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your club name :");      //display the various statistics to the relevant club name
                clubName = input.next();
                for (SportsClub footBallClub : premierLeague) {
                    if (footBallClub.getClubName1().equalsIgnoreCase(clubName)) {
                        System.out.println("> Founded Year      : " + footBallClub.getFoundedYear());
                        System.out.println("> Location          : " + footBallClub.getLocation());
                        System.out.println("> Number of Matches : " + ((FootBallClub) footBallClub).getNoOfMatches());
                        System.out.println("> Wins              : " + ((FootBallClub) footBallClub).getWins());
                        System.out.println("> Draws             : " + ((FootBallClub) footBallClub).getDraws());
                        System.out.println("> Lost              : " + ((FootBallClub) footBallClub).getDefeats());
                        System.out.println("> Number of Goals   : " + ((FootBallClub) footBallClub).getNoOfGoals());
                        System.out.println("> Scored            : " + ((FootBallClub) footBallClub).getScored());
                        System.out.println("> Goal Difference   : " + ((FootBallClub) footBallClub).getGoalDifference());
                        System.out.println("> Number of Points  : " + ((FootBallClub) footBallClub).getNoOfPoints());
                        System.out.println("\n Successfully deleted "+clubName +" club!!!");
                        premierLeague.remove(footBallClub);
                        Main.position();
                        nameCheck = true;
                        break;
                    } else {
                        nameCheck = false;
                    }
                }
                if (!nameCheck) {
                    System.out.println("Not found!");
                    nameCheck = false;
                }

            } while (!nameCheck);
        } else {
            System.out.println("There are no football club to delete!");
        }
    }

    @Override
    public void relegateClubs(){
        if(PremierLeagueManager.premierLeague.size()==20) {     //to relegate there should be 20 clubs
            premierLeague.sort(Collections.reverseOrder());    //https://stackoverflow.com/questions/61224776/reason-no-instances-of-type-variables-t-exist-so-that-int-conforms-to-t
            //delete the last object from arraylist
            System.out.println("Relegated clubs are:- ");
            String leftAlignFormat = "| %-15s | %-6d | %-4d | %-6d | %-5d | %-5d | %-5d | %-5d | %-6d |%n";         //https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
            System.out.format("+-----------------+--------+------+--------+-------+-------+-------+-------+--------+%n");       //creating table
            System.out.format("| Club name       | Played | Won  | Drawn  | Lost  |  GF   |  GA   |  GD   |Points  | %n");
            System.out.format("+-----------------+--------+------+--------+-------+-------+-------+-------+--------+%n");
            for (int x = 1; x <= 3; x++) {      //remove three clubs from table from last
                SportsClub footBallClub2 = premierLeague.get(premierLeague.size() - 1);
                System.out.format(leftAlignFormat, footBallClub2.getClubName1(), ((FootBallClub) footBallClub2).getNoOfMatches(), ((FootBallClub) footBallClub2).getWins(),
                        ((FootBallClub) footBallClub2).getDraws(), ((FootBallClub) footBallClub2).getDefeats(), ((FootBallClub) footBallClub2).getScored(),
                        ((FootBallClub) footBallClub2).getNoOfGoals(), ((FootBallClub) footBallClub2).getGoalDifference(), ((FootBallClub) footBallClub2).getNoOfPoints());

                premierLeague.remove(premierLeague.size() - 1);
            }
            System.out.format("+-----------------+--------+------+--------+-------+-------+-------+-------+--------+%n");
        }
        else {
            System.out.println("There are no 20 football clubs to relegate!");
        }
    }

    @Override
    public void displayStatistics(String clubName)  {
        if (premierLeague.size() >= 1) {        //there should be at least one club to show some staticstic
            boolean nameCheck = false;
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your club name :");      //display the various statistics to the relevant club name
                clubName = input.next();
                for (SportsClub footBallClub : premierLeague) {
                    if (footBallClub.getClubName1().equalsIgnoreCase(clubName)) {
                        System.out.println("> Founded Year      : " + footBallClub.getFoundedYear());
                        System.out.println("> Location          : " + footBallClub.getLocation());
                        System.out.println("> Number of Matches : " + ((FootBallClub) footBallClub).getNoOfMatches());
                        System.out.println("> Wins              : " + ((FootBallClub) footBallClub).getWins());
                        System.out.println("> Draws             : " + ((FootBallClub) footBallClub).getDraws());
                        System.out.println("> Lost              : " + ((FootBallClub) footBallClub).getDefeats());
                        System.out.println("> Number of Goals   : " + ((FootBallClub) footBallClub).getNoOfGoals());
                        System.out.println("> Scored            : " + ((FootBallClub) footBallClub).getScored());
                        System.out.println("> Goal Difference   : " + ((FootBallClub) footBallClub).getGoalDifference());
                        System.out.println("> Number of Points  : " + ((FootBallClub) footBallClub).getNoOfPoints());
                        nameCheck = true;
                        break;
                    } else {
                        nameCheck = false;
                    }
                }
                if (!nameCheck) {
                    System.out.println("Not found!");
                    nameCheck = false;
                }

            } while (!nameCheck);
        } else {
            System.out.println("There are no statistics to display!");
        }
    }

    @Override
    public void displayLeagueTable() {
        if (premierLeague.size()>=1){
            premierLeague.sort(Collections.reverseOrder());
            System.out.println("Ranking Table:-");
            String leftAlignFormat = "| %-8d | %-15s | %-6d | %-4d | %-6d | %-5d | %-5d | %-5d | %-5d | %-6d |%n";         //https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
            System.out.format("+----------+-----------------+--------+------+--------+-------+-------+-------+-------+--------+%n");
            System.out.format("| Position |    Club name    | Played | Won  | Drawn  | Lost  |  GF   |  GA   |  GD   | Points | %n");
            System.out.format("+----------+-----------------+--------+------+--------+-------+-------+-------+-------+--------+%n");
            int count =0;
            for (SportsClub footBallClub : premierLeague) {
                count++;
                System.out.format(leftAlignFormat,footBallClub.getPosition(),footBallClub.getClubName1(), ((FootBallClub) footBallClub).getNoOfMatches(),((FootBallClub) footBallClub).getWins(),
                        ((FootBallClub) footBallClub).getDraws(),((FootBallClub) footBallClub).getDefeats(),((FootBallClub) footBallClub).getScored(),
                        ((FootBallClub) footBallClub).getNoOfGoals(),((FootBallClub) footBallClub).getGoalDifference(),((FootBallClub) footBallClub).getNoOfPoints());
            }
            System.out.format("+----------+-----------------+--------+------+--------+-------+-------+-------+-------+--------+%n");


            if(matches.size()>0){
                System.out.println("\nTable of Matches:-");
                String leftAlignFormats = "| %-15s | %-15s | %-12s | %-15s |%n";
                System.out.format("+-----------------+-----------------+--------------+-----------------+%n");
                System.out.format("|  Date           |  Home Team      |  Results     |  Away Team      | %n");
                System.out.format("+-----------------+-----------------+--------------+-----------------+%n");
                for (int x = 0; x< matches.size(); x++){
                    System.out.printf(leftAlignFormats,((FootBallClub) matches.get(x)).getDate(), matches.get(x).getClubName1(),"  "+
                                    (((FootBallClub) matches.get(x)).getNoOfGoals())+" -"+" "+((FootBallClub) matches.get(x)).getScored(),
                            matches.get(x).getClubName2());
                }
                System.out.format("+-----------------+-----------------+--------------+-----------------+%n");
            }
        }
        else  {
            System.out.println("There are no football clubs to display Premier League Table!");
        }
    }

    @Override
    public void addPlayedMatch(SportsClub playedMatch1)  {
        matches.add(playedMatch1);      //add team name, score and date to the marches1 arraylist
    }

    @Override
    public void saveInformation() {
        if (premierLeague.size() >= 1) {
            try {
                FileOutputStream fileOut = new FileOutputStream("ClubData");                    //https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/#:~:text=In%20Java%2C%20ArrayList%20class%20is,to%20deserialize%20an%20arraylist%20object.
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(premierLeague);                                 //Serialize arraylist of objects
                out.writeObject(matches);                                       //storing two whole array list with objects
                out.close();
                fileOut.close();
                System.out.printf("Serialized data has been successfully saved!!");
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
        else {
            System.out.println("There are no data to save!!!");
        }
    }

    @Override
    public void loadInformation(){
        try {
            FileInputStream fileIn = new FileInputStream("ClubData");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            premierLeague = (ArrayList) in.readObject();                //Deserialize list of objects
            matches = (ArrayList) in.readObject();                      //loading two array list with objects
            in.close();
            fileIn.close();
            System.out.println("Data has been successfully loaded!!\n");
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println("Data not found!!\n");
        }
    }




}

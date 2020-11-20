import javafx.application.Application;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    private static String clubName1;
    private static String clubName2;
    private static String location;
    private static String foundedYear;
    private static int wins1=0;
    private static int wins2=0;
    private static int draws1=0;
    private static int draws2=0;
    private static int defeats1=0;
    private static int defeats2=0;
    private static int noOfGoals1=0;
    private static int noOfGoals2=0;
    private static int scored1=0;
    private static int scored2=0;
    private static int noOfPoints1=0;
    private static int noOfPoints2=0;
    private static int playedMatches1=0;
    private static int playedMatches2=0;
    private static int team1Scored=0;
    private static int team2Scored=0;
    public static int playedMatches=0;
    private static int goalDifference1 =0;
    private static int goalDifference2 =0;
    private static String date;



    public static void main(String[] args) throws IOException {
        premierLeagueManager.loadInformation();    //loading stored data
        System.out.println("**************************** Premier League Manager ****************************");
        menu:
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println();      //Main menu
            System.out.println("");
            System.out.println("|----------------------------MENU BAR-------------------------|");
            System.out.println("|'1'- Create new football club                                |");
            System.out.println("|'2'- Delete an existing club                                 |");
            System.out.println("|'3'- Display the various statistics for a selected club      |");
            System.out.println("|'4'- Display the Premier League Table                        |");
            System.out.println("|'5'- Add a played match with its score and its date          |");
            System.out.println("|'6'- Saving in a file of all the information                 |");
            System.out.println("|'7'- Open GUI to show tables                                 |");
            System.out.println("|'Q'- Quit                                                    |");
            System.out.println("|-------------------------------------------------------------|");
            System.out.print("Enter letter: ");
            String option = input.next();
            System.out.println();
            switch (option) {
                case "1":
                    createNewFootBallClub();
                    break;
                case "2":
                    premierLeagueManager.deleteClub();
                    break;
                case "3":
                    premierLeagueManager.displayStatistics(clubName1);
                    break;
                case "4":
                    premierLeagueManager.displayLeagueTable();
                    break;
                case "5":
                    addPlayedMatch();
                    break;
                case "6":
                    premierLeagueManager.saveInformation();
                    break;
                case"7":
                    Application.launch(GUI.class);
                    System.exit(0);
                    break;
                case "8":
                    random();
                    break;
                case "Q":
                case "q":
                    break menu;
                default:
                    System.out.println("I'm not sure what you said, please try again");
            }
        }
    }

    private static void createNewFootBallClub() throws IOException{
        if (PremierLeagueManager.premierLeague.size()<=19){
            boolean nameCheck=false;
            Scanner input = new Scanner(System.in);

            do {
                System.out.print("1. Name of your club : ");
                clubName1 = input.next();
                nameCheck = SportClub.clubChecker(clubName1);
            } while (!nameCheck);


            do {
                System.out.print("2. Enter your location : ");
                location = input.next();
                if ((location != null) && (location.matches("^[a-zA-Z]*$"))) {     //location validation
                    break;
                }
                System.out.println("Invalid input..... please try again");
            } while (!nameCheck);

            do {
                System.out.print("3. Enter your founded year : ");
                foundedYear = input.next();
                if ((foundedYear != null)  && (foundedYear.matches("^[0-2]|[8-9]|[0-9]|[0-9]*$"))) {     //year validation
                    break;
                }
                System.out.println("Invalid input..... please try again");
            } while (!nameCheck);

            System.out.println("\nSuccessfully "+clubName1 +" club added to the Premier League");
            SportClub footballClub = new FootBallClub(clubName1,"",location,foundedYear,0,0,0,0,0,0,0,0,"-");   //pass data to the constructor
            //footballClub = new FootBallClub(clubName,location,foundedYear,wins,draws,defeats,noOfGoals,scored,noOfPoints,playedMatches,date);
            //teams+=1;
            premierLeagueManager.createNewClub(footballClub);

        }else if(PremierLeagueManager.premierLeague.size()==20) {      //maximum length is 20
            System.out.println("No free slots are available to register!");
        }
    }

    private static void addPlayedMatch() throws IOException{
        if (PremierLeagueManager.premierLeague.size() >= 2) {
            boolean nameCheck = false,scoredBoolean,dateCheck=false;
            playedMatches++;
            do {
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter the date (YYYY-MM-DD) : ");
                date = input1.next();
                if ((date != null) && (!date.equals("")) && (date.matches("^(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$"))) {   https://www.regular-expressions.info/dates.html#:~:text=To%20match%20a%20date%20in,%5D)%5B%2D%20%2F.%5D
                    break;
                }
                System.out.println("Invalid input..... please try again\n");
            } while (!dateCheck);

            /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
            Date date2 = null ;
            try {
                date2 = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }*/

            int a,b;  //count index of arraylist
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("1. Enter your club name :");    //getting the first club name
                clubName1 = input.next();
                a = 0;
                for (SportClub footBallClub : PremierLeagueManager.premierLeague) {   //checking relevant name from arraylist
                    if (footBallClub.getClubName1().equalsIgnoreCase(clubName1)) {
                        do {
                            try {
                                Scanner input5 = new Scanner(System.in);
                                System.out.print(">> Number of scored : ");
                                team1Scored = input5.nextInt();
                                System.out.println();
                                scoredBoolean = true;
                            } catch (RuntimeException e) {
                                System.out.println("\t\tPlease enter integer input!\n");
                                scoredBoolean = false;
                            }
                        } while (!scoredBoolean);
                        nameCheck = true;
                        break;
                    } else {
                        nameCheck = false;
                    }
                    a++;
                }
                if (!nameCheck) {
                    System.out.println("Not found!");
                    nameCheck = false;
                }
            } while (!nameCheck);

            do {
                Scanner input = new Scanner(System.in);
                System.out.print("2. Enter your club name :");          //getting the first club name
                clubName2 = input.next();
                b=0;
                if (!clubName1.equalsIgnoreCase(clubName2)) {
                    for (SportClub footBallClub : PremierLeagueManager.premierLeague) {     //checking relevant name from arraylist
                        if (footBallClub.getClubName1().equalsIgnoreCase(clubName2)) {
                            do {
                                try {
                                    Scanner input5 = new Scanner(System.in);
                                    System.out.print(">> Number of scored : ");
                                    team2Scored = input5.nextInt();
                                    System.out.println();
                                    scoredBoolean = true;
                                } catch (RuntimeException e) {
                                    System.out.println("\t\tPlease enter integer input!\n");
                                    scoredBoolean = false;
                                }
                            } while (!scoredBoolean);
                            nameCheck = true;
                            break;
                        } else {
                            nameCheck = false;
                        }
                        b++;
                    }
                    if (!nameCheck) {
                        System.out.println("Not found!");
                        nameCheck = false;
                    }
                }else {
                    System.out.println("Duplicate club name");
                    nameCheck = false;
                }
            } while (!nameCheck);

            for (SportClub footBallClub : PremierLeagueManager.premierLeague) {       //calculation part
                if ((footBallClub.getClubName1().equals(clubName1))) {
                    if (team1Scored > team2Scored) {
                        wins1 = ((FootBallClub) footBallClub).getWins()+1;
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints()+3;
                    }
                    else if (team2Scored > team1Scored) {
                        defeats1 = ((FootBallClub) footBallClub).getDefeats()+1;
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints();
                    }
                    else if (team1Scored == team2Scored) {
                        draws1 = ((FootBallClub) footBallClub).getDraws()+1;
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints()+1;
                    }
                    noOfGoals1 = ((FootBallClub) footBallClub).getNoOfGoals()+team2Scored;
                    scored1 = ((FootBallClub) footBallClub).getScored()+team1Scored;
                    playedMatches1=((FootBallClub) footBallClub).getNoOfMatches()+1;
                    goalDifference1 =scored1-noOfGoals1;

                }else if ((footBallClub.getClubName1().equals(clubName2))){
                    if (team2Scored > team1Scored) {
                        wins2 = ((FootBallClub) footBallClub).getWins()+1;
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints()+3;
                    }
                    else if (team1Scored > team2Scored) {
                        defeats2 = ((FootBallClub) footBallClub).getDefeats()+1;
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints();
                    }
                    else if (team1Scored == team2Scored) {
                        draws2 = ((FootBallClub) footBallClub).getDraws()+1;
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints()+1;
                    }
                    noOfGoals2 = ((FootBallClub) footBallClub).getNoOfGoals()+team1Scored;
                    scored2 = ((FootBallClub) footBallClub).getScored()+team2Scored;
                    playedMatches2=((FootBallClub) footBallClub).getNoOfMatches()+1;
                    goalDifference2 =scored2-noOfGoals2;
                }
            }
            SportClub footballClub1 = new FootBallClub(clubName1,"",location,foundedYear,wins1,draws1,defeats1,noOfGoals1,scored1,noOfPoints1,playedMatches1, goalDifference1,date);     //pass the object to the constructor
            SportClub footballClub2 = new FootBallClub(clubName2,"",location,foundedYear,wins2,draws2,defeats2,noOfGoals2,scored2,noOfPoints2,playedMatches2, goalDifference2,date);
            PremierLeagueManager.premierLeague.set(a,footballClub1);         //set the first team object to the relevant index number
            PremierLeagueManager.premierLeague.set(b,footballClub2);         //set the second team object to the relevant index number

            SportClub playedMatch1 = new FootBallClub(clubName1,clubName2,"","",0,0,0,team1Scored,team2Scored,0,0,0,date);   //pass the matches details to the constructor
            //SportClub playedMatch2 = new FootBallClub(clubName2,"","",0,0,0,0,team2Scored,0,0,0,date);

            premierLeagueManager.addPlayedMatch(playedMatch1);
        } else {
            System.out.println("There are no two football clubs to add scored and date!");
        }
    }

    private static void random() throws IOException{
        Random rand = new Random();
        SportClub randTest = PremierLeagueManager.premierLeague.get(rand.nextInt(PremierLeagueManager.premierLeague.size()));
        //System.out.println(randTest.getClubName1());
        clubName1 = randTest.getClubName1();
        clubName2 = randTest.getClubName1();

        SportClub name = null;
        for (int x = 0; x< PremierLeagueManager.matches.size(); x++){
            if (clubName1.equalsIgnoreCase(PremierLeagueManager.matches.get(x).getClubName1())){
                if (clubName2.equalsIgnoreCase(PremierLeagueManager.matches.get(x).getClubName2())){
                    break;
                }else {
                    System.out.println(clubName1+" "+clubName2);
                }
            }
        }
           // System.out.println( PremierLeagueManager.matches.get(x).getClubName1()+" | "+ PremierLeagueManager.matches.get(x).getClubName2());


    }
}
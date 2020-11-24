import javafx.application.Application;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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

    public static void main(String[] args)  {
        premierLeagueManager.loadInformation();    //loading stored data
        System.out.println("**************************** Premier League Manager ****************************");
        menu:
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println();      //Main menu
            System.out.println("");
            System.out.println("|----------------------------MENU BAR-------------------------|");
            System.out.println("|'1'- Create new football club                                |");
            System.out.println("|'2'- Relegate an existing clubs                              |");
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
                case "Q":
                case "q":
                    break menu;
                default:
                    System.out.println("I'm not sure what you said, please try again");
            }
        }
    }

    private static void createNewFootBallClub()  {
        if (PremierLeagueManager.premierLeague.size()<=19){
            boolean nameCheck=false;
            Scanner input = new Scanner(System.in);

            do {
                System.out.print("1. Name of your club : ");       //enter club name
                clubName1 = input.next();
                nameCheck = SportClub.clubChecker(clubName1);
            } while (!nameCheck);


            do {
                System.out.print("2. Enter your location : ");      //enter their location
                location = input.next();
                if ((location != null) && (location.matches("^[a-zA-Z]*$"))) {     //location validation
                    break;
                }
                System.out.println("Invalid input..... please try again");
            } while (!nameCheck);

            do {
                System.out.print("3. Enter your founded year : ");          //enter the founded year
                foundedYear = input.next();
                if ((foundedYear != null)  && (foundedYear.matches("^[0-2]|[8-9]|[0-9]|[0-9]*$"))) {     //year validation
                    break;
                }
                System.out.println("Invalid input..... please try again");
            } while (!nameCheck);

            System.out.println("\nSuccessfully "+clubName1 +" club added to the Premier League");     //prompt message
            SportClub footballClub = new FootBallClub(clubName1,"",location,foundedYear,0,0,0,0,0,0,0,0,"");   //pass data to the constructor
            premierLeagueManager.createNewClub(footballClub);    //call to the create method in premier league class

        }else if(PremierLeagueManager.premierLeague.size()==20) {      //maximum length is 20
            System.out.println("No free slots are available to register!");
        }
    }

    private static void addPlayedMatch()  {
        if (PremierLeagueManager.premierLeague.size() >= 2) {     //at least their should be 2 clubs to play match
            boolean nameCheck = false,scoredBoolean,dateCheck=false;
            playedMatches++;                            //counting number of matches played
            do {
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter the date (YYYY-MM-DD) : ");    //enter played date
                date = input1.next();
                if ((date != null) && (!date.equals("")) && (date.matches("^(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$"))) {   https://www.regular-expressions.info/dates.html#:~:text=To%20match%20a%20date%20in,%5D)%5B%2D%20%2F.%5D
                    break;                          //validating date using regex
                }
                System.out.println("Invalid input..... please try again\n");
            } while (!dateCheck);

            int a,b;  //count index of arraylist
            do {
                do {
                    Scanner input = new Scanner(System.in);
                    System.out.print("1. Enter Home Team :");    //getting the first club name
                    clubName1 = input.next();
                    a = 0;
                    for (SportClub footBallClub : PremierLeagueManager.premierLeague) {   //checking relevant name from arraylist
                        if (footBallClub.getClubName1().equalsIgnoreCase(clubName1)) {
                            nameCheck = true;
                            break;
                        } else {
                            nameCheck = false;
                        }
                        a++;
                    }
                    if (!nameCheck) {               //checking that name is available or not
                        System.out.println("Not found!");
                        nameCheck = false;
                    }
                } while (!nameCheck);

                do {
                    Scanner input = new Scanner(System.in);
                    System.out.print("2. Enter Away Team :");          //getting the first club name
                    clubName2 = input.next();
                    b = 0;
                    if (!clubName1.equalsIgnoreCase(clubName2)) {
                        for (SportClub footBallClub : PremierLeagueManager.premierLeague) {     //checking relevant name from arraylist
                            if (footBallClub.getClubName1().equalsIgnoreCase(clubName2)) {
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
                    } else {
                        System.out.println("Duplicate club name");          //prompt message when user enter same name for second club
                        nameCheck = false;
                    }
                } while (!nameCheck);

                for (SportClub footBallClub : PremierLeagueManager.matches) {
                    if ((clubName1.equalsIgnoreCase((footBallClub).getClubName1())) &&(clubName2.equalsIgnoreCase((footBallClub).getClubName2()))){
                        nameCheck = false;
                        System.out.println("Duplicate matches");         //checking matches are duplicate or not
                        break;
                    }
                    else {
                        nameCheck = true;
                    }
                }
            }while (!nameCheck);


            do {
                try {
                    Scanner input5 = new Scanner(System.in);
                    System.out.print("\n>> 1. Score of Home team : ");   //enter score in first team
                    team1Scored = input5.nextInt();
                    scoredBoolean = true;
                } catch (RuntimeException e) {
                    System.out.println("\t\tPlease enter integer input!\n");  //validating score
                    scoredBoolean = false;
                }
            } while (!scoredBoolean);

            do {
                try {
                    Scanner input5 = new Scanner(System.in);
                    System.out.print(">> 2. Score of Away team : ");        //enter score in second team
                    team2Scored = input5.nextInt();
                    System.out.println();
                    scoredBoolean = true;
                } catch (RuntimeException e) {
                    System.out.println("\t\tPlease enter integer input!\n");        //validating score
                    scoredBoolean = false;
                }
            } while (!scoredBoolean);

            for (SportClub footBallClub : PremierLeagueManager.premierLeague) {       //calculation part
                if ((footBallClub.getClubName1().equalsIgnoreCase(clubName1))) {        //update all statistics to relevant their club name
                    if (team1Scored > team2Scored) {                                    //checking score1 greater the to score2
                        wins1 = ((FootBallClub) footBallClub).getWins()+1;
                        defeats1 = ((FootBallClub) footBallClub).getDefeats();
                        draws1 = ((FootBallClub) footBallClub).getDraws();
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints()+3;
                    }
                    else if (team2Scored > team1Scored) {                           //checking score2 greater the to score1
                        wins1 = ((FootBallClub) footBallClub).getWins();
                        defeats1 = ((FootBallClub) footBallClub).getDefeats()+1;
                        draws1 = ((FootBallClub) footBallClub).getDraws();
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints();
                    }
                    else if (team1Scored == team2Scored) {                          //checking score1 equal to score2
                        wins1 = ((FootBallClub) footBallClub).getWins();
                        defeats1 = ((FootBallClub) footBallClub).getDefeats();
                        draws1 = ((FootBallClub) footBallClub).getDraws()+1;
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints()+1;
                    }
                    noOfGoals1 = ((FootBallClub) footBallClub).getNoOfGoals()+team2Scored;
                    scored1 = ((FootBallClub) footBallClub).getScored()+team1Scored;
                    playedMatches1=((FootBallClub) footBallClub).getNoOfMatches()+1;
                    goalDifference1 =scored1-noOfGoals1;
                    SportClub footballClub1 = new FootBallClub(clubName1,"",location,foundedYear,wins1,draws1,defeats1,noOfGoals1,scored1,noOfPoints1,playedMatches1, goalDifference1,date);     //pass the object to the constructor
                    PremierLeagueManager.premierLeague.set(a,footballClub1);         //set the first team object to the relevant index number


                }else if ((footBallClub.getClubName1().equalsIgnoreCase(clubName2))){           //calculation part to the second team
                    if (team2Scored > team1Scored) {
                        wins2 = ((FootBallClub) footBallClub).getWins()+1;
                        defeats2 = ((FootBallClub) footBallClub).getDefeats();
                        draws2 = ((FootBallClub) footBallClub).getDraws();
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints()+3;
                    }
                    else if (team1Scored > team2Scored) {
                        wins2 = ((FootBallClub) footBallClub).getWins();
                        defeats2 = ((FootBallClub) footBallClub).getDefeats()+1;
                        draws2 = ((FootBallClub) footBallClub).getDraws();
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints();
                    }
                    else if (team1Scored == team2Scored) {
                        wins2 = ((FootBallClub) footBallClub).getWins();
                        defeats2 = ((FootBallClub) footBallClub).getDefeats();
                        draws2 = ((FootBallClub) footBallClub).getDraws()+1;
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints()+1;
                    }
                    noOfGoals2 = ((FootBallClub) footBallClub).getNoOfGoals()+team1Scored;
                    scored2 = ((FootBallClub) footBallClub).getScored()+team2Scored;
                    playedMatches2=((FootBallClub) footBallClub).getNoOfMatches()+1;
                    goalDifference2 =scored2-noOfGoals2;
                    SportClub footballClub2 = new FootBallClub(clubName2,"",location,foundedYear,wins2,draws2,defeats2,noOfGoals2,scored2,noOfPoints2,playedMatches2, goalDifference2,date);
                    PremierLeagueManager.premierLeague.set(b,footballClub2);         //set the second team object to the relevant index number

                }
            }
            SportClub playedMatch1 = new FootBallClub(clubName1,clubName2,"","",0,0,0,team1Scored,team2Scored,0,0,0,date);   //pass the matches details to the constructor
            premierLeagueManager.addPlayedMatch(playedMatch1);
        }
        else {
            System.out.println("There are no two football clubs to add scored and date!");          //prompt message the are no football clubs
        }
    }

    public static void random()  {              //random option to the gui part
        boolean nameCheck = false;
        if ((PremierLeagueManager.premierLeague.size()-1)*(PremierLeagueManager.premierLeague.size())>(PremierLeagueManager.matches.size())) {
            do {
                Random rand = new Random();
                SportClub randTest1 = PremierLeagueManager.premierLeague.get(rand.nextInt(PremierLeagueManager.premierLeague.size()));          //getting random club name from array list
                SportClub randTest2 = PremierLeagueManager.premierLeague.get(rand.nextInt(PremierLeagueManager.premierLeague.size()));
                clubName1 = randTest1.getClubName1();           //random club name initialize to the variable
                clubName2 = randTest2.getClubName1();
                if (!clubName1.equalsIgnoreCase(clubName2)) {           //checking to random names are equal or not
                    for (SportClub footBallClub : PremierLeagueManager.matches) {
                        if ((clubName1.equalsIgnoreCase((footBallClub).getClubName1())) && (clubName2.equalsIgnoreCase((footBallClub).getClubName2()))) {
                            nameCheck = false;
                            break;
                        } else {
                            nameCheck = true;
                        }
                    }
                } else {
                    nameCheck = false;
                }
            }while (!nameCheck);

            LocalDate startDate = LocalDate.of(2020, 8, 1); //start date            https://stackoverflow.com/questions/40253332/generating-random-date-in-a-specific-range-in-java/40253420
            long start = startDate.toEpochDay();

            LocalDate endDate = LocalDate.of(2021,5,30); //end date
            long end = endDate.toEpochDay();

            long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
            String date = String.valueOf(LocalDate.ofEpochDay(randomEpochDay));         //getting random date between 2020-08-1 to 2021-05-31
            //System.out.println(date);


            Random randScore = new Random();
            team1Scored = randScore.nextInt(15);   //getting random score between 0 to 15
            team2Scored = randScore.nextInt(15);

            for (SportClub footBallClub : PremierLeagueManager.premierLeague) {       //calculation part
                if ((footBallClub.getClubName1().equalsIgnoreCase(clubName1))) {
                    if (team1Scored > team2Scored) {
                        wins1 = ((FootBallClub) footBallClub).getWins()+1;
                        defeats1 = ((FootBallClub) footBallClub).getDefeats();
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints()+3;
                        draws1 = ((FootBallClub) footBallClub).getDraws();
                    }
                    else if (team2Scored > team1Scored) {
                        wins1 = ((FootBallClub) footBallClub).getWins();
                        defeats1 = ((FootBallClub) footBallClub).getDefeats()+1;
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints();
                        draws1 = ((FootBallClub) footBallClub).getDraws();
                    }
                    else if (team1Scored == team2Scored) {
                        wins1 = ((FootBallClub) footBallClub).getWins();
                        defeats1 = ((FootBallClub) footBallClub).getDefeats();
                        draws1 = ((FootBallClub) footBallClub).getDraws()+1;
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints()+1;
                    }
                    noOfGoals1 = ((FootBallClub) footBallClub).getNoOfGoals()+team2Scored;
                    scored1 = ((FootBallClub) footBallClub).getScored()+team1Scored;
                    playedMatches1=((FootBallClub) footBallClub).getNoOfMatches()+1;
                    goalDifference1 =scored1-noOfGoals1;
                    SportClub footballClub1 = new FootBallClub(clubName1,"",location,foundedYear,wins1,draws1,defeats1,noOfGoals1,scored1,noOfPoints1,playedMatches1, goalDifference1,date);     //pass the object to the constructor
                    PremierLeagueManager.premierLeague.set(PremierLeagueManager.premierLeague.indexOf(footBallClub),footballClub1);         //set the first team object to the relevant index number


                }else if ((footBallClub.getClubName1().equalsIgnoreCase(clubName2))){
                    if (team2Scored > team1Scored) {
                        wins2 = ((FootBallClub) footBallClub).getWins()+1;
                        defeats2 = ((FootBallClub) footBallClub).getDefeats();
                        draws2 = ((FootBallClub) footBallClub).getDraws();
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints()+3;
                    }
                    else if (team1Scored > team2Scored) {
                        wins2 = ((FootBallClub) footBallClub).getWins();
                        defeats2 = ((FootBallClub) footBallClub).getDefeats()+1;
                        draws2 = ((FootBallClub) footBallClub).getDraws();
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints();
                    }
                    else if (team1Scored == team2Scored) {
                        wins2 = ((FootBallClub) footBallClub).getWins();
                        defeats2 = ((FootBallClub) footBallClub).getDefeats();
                        draws2 = ((FootBallClub) footBallClub).getDraws()+1;
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints()+1;
                    }
                    noOfGoals2 = ((FootBallClub) footBallClub).getNoOfGoals()+team1Scored;
                    scored2 = ((FootBallClub) footBallClub).getScored()+team2Scored;
                    playedMatches2=((FootBallClub) footBallClub).getNoOfMatches()+1;
                    goalDifference2 =scored2-noOfGoals2;
                    SportClub footballClub2 = new FootBallClub(clubName2,"",location,foundedYear,wins2,draws2,defeats2,noOfGoals2,scored2,noOfPoints2,playedMatches2, goalDifference2,date);
                    PremierLeagueManager.premierLeague.set(PremierLeagueManager.premierLeague.indexOf(footBallClub),footballClub2);         //set the second team object to the relevant index number
                }
            }
            SportClub playedMatch1 = new FootBallClub(clubName1,clubName2,"","",0,0,0,team1Scored,team2Scored,0,0,0,date);   //pass the matches details to the constructor
            premierLeagueManager.addPlayedMatch(playedMatch1);
        }
    }




}
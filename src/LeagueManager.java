public interface LeagueManager {
    void createNewClub(SportsClub footBallClub) ;
    void deleteClub(String clubName);
    void relegateClubs();
    void displayStatistics(String clubName) ;
    void displayLeagueTable();
    void addPlayedMatch(SportsClub playedMatch1);
    void saveInformation();
    void loadInformation();

}

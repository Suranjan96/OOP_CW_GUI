public interface LeagueManager {
    void createNewClub(SportClub footBallClub) ;
    void deleteClub();
    void displayStatistics(String clubName) ;
    void displayLeagueTable();
    void addPlayedMatch(SportClub playedMatch1);
    void saveInformation();
    void loadInformation();

}

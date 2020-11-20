import java.io.IOException;

public interface LeagueManager {
    void createNewClub(SportClub footBallClub) throws IOException;
    void deleteClub();
    void displayStatistics(String clubName) throws IOException;
    void displayLeagueTable();
    void addPlayedMatch(SportClub playedMatch1) throws IOException;
    void saveInformation();
    void loadInformation();

}

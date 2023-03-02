
/**
 * Beschreiben Sie hier die Klasse UserClient.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class UserClient extends Client
{
    //private GUI gui;
    //private List<User> leaderboard= new List<User>();
    private int[][] ownField = new int[10][10];
    private int[][] enemyField = new int[10][10];
    private Phase phase = Phase.LOGIN;
    private boolean yourTurn = false;
    
    /**
     * Konstruktor für Objekte der Klasse UserClient
     */
    public UserClient(String ip, int port){
        super(ip, port);
        //this.gui=gui;
    }

    public void logIn(String name, String password){}
    public void logOut(){}
    public void challengePlayer(String user){}
    public void placeAt(int x1, int y1, int x2, int y2){}
    public void shootAt(int x, int y){}
    public void shipsPlaced(){}
    public void processMessage(String message){}
    private void receiveFieldUpdate(boolean you, int x, int y, int state){}
    private void receivePlayable(){}
    private void receiveGameEnd(String sieger){}
    private void receiveSignedIn(){}
    private void receiveEnemy(String name){}
    private void receivePlayer(String user){}
    private void receiveLeaderboard(String leaderboard){}
}

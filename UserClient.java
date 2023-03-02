
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

    /**
     * Methode logIn
     *
     * @param name Ein Parameter
     * @param password Ein Parameter
     */
    public void logIn(String name, String password){}
    /**
     * Methode logOut
     *
     */
    public void logOut(){}
    /**
     * Methode startGame
     * 
     * @param User Ein Parameter
     */
    public void startGame(String user) {}
    /**
     * Methode challengePlayer
     *
     * @param user Ein Parameter
     */
    public void challengePlayer(String user){}
    /**
     * Methode placeAt
     *
     * @param x1 Ein Parameter
     * @param y1 Ein Parameter
     * @param x2 Ein Parameter
     * @param y2 Ein Parameter
     */
    public void placeAt(int x1, int y1, int x2, int y2){}
    /**
     * Methode shootAt
     *
     * @param x Ein Parameter
     * @param y Ein Parameter
     */
    public void shootAt(int x, int y){}
    /**
     * Methode shipsPlaced
     *
     */
    public void shipsPlaced(){}
    /**
     * Methode processMessage
     *
     * @param message Ein Parameter
     */
    public void processMessage(String message){}
    /**
     * Methode changePhase
     * 
     * @param phase Ein Parameter
     */
    private void changePhase(int phase){}
    /**
     * Methode receiveFieldUpdate
     *
     * @param you Ein Parameter
     * @param x Ein Parameter
     * @param y Ein Parameter
     * @param state Ein Parameter
     */
    private void receiveFieldUpdate(boolean you, int x, int y, int state){}
    /**
     * Methode receivePlayable
     *
     */
    private void receivePlayable(){}
    /**
     * Methode receiveGameEnd
     *
     * @param sieger Ein Parameter
     */
    private void receiveGameEnd(String sieger){}
    /**
     * Methode receiveSignedIn
     *
     */
    private void receiveSignedIn(){}
    /**
     * Methode receiveEnemy
     *
     * @param name Ein Parameter
     */
    private void receiveEnemy(String name){}
    /**
     * Methode receivePlayer
     *
     * @param user Ein Parameter
     */
    private void receivePlayer(String user){}
    /**
     * Methode receiveLeaderboard
     *
     * @param leaderboard Ein Parameter
     */
    private void receiveLeaderboard(String leaderboard){}
}

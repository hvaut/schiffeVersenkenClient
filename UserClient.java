
/**
 * Beschreiben Sie hier die Klasse UserClient.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class UserClient extends Client
{
    private GUIController gui;
    private List<User> leaderboard= new List<User>();
    private int[][] ownField = new int[10][10];
    private int[][] enemyField = new int[10][10];
    private Phase phase = Phase.LOGIN;
    private boolean yourTurn = false;
    
    /**
     * Konstruktor für Objekte der Klasse UserClient
     */
    public UserClient(String ip, int port, GUIController gui){
        super(ip, port);
        this.gui=gui;
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
    
    // /**
     // * Methode shipsPlaced
     // * CALLED FROM GUI
     // * Method sends Notification about all ships placed to the server
     // *
     // */
    // public void shipsPlaced(){
        // NO FITTING PROTOCOLL COMMAND AVAIABLE
    // }
    
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
     * Method receiveFieldUpdate
     * CALLED FROM processMessage()
     * Method updates both fields
     *
     * @param you Your own ships?
     * @param x X-Coordinate of the field
     * @param y Y-Coordinate of the field
     * @param state New state of the field
     */
    private void receiveFieldUpdate(boolean you, int x, int y, int state){
        if(you) ownField[x][y] = state;
        else enemyField[x][y] = state;
        gui.updateFields();
    }
    
    /**
     * Methode receivePlayable
     *
     */
    private void receivePlayable(){}
    
    /**
     * Method receiveGameEnd
     * CALLED FROM processMessage()
     * Method ends the gameround
     *
     * @param winner Player who has won
     */
    private void receiveGameEnd(String winner){
        phase = Phase.EVALUATION;
        gui.gameEnd();
    }
    
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
     * Method receiveLeaderboard
     * CALLED FROM processMessage()
     * Method updates the leaderboard
     *
     * @param leaderboardString List of player with their points, sorted and presented as String
     */
    private void receiveLeaderboard(String leaderboardString){
        String[] playerAndPoints = leaderboardString.substring(12).split(":");//NEED TO BE CONTROLLED
        if(playerAndPoints.length>0){
            this.leaderboard= new List<User>();
            for(int i=0; i<playerAndPoints.length; i+=2){
                this.leaderboard.append(new User(playerAndPoints[i],playerAndPoints[i+1]));
            }
            gui.updateLeaderboard();
        }
    }
}

import javafx.application.*;

/**
 *  Class to control the different GameScreens
 */
public class GUIController
{
    private Phase currState;
    
    //GUI
    private LoginGUI loginGUI;
    private LobbyGUI lobbyGUI;
    
    private UserClient client;
    
    private boolean yourTurn = false;
    public GUIController(String ip, int port)
    {
        //client = new UserClient(ip, port, this);
        
        //instantiate LOGIN Screen
        currState = Phase.LOGIN;
        loginGUI = new LoginGUI(this);
    }
    
    //Exits the Application
    public void exit()
    {
        System.exit(0);
    }
    
    /**
     * CALLED FROM CLIENT
     * initializes the Phase: "_nextPhase"
     */
    public void nextPhase(Phase _nextPhase)
    {
        //initializes new Window
        switch (_nextPhase)
        {
            case LOGIN:
                loginGUI = new LoginGUI(this);
                break;
            case LOBBY:
                lobbyGUI = new LobbyGUI(this);
                break;
            case PLACEMENT:
                break;
            case GAME:
                break;
            case EVALUATION:
                break;
            default:
                //impossible
                break;
        }
        
        //Quit active Window
        switch (currState)
        {
            case LOGIN:
                loginGUI.quit();
                loginGUI = null;
                break;
            case LOBBY:
                lobbyGUI.quit();
                lobbyGUI = null;
                break;
            case PLACEMENT:
                //placementGUI.quit();
                //placementGUI = null;
                break;
            case GAME:
                //gameGUI.quit();
                //gameGUI = null;
                break;
            case EVALUATION:
                //gameoverGUI.quit();
                //gameoverGUI = null;
                break;
            default:
                //impossible
                break;
        }
        currState = _nextPhase;
    }
    
    //LOGINPHASE
    /**
     * CALLED FROM CLIENT
     * if this method gets called, the player has signed in
     */
    public void signedIn()
    {
        
    }
    
    //LOBBYPHASE
    /**
     * CALLED FROM CLIENT
     * Method updates the List of available Players
     */
    public void updatePlayerList(List<User> playerList)
    {
        
    }
    
    /**
     * CALLED FROM CLIENT
     * Method updates the Leaderboard
     */
    public void updateLeaderboard(List<User> leaderList)
    {
        
    }
    
    /**
     * CALLED FROM CLIENT
     * Method is called, if the a player challanged this client
     */
    public void newChallange(String enemyName)
    {
        //Are you sure its called "Challange"?
    }
    
    /**
     * CALLED FROM CLIENT
     * Method is called, if the challanged player accepted the challange
     */
    public void challangeAccepted()
    {
        
    }
    
    //PLACEMENTPHASE & GAMEPHASE
    /**
     * CALLED FROM CLIENT
     * updates the OWN Field
     */
    public void updateOwnField(FieldEvent[][] ownField){
        
    }
    
    /**
     * CALLED FROM CLIENT
     * Method updates enemy field
     */
    public void updateEnemyField(FieldEvent[][] enemyField)
    {
        
    }
    
    /**
     * CALLED FROM CLIENT
     */
    public void yourTurn()
    {
        yourTurn = true;        
    }
    
    //GAMEENDPHASE
    /**
     * CALLED FROM CLIENT
     * Method is called, if this client has received a rematch request
     */
    public void rematchRequest()
    {
        
    }
    
    /**
     * CALLED FROM CLIENT
     * Method is called, if the rematch request has been denied
     */
    public void rematchDenied()
    {
        
    }
    
    /**
     * CALLED FROM CLIENT
     * Methode displayErrorMessage
     * displays an errorMessage to the user through gui
     *
     * @param errorMessage String
     */
    public void displayErrorMessage(String errorMessage){
    
    }
    
    private void gameEnd()
    {
    
    }
    
    public void updateShips(List<Integer> ships)
    {
    
    }
}
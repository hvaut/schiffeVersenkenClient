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
    
    private boolean yourTurn = false;
    public GUIController()
    {
        currState = Phase.PLACEMENT;
        //instantiate LOGIN Screen
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
                loginGUI = new LoginGUI();
                loginGUI.start(loginGUI.staticStage);
                break;
            case LOBBY:
                lobbyGUI = new LobbyGUI();
                lobbyGUI.start(lobbyGUI.staticStage);
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
        
        //Quit active Application
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
     * if boolean _successfull is true, the login was successfull
     * if String _errorMessage is not null, the login wan't successfull. Errormessage is in the String
     */
    public void signedIn(boolean _successfull, String _errorMessage)
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
    
    //PLACEMENTPHASE
    /**
     * CALLED FROM CLIENT
     * updates the OWN Field
     */
    public void updateField(int x, int y){
        
    }
    
    //GAMEPHASE
    /**
     * CALLED FROM CLIENT
     * Method updates both fields (enemy and own)
     */
    public void updateFields()
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
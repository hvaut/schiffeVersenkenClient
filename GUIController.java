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
    private PlacementGUI placementGUI;
    private GameGUI gameGUI;
    private GameOverGUI gameoverGUI;
    
    private boolean yourTurn = false;
    public GUIController()
    {
        currState = Phase.LOGIN;
        //instantiate LOGIN Screen
        loginGUI = new LoginGUI();
        loginGUI.start(loginGUI.classStage);
        loginGUI.setController(this);
    }
    
    public void QUITTEST()
    {
        loginGUI.quit();
    }
    
    /**
     * CALLED FROM CLIENT
     * initializes the Phase: "_nextPhase"
     */
    public void nextPhase(Phase _nextPhase)
    {
        //Quit active Window
        switch (currState)
        {
            case LOGIN:
                //loginGUI.quit();
                loginGUI = null;
                break;
            case LOBBY:
                //lobbyGUI.quit();
                lobbyGUI = null;
                break;
            case PLACEMENT:
                //placementGUI.quit();
                placementGUI = null;
                break;
            case GAME:
                //gameGUI.quit();
                gameGUI = null;
                break;
            case EVALUATION:
                //gameoverGUI.quit();
                gameoverGUI = null;
                break;
            default:
                //impossible
                break;
        }
        currState = _nextPhase;
        //initializes new Window
        switch (currState)
        {
            case LOGIN:
                loginGUI = new LoginGUI();
                loginGUI.start(loginGUI.classStage);
                loginGUI.setController(this);
                break;
            case LOBBY:
                lobbyGUI = new LobbyGUI();
                //lobbyGUI.start(lobbyGUI.classStage);
                //lobbyGUI.setcontroller(this);
                break;
            case PLACEMENT:
                placementGUI = new PlacementGUI();
                //placementGUI.start(placementGUI.classStage);
                //placementGUI.setcontroller(this);
                break;
            case GAME:
                gameGUI = new GameGUI();
                //gameGUI.start(gameGUI.classStage);
                //gameGUI.setcontroller(this);
                break;
            case EVALUATION:
                gameoverGUI = new GameOverGUI();
                //gameoverGUI.start(gameoverGUI.classStage);
                //gameover.setcontroller(this);
                break;
            default:
                //impossible
                break;
        }
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
    public void updatePlayerList()
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
    public void newChallange()
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
     * updates the own Field
     */
    public void updateField()
    {
        
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
    
    private void gameEnd()
    {
    
    }
}

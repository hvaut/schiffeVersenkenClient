import javafx.application.*;
import javafx.collections.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.ObservableList;

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
    
    private UserClient client;
    
    private Alert alert = new Alert(AlertType.WARNING);
    
    private boolean yourTurn = false;
    public GUIController(String ip, int port)
    {
        try
        {
            client = new UserClient(ip, port, this);
        }catch(Exception e)
        {
            displayErrorMessage(e.getMessage());
        }
        //instantiate LOGIN Screen
        currState = Phase.LOGIN;
        loginGUI = new LoginGUI(this);
    }
    
    //Exits the Application
    public void exit()
    {
        try
        {
            System.exit(0);
        }catch(Exception e)
        {
            displayErrorMessage(e.getMessage());
        }
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
                placementGUI = new PlacementGUI(this);
                break;
            case GAME:
                gameGUI = new GameGUI(this);
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
                placementGUI.quit();
                placementGUI = null;
                break;
            case GAME:
                gameGUI.quit();
                gameGUI = null;
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

    /**
     * CALLED FROM GUI
     * SEND TO CLIENT
     */
    public void tryLogin(String name, String password)
    {
        client.logIn(name, password);
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
    public void displayErrorMessage(String errorMessage)
    {
        alert.setHeaderText("Warnung!");
        alert.setContentText(errorMessage);
        alert.show();
    }
    
    private void gameEnd()
    {
    
    }
    
    public void updateShips(List<Integer> ships)
    {
    
    }
    //utils
    /**
     * Methode getObsList
     * Transforms an List<User> to an ObserverableList<String>. If user has Points, points are added by ":" + user.getPoints()
     *
     * @param users List<User>
     * @param attribute String
     * @return list OberverableList<String>
     */
    private ObservableList<String> getObsList(List<User> users){
        ObservableList<String> list = FXCollections.observableArrayList();
        users.toFirst();
        
        while(users.hasAccess()){
            String content;
            User curr = users.getContent();
            
            content = users.getContent().getName();
            if(curr.getPoints() != null){
                content += ":";
                content += users.getContent().getPoints();
            }
            
            list.add(content);
            users.next();
        }
        return list;
    }

    
    //Von den GUIs aufgerufen
    public void fireOwnField( int x, int y){}
    public void fireEnemyField( int x, int y){}
    public void sendRematchRequest(){}
    public void placeShip(List<int[]> coordinate){}

}
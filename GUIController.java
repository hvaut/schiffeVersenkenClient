/**
 *  Class to control the different GameScreens
 */
public class GUIController
{
    private Phase currState;
    
    private boolean yourTurn = false;
    private GUIController()
    {
        currState = Phase.LOGIN;
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
    public void updatePlayerList(){
        
    }
    
    /**
     * CALLED FROM CLIENT
     * Method updates the Leaderboard
     */
    public void updateLeaderboard()
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
     * Method is called, if this client is received a rematch request
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
    
    //Bitte einfuegen oder mit Client-Gruppe sprechen
    public void gameEnd(){}
}


/**
 * A client to play Fight for ships on Windows
 * It connects you to a local server and so allows you to play against other people
 * 
 * @author Team Client
 * @version 0.1.3
 */
public class UserClient extends Client
{
    private GUIController gui;
    private List<User> leaderboard;
    /**
     * 0 = water
     * 1 = ship
     */
    private int[][] ownField = new int[10][10];
    private int[][] enemyField = new int[10][10];
    
    private Phase phase = Phase.LOGIN;
    private boolean yourTurn = false;
    
    /**
     * Creates an new object of UserClient and tries to create a connection to the server.
     *
     * @param ip Ein Parameter
     * @param port Ein Parameter
     * @param gui Ein Parameter
     */
    public UserClient(String ip, int port, GUIController gui){
        super(ip, port);
        this.gui=gui;
    }

    /**
     * CALLED FROM GUI:
     * Tries to logIn yourself on the Server
     *
     * @param name Username used to identify yourself on the server
     * @param password Password used to identify yourself on the server
     */
    public void logIn(String name, String password){}
    /**
     * CALLED FROM GUI:
     * Logs you out
     *
     */
    public void logOut(){}
    /**
     * CALLED FROM GUI:
     * Asks the server to start a game against the choosen User ?challengePlayer?
     * @param User The person you want to play with
     */
    public void startGame(String user) {
        send("REQUESTENEMY:"+user);
    }
    /**
     * CALLED FROM GUI:
     * Asks the server to start a game against the choosen User ?startGame?
     *
     * @param user Ein Parameter
     */
    public void challengePlayer(String user){}
    /**
     * CALLED FROM GUI:
     * Controlls whether the choosen ship is valid placed.
     * If valid, it also sends it to the server.
     *
     * @param x1 X-Coordinate where your ship begin
     * @param y1 Y-Coordinate where your ship begin
     * @param x2 X-Coordinate where your ship ends
     * @param y2 Y-Coordinate where your ship ends
     * @return Returns true if ship is valid, false otherwise
     */
    public boolean placeAt(int x1, int y1, int x2, int y2){
        int tmp;
        if(x1 > x2){
            tmp = x1;
            x1 = x2;
            x2 = tmp;
        }
        
        if(y1 > y2){
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        
        for(int i = x1-1; i <= x2+1; i++){
            for(int j = x1-1; j <= x2+1; j++){
                if(i >= 0 && i <= 9 && j >= 0 && j<=9){
                    if(ownField[i][j] != 0){
                        return false;
                    }
                }
            }
        }
        
        if(x1 == x2 || y1 == y2){
            for(int i = x1-1; i <= x2+1; i++){
                for(int j = x1-1; j <= x2+1; j++){
                    ownField[i][j] = 1;
                }
            }
        }
        return false;
    }


    /**
     * CALLED FROM GUI:
     * Controlls whether the choosen place is in the field bounds
     * If valid, it also sends the coordinate to the server
     * @param x X-Coordinate of the shoot
     * @param y Y-Coordinate of the shoot
     */
    public void shootAt(int x, int y){
        if(x >= 0 && x <= 9 && y >= 0 && y<=9){
            send("SHOOT:" + x + y);
        }
    }
    
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
    public void processMessage(String message){
        char operator = message.charAt(0);
        switch(operator){
            case '+':
                this.processPositiveResponse(message.substring(1,message.length()));
                break;
            case '-':
                //this.processNegativeResponse();
                break;
            default:
                //this.processRequest();
                break;
        };
    }
        private void processPositiveResponse(String message){
            String[] elements = message.split(":");       
            switch(elements[0]){
                case "LOGIN":
                    this.changePhase(Phase.LOBBY);
                    break;
                case "LOGOUT":
                    this.changePhase(Phase.LOGIN);
                    break;
                case "LEADERBOARD":
                    
                    break;
                case "GETENEMIES":
                    break;
                case "REQUESTENEMY":
                    break;
                case "PLACE":
                    break;
                case "SHOOT":
                    break;
                case "REMATCH":
                    break;
                default:
                    System.out.println("Error at processPositiveResponse with:" + elements[1]);
                    break;
            };
        }
    private void changePhase(Phase phase){
        this.phase = phase;
        this.gui.nextPhase(phase);
    }
    /**
     * Method changePhase
     * CALLED FROM processMessage()
     * Updates game phase in GUI
     * 
     * @param phase Int Parameter which is converted to phase. Contains the numbers 1 to 5. Other values are invalid
     */
    private void changePhase(int phase){
        Phase tmpPhase;
        switch (phase){
            case 1: 
                tmpPhase = Phase.LOGIN;
                break;
            case 2: 
                tmpPhase = Phase.LOBBY;
                break;
            case 3: 
                tmpPhase = Phase.PLACEMENT;
                break;
            case 4: 
                tmpPhase = Phase.GAME;
                break;
            case 5: 
                tmpPhase = Phase.EVALUATION;
                break;
            default:
                System.out.println("CLIENT: Fehler bei der Spielphase - Unbekannte Phase");
                return;
        }
        gui.nextPhase(tmpPhase);
    }
    
    /**
     * Methode receiveFieldUpdate
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
     * Method receivePlayable
     * CALLED FROM processMessage()
     * Calls the method "yourTurn" in GUI
     *
     */
    private void receivePlayable(){
        yourTurn = true;
        gui.yourTurn();
    }
    
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

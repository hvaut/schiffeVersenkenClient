
/**
 * A client to play Fight for ships on Windows
 * It connects you to a local server and so allows you to play against other people
 * 
 * @author Tio/ /Arthur/ /Leon/ /Finn 
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
    
    //ship[1] ==> shipLength 1
    private int[] ships = new int[6];
    
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
    public void logIn(String name, String password){
        this.send("LOGIN:" + name + ":" + password);
    }
    
    /**
     * CALLED FROM GUI:
     * Logs you out
     *
     */
    public void logOut(){
        this.send("LOGOUT");
    }
    
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
    public void challengePlayer(String user){
        
    }
    
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
        int shipLength = 0;
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
        
        if(x1-x2 == 0){
            shipLength = y2-y1;
        }
        
        if(y1-y2 == 0){
            shipLength = x2-x1;
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
        
        if(ships[shipLength] <= 0){
            if(x1 == x2 || y1 == y2){
                for(int i = x1-1; i <= x2+1; i++){
                    for(int j = x1-1; j <= x2+1; j++){
                        ownField[i][j] = 1;
                    }
                }
                send("PLACE:" + x1 + x2 + ":" + y1 + y2);
                return true;
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
     * Processes Message send by server
     *
     * @param message String
     */
    public void processMessage(String message){
        char operator = message.charAt(0);
        switch(operator){
            case '+':
                this.processPositiveResponse(message.substring(1,message.length()));
                break;
            case '-':
                this.processNegativeResponse(message.substring(1, message.length()));
                break;
            default:
                this.processRequest(message);
                break;
        };
    }
        /**
         * Methode processPositiveResponse
         *
         * @param message String Message without operator, that was send by Server
         */
        private void processPositiveResponse(String message){
            String[] elements = message.split(":");       
            switch(elements[0]){
                case "LOGIN":
                    this.receiveSignedIn();
                    break;
                case "LOGOUT":
                    //currently no additions needed
                    break;
                case "LEADERBOARD":
                    this.receiveLeaderboard(elements);
                    break;
                case "GETENEMIES":
                    this.receiveActivePlayers(elements);
                    break;
                case "REQUESTENEMY":
                    //currently no additions needed
                    break;
                case "PLACE":
                    this.updateShips(elements);
                    break;
                case "SHOOT":
                    //currently no additions needed
                    break;
                case "REMATCH":
                    //currently no additions needed
                    break;
                default:
                    System.out.println("Error at processPositiveResponse with:" + elements[0]);
                    break;
            };
        }
        /**
         * Methode processNegativeResponse
         *
         * @param message String Message without operator, that was send by Server
         */
        private void processNegativeResponse(String message){
            String[] elements = message.split(":");
            String errorMessage;
            switch(elements[0]){
                case "LOGIN":
                    errorMessage = elements[1];
                    this.gui.displayErrorMessage(errorMessage);
                    break;
                case "LOGOUT":
                    errorMessage = elements[1];
                    this.gui.displayErrorMessage(errorMessage);
                    break;
                case "LEADERBOARD":
                    errorMessage = elements[1];
                    this.gui.displayErrorMessage(errorMessage);
                    break;
                case "GETENEMIES":
                    errorMessage = elements[1];
                    this.gui.displayErrorMessage(errorMessage);
                    break;
                case "REQUESTENEMY":
                    errorMessage = elements[1];
                    this.gui.displayErrorMessage(errorMessage);
                    break;
                case "PLACE":
                    errorMessage = elements[1];
                    this.gui.displayErrorMessage(errorMessage);
                    break;
                case "SHOOT":
                    errorMessage = elements[1];
                    this.gui.displayErrorMessage(errorMessage);
                    break;
                default:
                    errorMessage = "Error at processNegativeResponse with command:" + elements[0];
                    this.gui.displayErrorMessage(errorMessage);
                    break;
            };
        }
         /**
         * Methode processRequest
         *
         * @param message String Message, that was send by Server
         */
        private void processRequest(String message){
            String[] elements = message.split(":");       
            switch(elements[0]){
                case "STATUS":
                    this.send("+STATUS");
                    try{
                        Phase phase = this.findPhaseForString(elements[1]);
                        this.changePhase(phase);
                    }catch(Exception e){
                        //ErrorMessage, probably with JOptionPane
                    }
                    break;
                case "ENEMIES":
                    this.send("+ENEMIES");
                    this.receiveActivePlayers(elements);
                    break;
                case "SENDSHIPS":
                    this.send("+SENDSHIPS");
                    this.updateShips(elements);
                    break;
                case "GETREQUEST":
                    this.gui.newChallange(elements[1]);
                    break;
                case "ACTIVEUSER":
                    this.send("+ACTIVEUSER");
                    this.receivePlayable();
                    break;
                case "FIELDUPDATE":
                    int fieldID = Integer.parseInt(elements[1]);//2 -> Gegner // 1 -> eigenes Feld
                    int x = Integer.parseInt(elements[2]);
                    int y = Integer.parseInt(elements[3]);
                    
                    this.send("+FIELDUPDATE:" + x + ":" + y); 
                    //position unklar, wie Position (siehe Protokoll) aufgeteilt (x & y)
                    // events als int??
                    // field ID?
                    break;
                case "RESULT":
                    this.send("+RESULT");
                    this.receiveGameEnd(elements[1]);//changes in receiveGameEnd necessary!!!
                    break;
                case "GETREMATCH":
                    this.gui.rematchRequest();
                    break;
                default:
                    System.out.println("Error at processPositiveResponse with:" + elements[0]);
                    break;
            };
        }
            /**
             * Methode updateShips
             * Updates ships in this class and in gui
             * 
             * @param elements String[] params of message from Server
             */
            private void updateShips(String[] elements){
                for(int i = 1; i < 6; i++){
                        int amount = Integer.parseInt(elements[i]);
                        this.ships[i] = amount;
                    }
                this.gui.updateShips(this.makeList(this.ships));
            }
                /**
                 * Methode makeList
                 * Turns an array into a List
                 * 
                 * @param arr int[]
                 * @return liste List<Integer>
                 */
                private List<Integer> makeList(int[] arr){
                     List<Integer> list = new List<>();
                     for(int amount: arr){
                        list.append(amount);
                        }
                    return list;
                }
            /**
             * Method findPhaseForString
             *
             * @param message String Phase that needs to be changed into a Phase Object
             * @return phase Phase
             */
            private Phase findPhaseForString(String message)throws Exception{
                switch(message){
                    case "LOGIN":
                        return Phase.LOGIN;
                    case "LOBBY":
                        return Phase.LOBBY;
                    case "PLACEMENT":
                        return Phase.PLACEMENT;
                    case "GAME":
                        return Phase.GAME;
                    case "EVALUATION":
                        return Phase.EVALUATION;
                    default:
                        throw new Exception("Unknown Phase:" + message);
                }
            }
            
    /**
     * Method changePhase
     * Phase ist changed both for Client and GUI
     *
     * @param phase Phase
     */
    private void changePhase(Phase phase){
        this.phase = phase;
        this.gui.nextPhase(phase);
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
        gui.nextPhase(Phase.EVALUATION);
    }
    
    /**
     * Methode receiveSignedIn
     * CALLED FROM processMessage()
     * Method verifies SignIn
     * 
     */
    private void receiveSignedIn(){
        gui.signedIn(true,"");
    }
    
    /**
     * Methode rematch()
     * CALLED FROM GUI
     * Method request Rematch
     * 
     * @param name Ein Parameter
     */
    private void rematch(boolean rematch){
        if(rematch){
            send("REMATCH");
        }
        else{
            send("+GETREMATCH false");
        }
        
    }
    
    /**
     * Method receiveLeaderboard
     * CALLED FROM processMessage()
     * Method updates the leaderboard
     *
     * @param elements String[] Elements of source String
     */
    private void receiveLeaderboard(String[] elements){
        List<User> leaderList = this.constructLeaderList(elements);
                    this.gui.updateLeaderboard(leaderList);
    }
        /**
         * Method constructLeaderList
         *
         * @param elements Elements of source String
         * @return list List<User> List with User Elements, who have a name and points 
         */
        private List<User> constructLeaderList(String[] elements){
                List<User> list = new List<>();
                
                for(int i = 1; i<elements.length;i = i+2){
                    String name = elements[i];
                    String score = elements[i+1];
                    User user = new User(name, score);
                    list.append(user);
                }
                return list;
            }
    /**
     * Method receiveActivePlayers
     * CALLED FROM processMessage()
     * Method updates the active players list
     *
     * @param elements String[] Elements of the source String
     */
    private void receiveActivePlayers(String[] elements){
       List<User> playerList = this.constructPlayerList(elements);
                this.gui.updatePlayerList(playerList); 
    }
        /**
         * Method constructPlayerList
         *
         * @param elements Elements of source String
         * @return list List<User> List with User Elements, who only have a name
         */
        private List<User> constructPlayerList(String[] elements){
                List<User> list = new List<>();
                
                for(int i = 1; i<elements.length;i++){
                    String name = elements[i];
                    User user = new User(name);
                    list.append(user);
                }
                return list;
            }
}

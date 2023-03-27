
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.event.*;
import javafx.scene.image.*;
import java.util.Random;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 02.03.2023
 * @author Kevin Knoche/ Tio Thoben
 */

public class GameOverGUI extends Application {
    // Anfang Attribute
    private ListView<String> lvLeaderboard = new ListView<>();
    private ObservableList<String> lvLeaderboardObservableList = 
        FXCollections.observableArrayList();
    private Line line1 = new Line();
    private Label lErgebnis = new Label();
    private Label lLeaderboard = new Label();
    private Label lThanks = new Label();
    private Button bRematch = new Button();
    private Button bLobby = new Button();

    private ImageView photo = new ImageView();
    private Image picture;
    //new Image("lk_foto/IMG_5429.JPG");
    // Ende Attribute

    public static Stage staticStage = new Stage();
    private Pane root;
    private GUIController controller;
    //
  // Ende Attribute
  
  public GameOverGUI(GUIController newController)
    {
        controller = newController;
        start(staticStage);
    }
    
    public void start(Stage primaryStage) { 
        Pane root = new Pane();
        Scene scene = new Scene(root, 1264, 986);
        // Anfang Komponenten

        primaryStage.setFullScreen(true);
        lvLeaderboard.setLayoutX(790);
        lvLeaderboard.setLayoutY(80);
        lvLeaderboard.setPrefHeight(900);
        lvLeaderboard.setPrefWidth(425);
        lvLeaderboard.setItems(lvLeaderboardObservableList);
        root.getChildren().add(lvLeaderboard);
        line1.setStartX(750);
        line1.setStartY(20);
        line1.setEndX(751);
        line1.setEndY(1004);
        root.getChildren().add(line1);
        lErgebnis.setLayoutX(40);
        lErgebnis.setLayoutY(130);
        lErgebnis.setPrefHeight(355);
        lErgebnis.setPrefWidth(670);
        lErgebnis.setText("Ergebnis");
        lErgebnis.setAlignment(Pos.CENTER);
        lErgebnis.setFont(Font.font("Castellar", FontWeight.BOLD, 90));
        root.getChildren().add(lErgebnis);
        lLeaderboard.setLayoutX(790);
        lLeaderboard.setLayoutY(30);
        lLeaderboard.setPrefHeight(35);
        lLeaderboard.setPrefWidth(425);
        lLeaderboard.setText("Leaderboard");
        lLeaderboard.setAlignment(Pos.CENTER);
        lLeaderboard.setFont(Font.font("Castellar", 32));
        root.getChildren().add(lLeaderboard);
        lThanks.setLayoutX(150);
        lThanks.setLayoutY(707);
        lThanks.setPrefHeight(35);
        lThanks.setPrefWidth(425);
        lThanks.setText("Danke fürs spielen");
        root.getChildren().add(lThanks);
        bLobby.setLayoutX(40);
        bLobby.setLayoutY(530);
        bLobby.setPrefHeight(100);
        bLobby.setPrefWidth(315);
        bLobby.setOnAction(
            (event) -> {bLobby_Action(event);} 
        );
        bLobby.setText("Lobby");
        root.getChildren().add(bLobby);
        bRematch.setLayoutX(395);
        bRematch.setLayoutY(530);
        bRematch.setPrefHeight(100);
        bRematch.setPrefWidth(315);
        bRematch.setOnAction(
            (event) -> {bRematch_Action(event);} 
        );
        bRematch.setText("Rematch");
        root.getChildren().add(bRematch);
        photo.setX(225);
        photo.setY(707);
        photo.setRotate(270);
        photo.setFitWidth(300);
        photo.setFitHeight(200);
        //for(int i=0; i<18; i++){
        //    photos[i]=new Image("lk_foto/" + i +".JPG");
        //}
        getAuthorImage();
        root.getChildren().add(photo);
        photo.setOnMouseClicked(e -> getAuthorImage());
        // Ende Komponenten

        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("LobbyGUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end of public LobbyGUI

    // Anfang Methoden

    /**
     * Starts the GUI on his own
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main

    /**
     * Informs the GUIController over the pressed Lobby-Button
     *
     * @param evt Event that has fired this method
     */
    public void bLobby_Action(Event evt) {
        // TODO hier Quelltext einfuegen
        controller.nextPhase(Phase.LOBBY);
    } // end of bLobby_Action

    /**
     * Informs the GUIController over the pressed Rematch-Button
     *
     * @param evt Event that has fired this method
     */
    public void bRematch_Action(Event evt) {
        // TODO hier Quelltext einfuegen
        controller.sendRematchRequest();
    } 

    /**
     * Inserts a random image for ImageView "photo" and wraps a thank you message next to it
     */
    public void getAuthorImage(){
        Random random = new Random();
        int number = random.nextInt(16);
        picture = new Image("lk_foto/" + number +".JPG");
        photo.setImage(picture);
        
        String author = getAuthorName(number);
        if (author.equals("")){
            lThanks.setText("Danke fürs spielen :)");
        }else{
            lThanks.setText(author + " sagt: \nDanke fürs spielen :)");
        }
    }
    
    /**
     * Returns the author matching the image number
     */
    private String getAuthorName(int authorNumber){
        switch (authorNumber) {
            case 0:
                return "Kevin";
            case 1:
                return "Tim";
            case 2:
                return "Maximilian";
            case 3:
                return "Ole";
            case 4:
                return "Finn";
            case 5:
                return "John";
            case 6:
                return "Daniel";
            case 7, 8:
                return "Leon";
            case 9:
                return "Georg";
            case 10:
                return "Joshua";
            case 11:
                return "Nikita";
            case 12:
                return "Arthur";
            case 13:
                return "Tio";
            case 14:
                return "Luca";
            case 15:
                return "Herr Vaut";
            default:
                System.out.println("Error at getAuthorName: Wrong number");
                return "";
        }
    }
    // Ende Methoden
} // end of class LobbyGUI


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

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 02.03.2023
 * @author 
 */

public class LobbyGUI extends Application {
  // Anfang Attribute
  private ListView<String> lvPlayerOnline = new ListView<>();
      private ObservableList<String> lvPlayerOnlineObservableList = 
              FXCollections.observableArrayList();
  private ListView<String> lvLeaderboard = new ListView<>();
      private ObservableList<String> lvLeaderboardObservableList = 
              FXCollections.observableArrayList();
  private Line line1 = new Line();
  private Label lPlayerOnline = new Label();
  private Label lLeaderboard = new Label();
  // Ende Attribute
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 1123, 934);
    // Anfang Komponenten
    
    primaryStage.setFullScreen(true);
    lvPlayerOnline.setLayoutX(30);
    lvPlayerOnline.setLayoutY(80);
    lvPlayerOnline.setPrefHeight(900);
    lvPlayerOnline.setPrefWidth(320);
    lvPlayerOnline.setItems(lvPlayerOnlineObservableList);
    root.getChildren().add(lvPlayerOnline);
    lvLeaderboard.setLayoutX(430);
    lvLeaderboard.setLayoutY(80);
    lvLeaderboard.setPrefHeight(900);
    lvLeaderboard.setPrefWidth(785);
    lvLeaderboard.setItems(lvLeaderboardObservableList);
    root.getChildren().add(lvLeaderboard);
    line1.setStartX(395);
    line1.setStartY(20);
    line1.setEndX(396);
    line1.setEndY(980);
    root.getChildren().add(line1);
    lPlayerOnline.setLayoutX(30);
    lPlayerOnline.setLayoutY(30);
    lPlayerOnline.setPrefHeight(35);
    lPlayerOnline.setPrefWidth(320);
    lPlayerOnline.setText("Player Online");
    lPlayerOnline.setAlignment(Pos.CENTER);
    lPlayerOnline.setFont(Font.font("Dialog", 16));
    root.getChildren().add(lPlayerOnline);
    lLeaderboard.setLayoutX(440);
    lLeaderboard.setLayoutY(30);
    lLeaderboard.setPrefHeight(35);
    lLeaderboard.setPrefWidth(785);
    lLeaderboard.setText("Leaderboard");
    lLeaderboard.setAlignment(Pos.CENTER);
    root.getChildren().add(lLeaderboard);
    // Ende Komponenten
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("LobbyGUI");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public LobbyGUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  // Ende Methoden
} // end of class LobbyGUI

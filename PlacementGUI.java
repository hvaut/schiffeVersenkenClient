import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.collections.*;
import javafx.scene.image.*;
/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 16.03.2023
 * @author 
 */

public class PlacementGUI extends Application {
  // Anfang Attribute
  
  private ListView<String> listView1 = new ListView<>();
      private ObservableList<String> listView1ObservableList = 
              FXCollections.observableArrayList();
  private Button button[][] = new Button[10][10];
  private Label lShips = new Label();
  private Label yCord[]= new Label[10];
  private Label xCord[]= new Label[10];
  private Button bReady= new Button();
  // Ende Attribute
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // Anfang Komponenten
    
    primaryStage.setResizable(false);
    primaryStage.setFullScreen(true);
    for(int i=0; i<10;i++)
    {
        xCord[i] = new Label();
        xCord[i].setLayoutX(385+65*i);
        xCord[i].setLayoutY(132);
        xCord[i].setPrefHeight(45);
        xCord[i].setPrefWidth(45);
        xCord[i].setText(Character.toString ((char) 65+i));
        xCord[i].setTextAlignment(TextAlignment.CENTER);
        xCord[i].setAlignment(Pos.CENTER);
        xCord[i].setFont(Font.font("Castellar", FontWeight.BOLD, 24));
        root.getChildren().add(xCord[i]);
    }
    for(int i=0; i<10;i++)
    {
        yCord[i] = new Label();
        yCord[i].setLayoutX(320);
        yCord[i].setLayoutY(197+65*i);
        yCord[i].setPrefHeight(45);
        yCord[i].setPrefWidth(45);
        yCord[i].setText(Integer.toString(i+1));
        yCord[i].setTextAlignment(TextAlignment.CENTER);
        yCord[i].setAlignment(Pos.CENTER);
        yCord[i].setFont(Font.font("Castellar", FontWeight.BOLD, 24));
        root.getChildren().add(yCord[i]);
    }
    for(int i=0; i<10; i++){
        for(int j=0; j<10;j++){
            button[i][j]=new Button();
            button[i][j].setLayoutX(385+65*i);
            button[i][j].setLayoutY(197+65*j);
            button[i][j].setPrefHeight(45);
            button[i][j].setPrefWidth(45);
            final int c=i;
            final int d=j;
            button[i][j].setOnAction(
              (event) -> {button1_Action(c,d);} 
            );
            root.getChildren().add(button[i][j]);
        }
    }
    bReady.setLayoutX(815);
    bReady.setLayoutY(847);
    bReady.setPrefHeight(70);
    bReady.setPrefWidth(200);
    bReady.setText("Ready");
    bReady.setTextAlignment(TextAlignment.CENTER);
    bReady.setAlignment(Pos.CENTER);
    bReady.setFont(Font.font("Castellar", FontWeight.BOLD, 30));
    root.getChildren().add(bReady);
    
    listView1.setLayoutX(80);
    listView1.setLayoutY(197);
    listView1.setPrefHeight(630);
    listView1.setPrefWidth(200);
    listView1.setItems(listView1ObservableList);
    root.getChildren().add(listView1);
    
    lShips.setLayoutX(80);
    lShips.setLayoutY(87);
    lShips.setPrefHeight(70);
    lShips.setPrefWidth(200);
    lShips.setText("Ships");
    lShips.setTextAlignment(TextAlignment.CENTER);
    lShips.setAlignment(Pos.CENTER);
    lShips.setFont(Font.font("Castellar", FontWeight.BOLD, 60));
    root.getChildren().add(lShips);
    
    // Ende Komponenten
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("PlacementGui");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public PlacementGui
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  public void button1_Action(int x,int y) {
    // TODO hier Quelltext einfgen
    
  } // end of button1_Action


  // Ende Methoden
} // end of class PlacementGui


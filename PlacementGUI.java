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
  private Button button[][] = new Button[10][10];
  // Ende Attribute
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // Anfang Komponenten
    
    // Anfang Komponenten
    
    primaryStage.setResizable(false);
    primaryStage.setFullScreen(true);
    for(int i=0; i<10; i++){
        for(int j=0; j<10;j++){
            button[i][j]=new Button();
            button[i][j].setLayoutX(325+65*i);
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
    // Ende Komponenten
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("PlacementGUI");
    primaryStage.setScene(scene);
    primaryStage.show();
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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 15.03.2023
 * @author 
 */

public class Tst extends Application {
  // Anfang Attribute
  private Button button[][] = new Button[10][10];
  // Ende Attribute
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 654, 659);
    // Anfang Komponenten
    
    primaryStage.setResizable(false);
    primaryStage.setFullScreen(true);
    int sizeButtonY =20;
    int sizeButtonX =20;
    int distanceY =10;
    int distanceX =10;
    for(int i=0; i<10; i++){
        for(int j=0; j<10;j++){
            button[i][j]=new Button();
            button[i][j].setLayoutX(40+(sizeButtonX+distanceX)*i);
            button[i][j].setLayoutY(40+(sizeButtonY+distanceY)*j);
            button[i][j].setPrefHeight(sizeButtonY);
            button[i][j].setPrefWidth(sizeButtonX);
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
    primaryStage.setTitle("Tst");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public Tst
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  public void button1_Action(int x,int y) {
    // TODO hier Quelltext einfgen
    
  } // end of button1_Action

  // Ende Methoden
} // end of class Tst

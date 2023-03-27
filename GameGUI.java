import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 16.03.2023
 * @author Kevin Knoche/ Tio Thoben
 */

public class GameGUI extends Application {
    // Anfang Attribute
    private Line line1 = new Line();
    private Label lGegneramZug = new Label();
    private Label lDubistamZug = new Label();
    private Label lBuchstabe1[] = new Label[10];
    private Label lZahl1[] = new Label[10];
    private Button bYourField[][] = new Button[10][10];
    private Label lBuchstabe2[] = new Label[10];
    private Label lZahl2[] = new Label[10];
    private Button bEnemyField[][] = new Button[10][10];
    // Ende Attribute
    
    //IMPORTANT!!!
    // staticStage -> needed to start Application (startMethod called in setController)
    // root -> Pane must be defined here, and NOT in the start method. root must be accessible from the quit() method
    // GUIController -> refference to the GUI controller needed for communication.
    public static Stage staticStage = new Stage();
    private Pane root;
    private GUIController controller;
    //
    
    public GameGUI(GUIController newController)
    {
        controller = newController;
        start(staticStage);
    }

    public void start(Stage primaryStage) { 
        root = new Pane();
        Scene scene = new Scene(root, 1264, 986);
        // Anfang Komponenten

        primaryStage.setFullScreen(true);
        line1.setStartX(640);
        line1.setStartY(20);
        line1.setEndX(641);
        line1.setEndY(1004);
        root.getChildren().add(line1);
        lGegneramZug.setLayoutX(120);
        lGegneramZug.setLayoutY(20);
        lGegneramZug.setPrefHeight(25);
        lGegneramZug.setPrefWidth(400);
        lGegneramZug.setText("Gegner am Zug!");
        lGegneramZug.setFont(Font.font("Castellar", 40));
        lGegneramZug.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(lGegneramZug);
        lDubistamZug.setLayoutX(808);
        lDubistamZug.setLayoutY(32);
        lDubistamZug.setPrefHeight(25);
        lDubistamZug.setPrefWidth(400);
        lDubistamZug.setText("Du bist am Zug");
        lDubistamZug.setFont(Font.font("Castellar", 40));
        lDubistamZug.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(lDubistamZug);
        lDubistamZug.setLayoutX(760);
        lDubistamZug.setLayoutY(20);
        lDubistamZug.setPrefHeight(25);
        lDubistamZug.setPrefWidth(400);
        lDubistamZug.setText("Du bist am Zug!");

        for(int i=0; i<10; i++){
            lBuchstabe1[i] = new Label();
            lBuchstabe1[i].setLayoutX(90+50*i);
            lBuchstabe1[i].setLayoutY(250);
            lBuchstabe1[i].setPrefHeight(30);
            lBuchstabe1[i].setPrefWidth(30);
            lBuchstabe1[i].setText(""+(char)(65+i));
            lBuchstabe1[i].setFont(Font.font("Castellar", 30));
            lBuchstabe1[i].setTextAlignment(TextAlignment.CENTER);
            root.getChildren().add(lBuchstabe1[i]);
            lZahl1[i] = new Label();
            lZahl1[i].setLayoutX(40);
            lZahl1[i].setLayoutY(300+50*i);
            lZahl1[i].setPrefHeight(30);
            lZahl1[i].setPrefWidth(30);
            lZahl1[i].setText(""+i);
            lZahl1[i].setTextAlignment(TextAlignment.CENTER);
            lZahl1[i].setFont(Font.font("Castellar", 30));
            root.getChildren().add(lZahl1[i]);
            for(int j=0; j<10; j++){
                final int x = i;
                final int y=j;
                bYourField[i][j] = new Button();
                bYourField[i][j].setLayoutX(90+50*i);
                bYourField[i][j].setLayoutY(300+50*j);
                bYourField[i][j].setPrefHeight(30);
                bYourField[i][j].setPrefWidth(30);
                bYourField[i][j].setOnAction(
                    (event) -> {bYourField_Action(x, y);} 
                );
                root.getChildren().add(bYourField[i][j]);
            }
        }
        
        for(int i=0; i<10; i++){
            lBuchstabe2[i] = new Label();
            lBuchstabe2[i].setLayoutX(90+50*i+640);
            lBuchstabe2[i].setLayoutY(250);
            lBuchstabe2[i].setPrefHeight(30);
            lBuchstabe2[i].setPrefWidth(30);
            lBuchstabe2[i].setText(""+(char)(65+i));
            lBuchstabe2[i].setFont(Font.font("Castellar", 30));
            lBuchstabe2[i].setTextAlignment(TextAlignment.CENTER);
            root.getChildren().add(lBuchstabe2[i]);
            lZahl2[i] = new Label();
            lZahl2[i].setLayoutX(40+640);
            lZahl2[i].setLayoutY(300+50*i);
            lZahl2[i].setPrefHeight(30);
            lZahl2[i].setPrefWidth(30);
            lZahl2[i].setText(""+i);
            lZahl2[i].setTextAlignment(TextAlignment.CENTER);
            lZahl2[i].setFont(Font.font("Castellar", 30));
            root.getChildren().add(lZahl2[i]);
            for(int j=0; j<10; j++){
                final int x = i;
                final int y=j;
                bEnemyField[i][j] = new Button();
                bEnemyField[i][j].setLayoutX(90+50*i+640);
                bEnemyField[i][j].setLayoutY(300+50*j);
                bEnemyField[i][j].setPrefHeight(30);
                bEnemyField[i][j].setPrefWidth(30);
                bEnemyField[i][j].setOnAction(
                    (event) -> {bEnemyField_Action(x, y);} 
                );
                root.getChildren().add(bEnemyField[i][j]);
            }
        }  
        // Ende Komponenten

        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("GameGUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end of public GameGUI

    // Anfang Methoden
    
    /**
     * Closes the programm
     *
     */
    public void quit()
    {
        ((Stage)root.getScene().getWindow()).close();
    }

    /**
     * Starts the GUI on his own
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        launch(args);
    } // end of main

    /**
     * Informs the GUIController over a pressed button on your Field
     *
     * @param x X-Coordinate of the pressed button
     * @param y Y-Coordinate of the pressed button
     */
    public void bYourField_Action(int x, int y) {
        // TODO hier Quelltext einfuegen
        controller.fireOwnField(x,y);
    } // end of bYourField_Action
    
    /**
     * Informs the GUIController over a pressed button on field 2
     *
     * @param x X-Coordinate of the pressed button
     * @param y Y-Coordinate of the pressed buttonr
     */
    public void bEnemyField_Action(int x, int y) {
        // TODO hier Quelltext einfuegen
        controller.fireEnemyField(x,y);
    } 
    
    public void receiveFieldUpdate(boolean yourField, int x, int y, FieldEvent fieldEvent){
        Button changed;
        if(yourField)changed = bYourField[x][y];
        else changed = bEnemyField[x][y];
        switch (fieldEvent){
            case MISS:
                changed.setStyle("-fx-text-fill: blue; -fx-font-size: 16px;");
                changed.setText("Ö");
                break;
            case HIT:
                changed.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
                changed.setText("X");
                break;
            case SUNK: 
                changed.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
                changed.setStyle("-fx-background-color: red");
                changed.setText("X");
                break;
            case SHIP:
                changed.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
                changed.setText("X");
        }
    }
    // Ende Methoden
} // end of class GameGUI

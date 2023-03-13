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

//must importiert werden, um die Application zu schließen
import javafx.application.Platform;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 01.03.2023
 * @author 
 */

public class LoginGUI extends Application{
    // Anfang Attribute
    private TextField tfUsername = new TextField();
    private TextField tfPassword = new TextField();
    private Button bLogin = new Button();
    private Label lLoginError = new Label();
    private Label lSchiffeversenken = new Label();
    // Ende Attribute

    //Muss eingefügt werden, damit die Klasse instanziert werden kann!
    static Stage classStage = new Stage();
    private GUIController controller;
    
    public void start(Stage primaryStage) { 
        //classStage = primaryStage;

        Pane root = new Pane();
        Scene scene = new Scene(root, 484, 312);
        // Anfang Komponenten

        tfUsername.setLayoutX(160);
        tfUsername.setLayoutY(60);
        tfUsername.setPrefHeight(50);
        tfUsername.setPrefWidth(180);
        tfUsername.setPromptText("Benutzername");
        root.getChildren().add(tfUsername);
        tfPassword.setLayoutX(160);
        tfPassword.setLayoutY(120);
        tfPassword.setPrefHeight(50);
        tfPassword.setPrefWidth(180);
        tfPassword.setPromptText("Passwort");
        root.getChildren().add(tfPassword);
        bLogin.setLayoutX(215);
        bLogin.setLayoutY(175);
        bLogin.setPrefHeight(40);
        bLogin.setPrefWidth(70);
        bLogin.setOnAction(
            (event) -> {bLogin_Action(event);} 
        );
        bLogin.setText("anmelden");
        root.getChildren().add(bLogin);
        lLoginError.setLayoutX(160);
        lLoginError.setLayoutY(220);
        lLoginError.setPrefHeight(40);
        lLoginError.setPrefWidth(180);
        lLoginError.setText("Fehler");
        lLoginError.setTextAlignment(TextAlignment.CENTER);
        lLoginError.setAlignment(Pos.CENTER);
        lLoginError.setTextFill(Color.RED);
        root.getChildren().add(lLoginError);
        lSchiffeversenken.setLayoutX(150);
        lSchiffeversenken.setLayoutY(10);
        lSchiffeversenken.setPrefHeight(25);
        lSchiffeversenken.setPrefWidth(200);
        lSchiffeversenken.setText("Schiffe versenken");
        lSchiffeversenken.setContentDisplay(ContentDisplay.CENTER);
        lSchiffeversenken.setFont(Font.font("Castellar", FontWeight.BOLD, 16));
        lSchiffeversenken.setTextAlignment(TextAlignment.CENTER);
        lSchiffeversenken.setAlignment(Pos.CENTER);
        root.getChildren().add(lSchiffeversenken);
        // Ende Komponenten

        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end of public Login

    // Anfang Methoden

    public void setController(GUIController newController)
    {
        controller = newController;
    }
    
    public void quit()
    {
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    } // end of main

    public void bLogin_Action(Event evt) {
        // TODO hier Quelltext einfuegen

    } // end of bLogin_Action

    // Ende Methoden
} // end of class Login

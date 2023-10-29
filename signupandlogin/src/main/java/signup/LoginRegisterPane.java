package signup;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginRegisterPane extends VBox {

    public LoginRegisterPane() {
        // Erstellen von UI-Elementen: Labels, Textfelder, Schaltflächen
        Label usernameLabel = new Label("Benutzername:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Passwort:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Anmelden");
        Button registerButton = new Button("Registrieren");

        // Hinzufügen der UI-Elemente zum Layout (VBox)
        this.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, registerButton);
    }
}
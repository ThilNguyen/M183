module signup {
    requires javafx.controls;
    requires javafx.fxml;
	requires jbcrypt;
	requires java.sql;

    opens signup to javafx.fxml;
    exports signup;
}

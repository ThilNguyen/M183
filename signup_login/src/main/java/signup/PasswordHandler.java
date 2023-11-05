package signup;

import org.mindrot.jbcrypt.BCrypt;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PasswordHandler {
    private static final String pepper = "thisIsMyPepperValue";
    private String passwordRegex;
    private static final int MIN_LENGTH = 8;

    public boolean isStrongPassword(String password) {
        // Überprüfung der Länge und Komplexität
        if (password.length() < MIN_LENGTH) {
            return false;
        }

        // Überprüfung der Komplexität (Beispielkriterien, anpassen nach Bedarf)
        if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*\\d.*") || !password.matches(".*[@#$%^&+=!?].*")) {
            return false;
        }

        return true;
    }
    
    public static String hashPassword(String plainTextPassword) {
        String salt = BCrypt.gensalt(); 
        String saltedPassword = plainTextPassword + pepper; 
        return BCrypt.hashpw(saltedPassword, salt); 
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        String saltedPassword = plainTextPassword + pepper; 
        return BCrypt.checkpw(saltedPassword, hashedPassword); 
    }
    
}
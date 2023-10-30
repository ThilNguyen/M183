package signup;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHandler {
    private static final String pepper = "thisIsMyPepperValue";

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
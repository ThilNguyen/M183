package signup;

public class PasswordTest {
    public static void main(String[] args) {
        String originalPassword = "passwort123";

        // Hashen des Passworts
        String hashedPassword = PasswordHandler.hashPassword(originalPassword);

        // Überprüfung des Passworts
        boolean passwordMatches = PasswordHandler.checkPassword("passwort123", hashedPassword);

        System.out.println("Original Passwort: " + originalPassword);
        System.out.println("Gehashtes Passwort: " + hashedPassword);
        System.out.println("Passwort stimmt überein: " + passwordMatches);
    }
}

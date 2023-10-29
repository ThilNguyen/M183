package signup;

public class PasswordTest {
    public static void main(String[] args) {
        String originalPassword = "passwort123"; 

      
        String hashedPassword = PasswordHandler.hashPassword(originalPassword);

 
        boolean passwordMatches = PasswordHandler.checkPassword("passwort123", hashedPassword);
        System.out.println("Passwort stimmt überein: " + passwordMatches); 
    }
}

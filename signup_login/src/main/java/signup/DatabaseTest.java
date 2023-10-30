package signup;

public class DatabaseTest {

    public static void main(String[] args) {
        Database db = new Database();
        db.createTables(); 

       
        String userFields = "Benutzername, Passwort, Email, Registrierungsdatum";
        String userValues = "'Peter', 'hashedPassword123', 'max@example.com', '2023-10-30'";
        db.insert("User", userFields, userValues);

     
        String email = db.getValue("User", "Benutzername", "'Peter'", "Email");
        System.out.println("Email: " + email);

    
        boolean isAvailable = db.isKeyAvailable("User", "Benutzername", "'Peter'");
        if (isAvailable) {
            System.out.println("Der Benutzer existiert.");
        } else {
            System.out.println("Der Benutzer existiert nicht.");
        }
    }
}
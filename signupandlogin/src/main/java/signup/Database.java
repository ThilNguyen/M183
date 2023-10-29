package signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    protected final String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/db.sqlite";

    public void createTables() {
        createUsersTable();
        createSecurityDataTable();
    }

    private void createUsersTable() {
        String fields = "ID INTEGER PRIMARY KEY, Benutzername TEXT, Passwort TEXT, Email TEXT, Registrierungsdatum TEXT";
        createTable("User", fields);
    }

    private void createSecurityDataTable() {
        String fields = "ID INTEGER PRIMARY KEY, Benutzer_ID INTEGER, Salz TEXT";
        createTable("SecurityData", fields);
    }
    
    private void createTable(String tableName, String fields) {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + fields + ")";
                stmt.execute(sql);
                System.out.println("Tabelle " + tableName + " erstellt.");
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insert(String tableName, String fields, String values) {
        try (Connection conn = DriverManager.getConnection(url)) {
 
            if (conn != null) {            
                conn.setAutoCommit(false);
                var stmt = conn.createStatement();
                var sql = "INSERT INTO " + tableName + "("  + fields + ") VALUES (" + values +")";
                stmt.executeUpdate(sql);

                stmt.close();
                conn.commit();
                conn.close();
            }
            System.out.println("Insert in " + tableName + " is done");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
 
    public String getValue(String tableName, String keyName, String keyValue, String fieldName) {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {            
                var stmt = conn.createStatement();
                
                var sql = "SELECT * FROM " + tableName + " WHERE " + keyName + " == " + keyValue;
                var rs = stmt.executeQuery(sql);
                try {
                    var exS = rs.getString(fieldName);
                    stmt.close();
                    conn.close();
                    return exS;
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    stmt.close();
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public boolean isKeyAvailable(String tableName, String keyName, String keyValue) {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {  
                Statement stmt = conn.createStatement();
                var sql = "SELECT * FROM " + tableName + " WHERE " + keyName + " == " + keyValue; 

                ResultSet rs = stmt.executeQuery(sql);
                try {
                    String exS = rs.getString(keyName);       
                    System.out.println("Key value " + exS + " from table " + tableName + " exists.");
                    stmt.close();
                    conn.close();
                    return true;
                } catch (SQLException e) {
                    System.out.println("Key value " + keyValue + " from table " + tableName + "  not exists.");
                    stmt.close();
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false; 
    }
}

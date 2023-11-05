/*  Account
 *
 *  Copyright (C) 2023  Robert Schoech
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package signup;

public class Account extends Database {

    public void initAccount() {
        createTables();
    }
    
    public boolean isUsernameTaken(String userName) {
        return isKeyAvailable("User", "Benutzername", "'" + userName + "'");
    }

    public void addAccount(String name, String password) {
    	if (isUsernameTaken(name)) {
            System.out.println("Benutzername bereits vergeben!");
            // Hier können weitere Aktionen, wie eine Fehlermeldung an den Benutzer oder andere Handhabungen, eingefügt werden
        } else {
            insert("User", "Benutzername, Passwort", "'" + name + "', '" + PasswordHandler.hashPassword(password) + "'");
        }
    }
   

    public boolean verifyAccount(String userName) {
    	 return isKeyAvailable("User", "Benutzername", "'" + userName + "'");  
    }

    public boolean verifyPassword(String userName, String password) {
    	 String storedPassword = getValue("User", "Benutzername", "'" + userName + "'", "Passwort");

         return PasswordHandler.checkPassword(password, storedPassword); // Überprüfung des Passworts
    }

}


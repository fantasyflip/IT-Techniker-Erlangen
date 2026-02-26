import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MySQLRemoteExample {

    // Datenbank-Zugangsdaten
    private static final String URL =
            "jdbc:mariadb://10.33.34.201:3306/firma";
    private static final String USER = "philipp";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {

        String query = "SELECT KNr, name FROM kunden";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            System.out.println("Verbindung erfolgreich!\n");

            while (resultSet.next()) {
                int KNr = resultSet.getInt("KNr");
                String Name = resultSet.getString("Name");

                System.out.println("KNr: " + KNr + ", Name: " + Name);
            }

        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankverbindung:");
            e.printStackTrace();
        }
    }
}
 
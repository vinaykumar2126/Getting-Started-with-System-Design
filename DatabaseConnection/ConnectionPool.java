package DatabaseConnection;
import java.util.ArrayList;
import java.util.List;
// This class is a Singleton.
public class ConnectionPool {
    // 1. The single, static instance of the class.
    private static ConnectionPool instance;

    // The list of available connections (the "wristbands").
    private List<DatabaseConnection> connections;
    private static final int MAX_CONNECTIONS = 5;

    // 2. The private constructor. No one else can create an instance.
    private ConnectionPool() {
        connections = new ArrayList<>();
        // Create the fixed number of connections when the pool is first created.
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            connections.add(new DatabaseConnection());// Composition owning the DatabaseConnection
        }
    }

    // 3. The public, static method to get the single instance.
    // The 'synchronized' keyword makes it thread-safe.
    public static synchronized ConnectionPool getInstance() {
        // If the instance doesn't exist yet, create it.
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    // Method to "borrow" a connection from the pool.
    public synchronized DatabaseConnection getConnection() {
        if (connections.isEmpty()) {
            // In a real system, you might wait or throw an exception.
            System.out.println("No connections available.");
            return null;
        }
        // Remove the first available connection and give it to the user.
        return connections.remove(0);
    }

    // Method to "return" a connection to the pool.
    public synchronized void releaseConnection(DatabaseConnection connection) {
        if (connection != null) {
            // Add the connection back to the list of available ones.
            connections.add(connection);
        }
    }
}
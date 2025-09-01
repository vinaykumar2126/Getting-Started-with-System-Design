package DatabaseConnection;
public class Main {
    public static void main(String[] args) {
        // Get the single instance of the connection pool.
        ConnectionPool pool = ConnectionPool.getInstance();

        // Simulate a user borrowing a connection.
        System.out.println("User 1 is borrowing a connection.");
        DatabaseConnection user1Connection = pool.getConnection();

        // Simulate another user borrowing a connection.
        System.out.println("User 2 is borrowing a connection.");
        DatabaseConnection user2Connection = pool.getConnection();

        // User 1 uses the connection.
        if (user1Connection != null) {
            user1Connection.executeQuery("SELECT * FROM users");
        }
        
        // User 1 is done and returns the connection.
        System.out.println("User 1 is returning their connection.");
        pool.releaseConnection(user1Connection);
        
        // Now User 3 can get a connection.
        System.out.println("User 3 is borrowing a connection.");
        DatabaseConnection user3Connection = pool.getConnection(); // This gets the one User 1 just returned.
    }
}
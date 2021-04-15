
package utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager instance = null;
    private static final String url = "jdbc:postgresql://localhost:1234/sporsalonum";   
    private static final String driverName = "org.postgresql.Driver";   
    private static final String username = "postgres";   
    private static final String password = "root1234";
    private static Connection con;
    
   
    private  ConnectionManager(){
    }
    
    
    public synchronized static ConnectionManager getInstance()
    {
        
        if(instance == null)
        {
            instance  = new ConnectionManager();
        }
        return instance;
    }
    
   
   
    public  Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection."+ex.getMessage()); 
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found "); 
        }
        return con;
    }
    public static void main(String [] args){
        ConnectionManager cm = new ConnectionManager();
        cm.getConnection();
    }
}


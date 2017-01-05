package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grze
 */
public class JdbcTest {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/phonebook?zeroDateTimeBehavior=convertToNull";
        String dbUser = "root";
        String dbPass = "";
        Connection connection = null;
        
        try {

            connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
            System.out.println("\n>>>\tSuccess! Connection OK!\t<<<");            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n>>>\tConnection error & falure...\t<<<");
        } finally {
            
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcTest.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
            
        }

    }

}

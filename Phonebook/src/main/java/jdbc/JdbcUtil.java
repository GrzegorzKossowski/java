package jdbc;

import beans.Person;
import beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlets.LoginServlet;

/**
 *
 * @author grze
 */
public class JdbcUtil {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/phonebook?zeroDateTimeBehavior=convertToNull&useSSL=false";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static Connection connection = null;
    private static Statement statement = null;

    public static void JdbcConnecitonTest() {
        
        try {
            
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            System.out.println("\n>>>\tSuccess! Connection OK!\t<<<");
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }

    }

    public static boolean isUserValid(User user) {

        boolean isValid = false;

        try {

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
            String sql = "SELECT login, password FROM user WHERE login='" + user.getLogin() + "' AND password='" + user.getPassword() + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (!resultSet.isBeforeFirst()) {
                isValid = false;
            } else {
                isValid = true;
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JdbcUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex2) {
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
            }
        }
        
        return isValid;
        
    }

    public static List<Person> getPersons() {

        List<Person> persons = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
            String sql = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int i = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String phone = resultSet.getString("phone");
                String mobile = resultSet.getString("mobile");
                String email = resultSet.getString("email");

                Person person = new Person(i, firstname, lastname, phone, mobile, email);
                persons.add(person);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JdbcUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex2) {
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
            }

        }
        
        return persons;
        
    }

    public static Person getPerson(String personId) {

        Person person = null;

        try {

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
            String sql = "SELECT * FROM person WHERE id='" + personId + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int i = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String phone = resultSet.getString("phone");
                String mobile = resultSet.getString("mobile");
                String email = resultSet.getString("email");

                person = new Person(i, firstname, lastname, phone, mobile, email);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JdbcUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex2) {
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
            }

        }

        return person;
    }

    public static boolean savePerson(Person person) {

        boolean error = false;

        try {

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
            String sql = "set names 'utf8'";
            statement.executeQuery(sql);
            sql = "INSERT INTO person "
                    + "(firstname, lastname, phone, mobile, email)"
                    + " VALUES "
                    + "('" + person.getFirstname() + "', '" + person.getLastname()
                    + "', '" + person.getPhone() + "', '" + person.getMobile()
                    + "', '" + person.getEmail() + "')";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            error = false;

        } catch (ClassNotFoundException | SQLException ex) {
            error = true;
            Logger.getLogger(JdbcUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex2) {
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
            }

        }

        return error;

    }

    public static void deletePerson(String personId) {

        try {

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
            String sql = "DELETE FROM person WHERE id='" + personId + "'";
            statement.executeUpdate(sql);            
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JdbcUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex2) {
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
            }

        }

    }

    public static void updatePerson(Person person) {

        try {

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
            String sql = "set names 'utf8'";
            statement.executeQuery(sql);
            sql = "UPDATE person SET "
                    + "firstname='" + person.getFirstname() 
                    + "', lastname='" + person.getLastname()
                    + "', phone='" + person.getPhone()
                    + "', mobile='" + person.getMobile()
                    + "', email='" + person.getEmail()
                    + "' WHERE id='" + person.getId() + "'";
            statement.executeUpdate(sql);            
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JdbcUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex2) {
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
            }

        }
        
    }

}
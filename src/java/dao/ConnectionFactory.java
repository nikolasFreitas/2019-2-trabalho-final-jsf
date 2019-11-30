package dao;

import java.sql.*;

/**
 *
 * @author silviacb
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho_final_jsf", "nikolas", "123");
        } catch (ClassNotFoundException e) {
            System.out.println("driver não localizado");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("não conseguiu conectar");
        }
        return null;
    }
}

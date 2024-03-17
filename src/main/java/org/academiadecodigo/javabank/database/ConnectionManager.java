package org.academiadecodigo.javabank.database;

import java.sql.*;

public class ConnectionManager {
    private Connection connection = null;
    public Connection getConnection() {

        try {
            if (connection == null) {
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myJavaBank", "root", "eua6td");
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database : " + ex.getMessage());
        }
        return this.connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }

    public String getCustomers() throws SQLException {

        String result = null;
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM customer";
        ResultSet resultSet = statement.executeQuery(query);


        while (resultSet.next()) {
            result = resultSet.getString(2);
            System.out.println(result);
        }
        return result;
    }

}


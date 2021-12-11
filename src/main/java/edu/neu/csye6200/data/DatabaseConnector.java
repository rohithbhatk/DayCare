package edu.neu.csye6200.data;

import java.sql.*;

public class DatabaseConnector {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/daycare";


    private Connection dbConnection = null;

    static final String USER = "root";
    static final String PASS = "1234";


    protected Connection openConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            this.dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
            return this.dbConnection;
    }

//    protected void closeConnection(Statement statement) throws SQLException {
//        if(statement!=null){
//            statement.close();
//        }
//        this.closeConnection();
//    }

    protected void closeConnection() {
        if(this.dbConnection!=null){
            try {
                dbConnection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}



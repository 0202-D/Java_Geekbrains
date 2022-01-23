package Lesson_8.ServerSide;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dm.Petrov
 * DATE: 22.01.2022
 */
public class DBConn {
    private static Connection connection;
    private DBConn(){}
    public static Connection getConnection() throws SQLException {
        if(connection==null){
            connection= DriverManager.getConnection("jdbc:sqlite:my.db");
           }
        return connection;
        }

    }


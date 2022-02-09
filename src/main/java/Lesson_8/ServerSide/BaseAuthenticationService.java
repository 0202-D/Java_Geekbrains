package Lesson_8.ServerSide;

import java.sql.*;

/**
 * @author Dm.Petrov
 * DATE: 23.01.2022
 */
public class BaseAuthenticationService implements AuthService{
    private static Connection dbConn ;
    private static Statement statement;
    private static PreparedStatement ps;
    @Override
    public void start() {
        try {
            dbConn= DBConn.getConnection();
            statement=dbConn.createStatement();
            System.out.println("Connecting to the database");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        }


    @Override
    public String getNickByLoginPass(String login, String pass) {

        try {
            ps = dbConn.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?;");
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("nick");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static boolean changeNickName(String currentNick,String newNick) throws SQLException {
        try{
            ps = dbConn.prepareStatement("UPDATE users SET nick = ? WHERE nick = ?;");
            ps.setString(1, newNick);
            ps.setString(2, currentNick);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public void stop() {
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(dbConn!=null){
            try {
                dbConn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

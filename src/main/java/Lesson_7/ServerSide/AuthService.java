package Lesson_7.ServerSide;
/**
 * @author Dm.Petrov
 * DATE: 18.12.2021
 */
public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();

}

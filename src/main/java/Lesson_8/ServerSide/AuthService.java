package Lesson_8.ServerSide;

/**
 * @author Dm.Petrov
 * DATE: 26.12.2021
 */
public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();

}

/**
 * @author Dm.Petrov
 * DATE: 15.12.2021
 */
package Lesson_6;

/**
 * @author Dm.Petrov
 * DATE: 15.12.2021
 */
public class ServerMain {
    public static void main(String[] args) {
        Server server = new Server();
        new Thread(() -> {
            server.sendMessage();
        }).start();

        new Thread(() -> {
            server.readMessage();
        }).start();

    }

}

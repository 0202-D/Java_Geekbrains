package Lesson_6;

/**
 * @author Dm.Petrov
 * DATE: 15.12.2021
 */
public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();

        new Thread(() -> {
            client.sendMessage();
        }).start();

        new Thread(() -> {
            client.readMessage();
        }).start();


    }
}

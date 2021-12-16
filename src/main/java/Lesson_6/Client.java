package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Dm.Petrov
 * DATE: 15.12.2021
 */
public class Client {
    private Socket socket;
    private final String SERVER_ADDRESS = "127.0.0.1";
    private DataOutputStream dos;
    private DataInputStream dis;
    String clientMessage;
    Scanner scanner;

    public Client() {
        init();

    }

    private void init() {
        try {
            Thread.sleep(5000);
            socket = new Socket(SERVER_ADDRESS, 666);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendMessage() {
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);

            while (true) {
                clientMessage = scanner.nextLine();
                if (clientMessage != null) {
                    dos.writeUTF(clientMessage);
                }
                if (clientMessage.equalsIgnoreCase("/exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void readMessage() {
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            while (true) {
                String message = dis.readUTF();
                if (message.equalsIgnoreCase("/end")) {
                    System.out.println("Server say goodBay");
                    closeConnections();
                    break;
                }
                System.out.println("ServerMessage : " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnections() {
        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

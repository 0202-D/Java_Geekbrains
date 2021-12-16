package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Dm.Petrov
 * DATE: 15.12.2021
 */
public class Server {
    private ServerSocket socket;
    private Socket client;
    DataOutputStream dos;
    DataInputStream dis;
    Scanner scanner;
    String inBoundMessage;
    String outBoundMessage;

    public Server() {
        init();

    }

    private void init() {
        try {
            socket = new ServerSocket(666);
            System.out.println("Socked created...");
            System.out.println("Waiting for a connection...");
            client = socket.accept();
            System.out.println("Client connected " + client);
            System.out.println("Status ok");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Status not");
        }
    }

    void sendMessage() {
        try {
            dos = new DataOutputStream(client.getOutputStream());
            dis = new DataInputStream((client.getInputStream()));
            scanner = new Scanner(System.in);

            while (true) {
                outBoundMessage = scanner.nextLine();
                if (outBoundMessage != null) {
                    dos.writeUTF(outBoundMessage);
                }
                if (outBoundMessage.equalsIgnoreCase("/end")) {
                    closeConnections();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readMessage() {
        try {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            scanner = new Scanner(System.in);
            while (true) {
                inBoundMessage = dis.readUTF();
                if (inBoundMessage.equalsIgnoreCase("/exit")) {
                    System.out.println("Client say goodBay");
                    dos.writeUTF("/end");
                    break;
                }
                System.out.println("ClientMessage : " + inBoundMessage);

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
        //  scanner.close();
    }

}


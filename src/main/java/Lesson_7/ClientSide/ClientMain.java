package Lesson_7.ClientSide;

import java.io.IOException;

/**
 * @author Dm.Petrov
 * DATE: 18.12.2021
 */
public class ClientMain {
    public static void main(String[] args) {
        try {
            new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
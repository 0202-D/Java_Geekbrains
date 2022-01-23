package Lesson_8.ServerSide;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dm.Petrov
 * DATE: 26.12.2021
 */

public class MyServer {

    private static final Integer PORT = 8088;

    private AuthService authenticationService;
    private List<ClientHandler> handlerList;

    public MyServer() {
        System.out.println("Server started.");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            authenticationService = new BaseAuthenticationService();
            authenticationService.start();
            handlerList = new ArrayList<>();
            while (true) {
                System.out.println("Server wait connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");
                new ClientHandler(this, socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            authenticationService.stop();
        }
    }

    public synchronized boolean nickNameIsBusy(String nickName) {
        return handlerList
                .stream()
                .anyMatch(clientHandler -> clientHandler.getNickName().equalsIgnoreCase(nickName));
    }

    public synchronized void sendMessageToClients(String message) {
        handlerList.forEach(clientHandler -> clientHandler.sendMessage(message));
    }

    public synchronized void sendMessageToClients(ClientHandler cH, String to, String message) {
        for (ClientHandler clientHandler : handlerList) {
            if (clientHandler.getNickName().equals(to)) {
                clientHandler.sendMessage("  You have a message from  " + cH.getNickName() + ": " + message);
                cH.sendMessage(" Message for : " + to + ": " + message);
                return;
            }
        }

        cH.sendMessage("Client " + to + " out of chat");
    }


    public synchronized void getOnlineUsers(ClientHandler clientHandler) {
        String str = new String("Now online:\n");
        for (ClientHandler cH : handlerList) {
            if (cH.getNickName().equals(clientHandler.getNickName())) {
                continue;
            }
            str = str.concat(cH.getNickName() + " \n ");
        }
        clientHandler.sendMessage(str);
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        handlerList.add(clientHandler);
    }

    public synchronized void unSubscribe(ClientHandler clientHandler) {
        handlerList.remove(clientHandler);
    }

    public AuthService getAuthenticationService() {
        return this.authenticationService;
    }
}





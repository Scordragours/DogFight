package controller;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer{
    private ServerSocket serveurSocket;
    private SocketClient SocketClient;


    public void Socket(){
        try{
            serveurSocket = new ServerSocket(5000);
            SocketClient = new SocketClient(serveurSocket.accept());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
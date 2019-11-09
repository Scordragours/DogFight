package controller;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer{
    private ServerSocket serveurSocket;
    private Thread SocketClient;
    public String Pseudo;
    private int i = 1;

    public void Socket(){
        try{
            serveurSocket = new ServerSocket(802);
            SocketClient = new Thread(new SocketClient(serveurSocket.accept(), this, i));
            SocketClient.start();
            System.out.print(Pseudo);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
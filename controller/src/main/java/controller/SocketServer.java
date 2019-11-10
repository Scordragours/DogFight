package controller;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer{
    private ServerSocket ServeurSocket;
    private Thread SocketClient[] = new Thread[2];
    public String Pseudo;

    public SocketServer(){
        try{
            this.ServeurSocket = new ServerSocket(802);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void StartServer(){
        for(int i = 0; i < 2; i++){
            try{
                this.SocketClient[i] = new Thread(new SocketClient(this.ServeurSocket.accept(), this, i));
                this.SocketClient[i].start();
                System.out.print(this.Pseudo);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
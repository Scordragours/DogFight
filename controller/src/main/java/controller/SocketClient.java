package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient implements Runnable{
    // Attributs :
    private Socket SocketClient;
    private BufferedReader Input;
    private PrintWriter Output;
    private Thread TEnvoyer, TRecevoir;
    private int _Identifiant;
    private SocketServer SocketServer;

    // Constructeur :
    public SocketClient(Socket SocketClient, SocketServer SocketServer, int Identifiant){
        this.SocketClient = SocketClient;
        this._Identifiant = Identifiant;
        this.SocketServer = SocketServer;

        try{
            this.Output = new PrintWriter(this.SocketClient.getOutputStream());
            this.Input = new BufferedReader (new InputStreamReader(this.SocketClient.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.TEnvoyer = new Thread(new Envoi(this));
        this.TRecevoir = new Thread(new Recevoir(this));
    }

    // Méthode :
    public void run(){
        this.TEnvoyer.start();
        this.TRecevoir.start();
    }

    // Class interne :
    class Envoi implements Runnable{
        String msg;
        Envoi(SocketClient SocketClient){}
        public void run(){}
    }
    class Recevoir implements Runnable{
        String msg;

        Recevoir(SocketClient SocketClient){
            try{
                msg = Input.readLine();
                SocketClient.SocketServer.Pseudo = msg;
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        public void run(){
            try{
                msg = Input.readLine();
                while(msg != null){
                    System.out.println("Client : "+ msg);
                    msg = Input.readLine();
                }
                System.out.println("Client déconecté");
                Output.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
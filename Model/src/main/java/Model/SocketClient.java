package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient implements Runnable{
    // Attributs :
    private Socket ClientSocket;
    private BufferedReader Input;
    private PrintWriter Output;
    private Thread TEnvoyer, TRecevoir;
    private int _Identifiant;
    private Model Model;

    // Constructeur :
    SocketClient(Socket Socket, Model Model, int Identifiant){
        this.ClientSocket = Socket;
        this._Identifiant = Identifiant;
        this.Model = Model;

        try{
            this.Output = new PrintWriter(this.ClientSocket.getOutputStream());
            this.Input = new BufferedReader(new InputStreamReader(this.ClientSocket.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.TEnvoyer = new Thread(new Envoyer());
        this.TRecevoir = new Thread(new Recevoir());
    }

    // Méthodes :
    public void run(){
        this.TEnvoyer.start();
        this.TRecevoir.start();
    }

    // Class Interne :
    class Envoyer implements Runnable{
        public void run(){}
    }
    class Recevoir implements Runnable{
        String Message;

        Recevoir(){
            try{
                Message = Input.readLine();
                System.out.println(Message);
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        public void run(){
            try{
                Message = Input.readLine();
                while(Message != null){
                    System.out.println("Client : "+ Message);
                    Message = Input.readLine();
                }
                System.out.println("Client Crash");
                Output.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
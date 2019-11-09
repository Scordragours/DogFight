package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient{
    private Socket SocketClient;
    private BufferedReader Input;
    private PrintWriter Output;
    private Scanner sc;

    // Constructeur :
    public SocketClient(Socket SocketClient){
        this.setSocketClient(SocketClient);
        try{
            sc = new Scanner(System.in);

            Output = new PrintWriter(this.getSocketClient().getOutputStream());
            Input = new BufferedReader (new InputStreamReader(this.getSocketClient().getInputStream()));

            Envoi E = new Envoi();
            Recevoir rec = new Recevoir();

            Thread TEnvoi = new Thread(E);
            Thread TRec = new Thread(rec);

            TEnvoi.start();
            TRec.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Getter :
    public Socket getSocketClient(){
        return this.SocketClient;
    }

    // Setter :
    public void setSocketClient(Socket SocketClient){
        this.SocketClient = SocketClient;
    }

    // Class interne :
    class Recevoir implements Runnable{
        String msg ;
        public void run(){
            try{
                msg = Input.readLine();
                //tant que le client est connecté
                while(msg != null){
                    System.out.println("Client : "+ msg);
                    msg = Input.readLine();
                }
                //sortir de la boucle si le client a déconecté
                System.out.println("Client déconecté");
                //fermer le flux et la session socket
                Output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Envoi implements Runnable{
        String msg;
        public void run(){
            while(true){
                msg = sc.nextLine();
                Output.println(msg);
                Output.flush();
            }
        }
    }
}
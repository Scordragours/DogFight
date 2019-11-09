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
    private String Pseudo = " ";
    private Model Model;
    private int Identifiant;

    // Constructeur :
    public SocketClient(Socket Socket, Model Model, int i){
        this.setClientSocket(Socket);
        this.setModel(Model);
        this.setIdentifiant(i);
        try{
            this.setOutput(new PrintWriter(this.getClientSocket().getOutputStream()));
            this.setInput(new BufferedReader(new InputStreamReader(this.getClientSocket().getInputStream())));

            Envoyer Envoyer = new Envoyer();
            Recevoir Recevoir = new Recevoir();

            Thread TEnvoyer = new Thread(Envoyer);
            TEnvoyer.start();

            Thread TRecevoir = new Thread(Recevoir);
            TRecevoir.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Getter :
    public Socket getClientSocket(){
        return this.ClientSocket;
    }
    public BufferedReader getInput(){
        return this.Input;
    }
    public PrintWriter getOutput(){
        return this.Output;
    }
    public String getPseudo(){
        return this.Pseudo;
    }
    public Model getModel(){
        return this.Model;
    }
    public int getIdentifiant(){
        return this.Identifiant;
    }

    // Setter :
    public void setClientSocket(Socket ClientSocket){
        this.ClientSocket = ClientSocket;
    }
    public void setInput(BufferedReader Input){
        this.Input = Input;
    }
    public void setOutput(PrintWriter Output){
        this.Output = Output;
    }
    public void setPseudo(String Pseudo){
        this.Pseudo = Pseudo;
    }
    public void setModel(Model Model){
        this.Model = Model;
    }
    public void setIdentifiant(int Identifiant){
        this.Identifiant = Identifiant;
    }

    // Méthodes :
    public void run(){
        try{
            this.setOutput(new PrintWriter(this.getClientSocket().getOutputStream()));
            this.setInput(new BufferedReader(new InputStreamReader(this.getClientSocket().getInputStream())));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Class Interne :
    class Envoyer implements Runnable{
        public void run(){}
    }
    class Recevoir implements Runnable{
        String Message;
        public Recevoir(){
            try{
                String l = Input.readLine();
                //System.out.print(l);
                Model.getPlayers()[Identifiant].setPseudo(l);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        public void run(){
            try{
                while(true){
                    Message = Input.readLine();
                    switch(Message){
                        case "LEFT":
                            Model.getPlayers()[Identifiant].setDirection(Direction.LEFT);
                            break;
                        case "RIGHT":
                            Model.getPlayers()[Identifiant].setDirection(Direction.RIGHT);
                            break;
                        case "UP":
                            Model.getPlayers()[Identifiant].setDirection(Direction.UP);
                            break;
                        case "DOWN":
                            Model.getPlayers()[Identifiant].setDirection(Direction.DOWN);
                            break;
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
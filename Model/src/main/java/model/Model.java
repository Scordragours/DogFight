package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Model extends Observable{
	// Attributs :
	private int TailleX, TailleY;
	private Entity Entity[][];
	private Avions Players[];
	private ServerSocket ServerSocket;
	private Socket PlayersConnection[];

	// Constructeur :
	public Model(int TailleX, int TailleY){
		this.setTailleX(TailleX);
		this.setTailleY(TailleY);
		this.setEntity(new Entity[this.getTailleY()][this.getTailleX()]);
		this.setPlayers(new Avions[2]);
		this.setPlayersConnection(new Socket[2]);

		try{
			ServerSocket = new ServerSocket(802);
			System.out.println("Serveur Start.");
		}catch(IOException e){
			System.err.println("Serveur Crash.");
		}
	}

	// Méthodes :
	public void UpdatePlayer(int Identifiants){}
	public void StartServer(){
        for(int i = 0; i < 2; i++){
            try{
                this.getPlayersConnection()[i] = this.getServerSocket().accept();
                System.out.print("valider");
            }catch(IOException e){
                System.err.println("Erreur client refusé.");
            }
        }
    }

	// Getters :
	public int getTailleX(){
		return this.TailleX;
	}
	public int getTailleY(){
		return this.TailleY;
	}
	public model.Entity[][] getEntity(){
		return this.Entity;
	}
	public Avions[] getPlayers(){
		return this.Players;
	}
	public Observable getObservable(){
		return this;
	}
    public Socket[] getPlayersConnection(){
        return this.PlayersConnection;
    }
    public java.net.ServerSocket getServerSocket(){
        return this.ServerSocket;
    }

    // Setters :
	private void setTailleX(int TailleX){
		this.TailleX = TailleX;
	}
	private void setTailleY(int TailleY){
		this.TailleY = TailleY;
	}
	private void setEntity(model.Entity[][] Entity){
		this.Entity = Entity;
	}
	private void setPlayers(Avions[] Players){
		this.Players = Players;
	}
    private void setPlayersConnection(Socket[] PlayersConnection){
        this.PlayersConnection = PlayersConnection;
    }
    private void setServerSocket(java.net.ServerSocket ServerSocket){
        this.ServerSocket = ServerSocket;
    }
}
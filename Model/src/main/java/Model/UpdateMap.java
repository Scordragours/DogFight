package Model;

public class UpdateMap extends Thread{
    // Attributs :
    private Model Model;

    // Constructeur :
    public UpdateMap(Model Model){
        this.setModel(Model);
    }

    // Méthodes
    public void run(){
        while(this.getModel().isPartieFini()){
            try{
                Thread.sleep(150);
                this.getModel().UpdateMap();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    // Getter :
    public Model getModel(){
        return this.Model;
    }

    // Setter :
    public void setModel(Model Model){
        this.Model = Model;
    }
}
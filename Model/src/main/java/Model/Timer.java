package Model;

public class Timer extends Thread{
    // Attributs :
    private Model Model;
    private long TimeSecond = 120;

    // Constructeur :
    public Timer(Model Model){
        this.setModel(Model);
    }

    // Méthodes
    public void run(){
        for(int i = 0; i <= this.getTimeSecond(); i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(i);
        }
        this.getModel().setPartieFini(true);
    }

    // Getter :
    public Model getModel(){
        return this.Model;
    }
    private long getTimeSecond(){
        return this.TimeSecond;
    }

    // Setter :
    public void setModel(Model Model){
        this.Model = Model;
    }
}
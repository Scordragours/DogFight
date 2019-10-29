package Controller;

import View.IViewSystem;

public class DogFightController implements IOrderPerformer{
    // Atributs :
    private static final int  TIME_SLEEP = 30;
    private IViewSystem ViewSystem;

    // Contructor :
    public DogFightController(){

    }

    // Methodes :
    public void OrderPerform(UserOrder UserOrder){

    }
    public void Play(){

    }
    private void LaunchMissile(int Player){

    }
    private void GameLoop(){

    }

    // Getter :
    public static int getTimeSleep(){
        return TIME_SLEEP;
    }
    public IViewSystem getViewSystem(){
        return this.ViewSystem;
    }

    // Setter :
    public void setViewSystem(IViewSystem ViewSystem){
        this.ViewSystem = ViewSystem;
    }
}
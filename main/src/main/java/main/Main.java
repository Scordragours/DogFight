package main;

import Model.*;

public class Main{
    public static void main(String args[]){
        Model Model = new Model(25, 25);
        Timer Timer = new Timer(Model);
        UpdateMap UpdateMap = new UpdateMap(Model);
        UpdateMap.start();
        Model.setTimer(Timer);
        Model.StartServer();

    }
}
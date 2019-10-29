package Controller;

public class UserOrder implements IUserOrder{
    // Attributs
    private int Player;
    private Order Order;

    // Getters :
    public int getPlayer(){
        return this.Player;
    }
    public Order getOrder(){
        return this.Order;
    }

    // Setters :
    private void setPlayer(int Player){
        this.Player = Player;
    }
    private void setOrder(Order Order){
        this.Order = Order;
    }
}
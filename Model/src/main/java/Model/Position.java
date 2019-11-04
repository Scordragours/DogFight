package Model;

public class Position{
    // Atributs
    private int X, Y;

    // Constructeur :
    public Position(){
        this.setX(0);
        this.setY(0);
    }
    public Position(int[] Position){
        this.setX(Position[0]);
        this.setY(Position[1]);
    }
    public Position(Position Position){
        this.setX(Position.getX());
        this.setY(Position.getY());
    }
    public Position(int X, int Y){
        this.setX(X);
        this.setY(Y);
    }

    // Getter :
    public int getX(){
        return this.X;
    }
    public int getY(){
        return this.Y;
    }

    // Setter :
    protected void setX(int X){
        this.X = X;
    }
    protected void setY(int Y){
        this.Y = Y;
    }
}
package Model;

public class Position{
    // Atributs
    private double X, Y;

    // Constructeur :
    public Position(){
        this.setX(0);
        this.setY(0);
    }
    public Position(double[] Position){
        this.setX(Position[0]);
        this.setY(Position[1]);
    }
    public Position(double X, double Y){
        this.setX(X);
        this.setY(Y);
    }

    // Getter :
    public double getX(){
        return this.X;
    }
    public double getY(){
        return this.Y;
    }

    // Setter :
    public void setX(double X){
        this.X = X;
    }
    public void setY(double Y){
        this.Y = Y;
    }
}
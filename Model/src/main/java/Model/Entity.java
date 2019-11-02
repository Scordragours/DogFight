package Model;

public abstract class Entity{
    // Attributs :
    private Position Position;

    // Constructeur :
    public Entity(){

    }
    public Entity(Entity Entity){
        this.setPosition(new Position(Entity.getPosition()));
    }
    public Entity(double X, double Y){
        this.setPosition(new Position(X, Y));
    }

    // Getter :
    public Position getPosition(){
        return this.Position;
    }

    // Setter :
    public void setPosition(Position Position){
        this.Position = Position;
    }
}
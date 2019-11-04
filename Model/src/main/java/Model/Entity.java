package Model;

public abstract class Entity{
    // Attributs :
    private Position Position;
    private StateMap StateMap;
    private boolean Deplacer = false;

    // Constructeur :
    public Entity(){
        this.setPosition(new Position(0, 0));
        this.setStateMap(StateMap.Vide);
    }
    public Entity(Entity Entity){
        this.setPosition(new Position(Entity.getPosition()));
    }
    public Entity(int X, int Y){
        this.setPosition(new Position(X, Y));
    }

    // Getter :
    public Position getPosition(){
        return this.Position;
    }
    public StateMap getStateMap(){
        return this.StateMap;
    }
    public boolean isDeplacer(){
        return this.Deplacer;
    }

    // Setter :
    public void setPosition(Position Position){
        this.Position = Position;
    }
    public void setStateMap(StateMap StateMap){
        this.StateMap = StateMap;
    }
    public void setDeplacer(boolean Deplacer){
        this.Deplacer = Deplacer;
    }
}
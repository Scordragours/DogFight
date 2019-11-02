package Model;

public class Missiles extends Entity{
    // Attributs :
    private Equipe Equipe;
    private Direction Direction;

    // Constructeur :
    public Missiles(){
        super(0, 0);
        this.setStateMap(StateMap.Missiles);
        this.setEquipe(Equipe.France);
        this.setDirection(Direction.LEFT);
    }
    public Missiles(Direction Direction, Equipe Equipe, double X, double Y){
        super(X, Y);
        this.setStateMap(StateMap.Missiles);
        this.setDirection(Direction);
        this.setEquipe(Equipe);
    }

    // Méthodes :
    public void Deplacer(){
        switch(this.getDirection()){
            case LEFT:
                this.getPosition().setX(this.getPosition().getX() - 1);
                break;
            case RIGHT:
                this.getPosition().setX(this.getPosition().getX() + 1);
                break;
            case UP:
                this.getPosition().setY(this.getPosition().getY() - 1);
                break;
            case DOWN:
                this.getPosition().setY(this.getPosition().getY() + 1);
                break;
        }
    }

    // Getter :
    public Equipe getEquipe(){
        return this.Equipe;
    }
    public Direction getDirection(){
        return this.Direction;
    }

    // Setter :
    public void setEquipe(Equipe Equipe){
        this.Equipe = Equipe;
    }
    public void setDirection(Direction Direction){
        this.Direction = Direction;
    }
}
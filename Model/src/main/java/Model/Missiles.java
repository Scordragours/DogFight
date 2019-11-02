package Model;

public class Missiles extends Entity{
    // Attributs :
    private Equipe Equipe;
    private Direction Direction;

    // Constructeur :
    public Missiles(){
        super(0, 0);
        this.setEquipe(Equipe.France);
        this.setDirection(Direction.LEFT);
    }
    public Missiles(Direction Direction, Equipe Equipe, double X, double Y){
        super(X, Y);
        this.setDirection(Direction);
        this.setEquipe(Equipe);
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
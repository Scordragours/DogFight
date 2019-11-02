package Model;

class Avions extends Entity{
    // Attributs :
    private Equipe Equipe;
    private int Score;
    private State State;
    private Direction Direction;
    private long TempsReappear;
    private String Pseudo;

    // Constructeur :
    public Avions(Equipe Equipe, String Pseudo, double X, double Y){
        super(X, Y);
        this.setEquipe(Equipe);
        this.setScore(0);
        this.setState(State.Life);
        this.setDirection(Direction.LEFT);
        this.setTempsReappear(0);
        this.setPseudo(Pseudo);
    }
    public Avions(){
        super(0, 0);
        this.setEquipe(Equipe.France);
        this.setScore(0);
        this.setState(State.Life);
        this.setDirection(Direction.LEFT);
        this.setTempsReappear(0);
        this.setPseudo("none");
    }

    // Getter :
    public Equipe getEquipe(){
        return this.Equipe;
    }
    public int getScore(){
        return this.Score;
    }
    public State getState(){
        return this.State;
    }
    public Direction getDirection(){
        return this.Direction;
    }
    public long getTempsReappear(){
        return this.TempsReappear;
    }
    public String getPseudo(){
        return this.Pseudo;
    }

    // Setter :
    public void setEquipe(Equipe Equipe){
        this.Equipe = Equipe;
    }
    public void setScore(int Score){
        this.Score = Score;
    }
    public void setState(State State){
        this.State = State;
    }
    public void setDirection(Direction Direction){
        this.Direction = Direction;
    }
    public void setTempsReappear(long TempsReappear){
        this.TempsReappear = TempsReappear;
    }
    public void setPseudo(String Pseudo){
        this.Pseudo = Pseudo;
    }
}
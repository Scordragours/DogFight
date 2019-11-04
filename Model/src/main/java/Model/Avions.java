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
    public Avions(Equipe Equipe, String Pseudo, int X, int Y){
        super(X, Y);
        this.setStateMap(StateMap.Avions);
        this.setEquipe(Equipe);
        this.setScore(0);
        this.setState(State.Life);
        this.setDirection(Direction.LEFT);
        this.setTempsReappear(0);
        this.setPseudo(Pseudo);
    }
    public Avions(){
        super(0, 0);
        this.setStateMap(StateMap.Avions);
        this.setEquipe(Equipe.France);
        this.setScore(0);
        this.setState(State.Life);
        this.setDirection(Direction.LEFT);
        this.setTempsReappear(0);
        this.setPseudo("none");
    }
    public Avions(Avions Player){
        this.setTempsReappear(Player.getTempsReappear());
        this.setState(Player.getState());
        this.setPosition(Player.getPosition());
        this.setScore(Player.getScore());
        this.setStateMap(Player.getStateMap());
        this.setPseudo(Player.getPseudo());
        this.setEquipe(Player.getEquipe());
        this.setDirection(Player.getDirection());
    }

    // Méthodes :
    public void Deplacer(){
        if(this.getState() == State.Life){
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
        this.setDeplacer(true);
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
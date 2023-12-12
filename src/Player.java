public class Player {

    public String name;
    public Die die;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setDie(Die die){
        this.die = die;
    }
    public Die getDie(){
        return die;
    }
    public Player(String name, Die die){
        this.name = name;
        this.die = die;
    }
}

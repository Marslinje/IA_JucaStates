package characters.juca;
import characters.Character;
import core.*;

public class Juca implements Character {
    private int hunger = 0;
    private int fatigue = 0;
    private boolean alive = true;

    private State<Juca> state = new Work(this);

    @Override
    public void printStats(String state){
        System.out.println("JUCA");
        System.out.println(state);
        System.out.println("Fome: " + hunger);
        System.out.println("Fadiga: " + fatigue);
    }

    @Override
    public void setState(State newState){
        this.state.exit();
        this.state = newState;
        state.enter();
    }

    @Override
    public void update() {
        checkHeart();
        state.update();
    }

    void checkHeart(){
        double chance = 0.01; // heart attack chance

        if (Math.random() < chance) {
            setState(new Attack(this));
        }
    }

    //getter setter
    public boolean isAlive() { return alive; }
    public void setAlive(boolean alive) { this.alive = alive; }
    public int getHunger() { return hunger; }
    public void setHunger(int hunger) { this.hunger = hunger; }
    public int getFatigue() { return fatigue; }
    public void setFatigue(int fatigue) { this.fatigue = fatigue; }
}

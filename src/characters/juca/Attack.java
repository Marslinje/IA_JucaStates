package characters.juca;

import core.AbstractState;

public class Attack extends AbstractState<Juca> {
    int survivedTimes;

    public Attack(Juca juca){
        super(juca);
    }

    @Override
    public void enter(){
        System.out.println(", que isso?");
    }

    @Override
    public void update(){
        double chance = 0.05; //death chance
        if (Math.random() < chance) { // 1.0 ~ 0.0 < chance
            getCharacter().setAlive(false);
            System.out.println("[Juca teve um ataque cardiaco e morreu]");
            System.out.println("[Juca sobreviveu a " + survivedTimes + " ataque(s) cardiaco(s)]");
            return;
        }

        survivedTimes ++;
        if (getCharacter().getFatigue() >= 50) getCharacter().setState(new Sleep(getCharacter()));
        else if (getCharacter().getHunger() >= 10) getCharacter().setState(new Eat(getCharacter()));
        else getCharacter().setState(new Work(getCharacter()));
    }

    @Override
    public void exit(){
        if (getCharacter().isAlive()) {
            System.out.println("[Juca sobreviveu a " + survivedTimes + " ataque(s) cardiaco(s)!]");
            System.out.print("deve ser refluxo");
        }
    }
}

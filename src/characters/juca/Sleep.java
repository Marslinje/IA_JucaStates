package characters.juca;

import core.AbstractState;

public class Sleep extends AbstractState<Juca> {

    public Sleep(Juca juca) {
        super(juca);
    }

    @Override
    public void enter() {
        if (getCharacter().getFatigue() < 50)
            System.out.println(", que sono...");
        else System.out.println(", hora de dormir...");
    }

    @Override
    public void update() {
        getCharacter().printStats("[Dormindo]");
        getCharacter().setFatigue(getCharacter().getFatigue() - 10);
        getCharacter().setHunger(getCharacter().getHunger() + 1);

        if (getCharacter().getFatigue() <= 0) {
            getCharacter().setFatigue(0);
            if (getCharacter().getHunger() <= 10)
                getCharacter().setState(new Work(getCharacter()));
            else if (getCharacter().getHunger() >= 10){
                getCharacter().setState(new Eat(getCharacter()));
            }
        }
    }

    @Override
    public void exit(){
        if (getCharacter().getFatigue() <= 0)
            System.out.print("mais um dia");
        else System.out.print("Ahh");

    }
}

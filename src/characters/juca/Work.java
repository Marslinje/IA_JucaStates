package characters.juca;

import core.AbstractState;

public class Work extends AbstractState<Juca> {

    public Work(Juca juca) {
        super(juca);
    }

    @Override
    public void enter() {
        System.out.println(", de volta ao trabalho ");
    }

    @Override
    public void update() {

        getCharacter().printStats("[Trabalhando]");
        getCharacter().setHunger(getCharacter().getHunger() + 2);
        getCharacter().setFatigue(getCharacter().getFatigue() + 5);

        if (getCharacter().getFatigue() >= 50) {
            getCharacter().setState(new Sleep(getCharacter()));
        }
        else if (getCharacter().getHunger() >= 10) {
            getCharacter().setState(new Eat(getCharacter()));
        }
    }

    @Override
    public void exit(){
        if (getCharacter().getFatigue() >= 50)
            System.out.print("deu por hoje");
        else if (getCharacter().getHunger() >= 10)
            System.out.print("hora do lanche");
        else System.out.print("vish");
    }
}

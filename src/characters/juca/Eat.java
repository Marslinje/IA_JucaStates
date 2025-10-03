package characters.juca;

import core.AbstractState;

public class Eat extends AbstractState<Juca> {

    public Eat(Juca juca) {
        super(juca);
    }

    @Override
    public void enter(){
        if (getCharacter().getHunger() < 10)
            System.out.println(", deixa eu voltar a comer");
        else if (getCharacter().getHunger() > 10) System.out.println(", to morrendo de fome");
        else System.out.println(", mas que fome... ");
    }

    @Override
    public void update(){
        getCharacter().printStats("[Comendo]");
        getCharacter().setHunger(getCharacter().getHunger() - 5);
        if (getCharacter().getHunger() < 0) getCharacter().setHunger(0);

        if (getCharacter().getHunger() <= 0) {
            getCharacter().setHunger(0);
            getCharacter().setState(new Work(getCharacter()));
        }
    }

    @Override
    public void exit(){
        if (getCharacter().getHunger() <= 0)
            System.out.print("já estou cheio");
        else System.out.print("vish ");
    }
}

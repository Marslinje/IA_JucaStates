package characters.bob;

import core.AbstractState;

public class Clean extends AbstractState<Bob> {
    public Clean(Bob bob) {
        super(bob);
    }

    @Override
    public void enter() {

    }

    @Override
    public void update() {
        if (getCharacter().getTimer() < 360) getCharacter().setState(new Sleep(getCharacter())); // antes das 6h
        else if (getCharacter().getTimer() >= 480 && getCharacter().getTimer() < 510) getCharacter().setState(new Cook(getCharacter())); // 8h café da manhã
        else if (getCharacter().getTimer() >= 690 && getCharacter().getTimer() < 720) getCharacter().setState(new Cook(getCharacter())); // 12h almoço
        else if (getCharacter().getTimer() >= 1080 && getCharacter().getTimer() < 1100) getCharacter().setState(new Cook(getCharacter())); // 18h janta
        else if (getCharacter().getTimer() >= 1320 ) getCharacter().setState(new Sleep(getCharacter())); // 22h hora de dormir
        getCharacter().printStats("[Limpando]");
    }

    @Override
    public void exit() {

    }

}

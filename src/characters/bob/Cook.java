package characters.bob;

import core.AbstractState;

public class Cook extends AbstractState<Bob> {

    public Cook(Bob bob) {
        super(bob);
    }

    @Override
    public void enter() {

    }

    @Override
    public void update() {
        if (getCharacter().getTimer() > 510 && getCharacter().getTimer() < 690) getCharacter().setState(new Clean(getCharacter()));
        else if (getCharacter().getTimer() > 720 && getCharacter().getTimer() < 1080) getCharacter().setState(new Clean(getCharacter())); // 12h almoço
        else if (getCharacter().getTimer() > 1010) getCharacter().setState(new Clean(getCharacter())); // 18h janta
        getCharacter().printStats("[Cozinhando]");

    }

    @Override
    public void exit() {

    }
}

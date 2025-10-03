package characters.bob;

import core.AbstractState;

public class Sleep extends AbstractState<Bob> {

    public Sleep(Bob bob) {
        super(bob);
    }

    @Override
    public void enter() {

    }

    @Override
    public void update() {
        if (getCharacter().getTimer() >= 360) getCharacter().setState(new Clean(getCharacter())); //6h acordar
        getCharacter().printStats("[Dormindo]");
    }

    @Override
    public void exit() {

    }
}

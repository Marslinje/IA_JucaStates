package core;

public abstract class AbstractState<C> implements State<C> {
    protected C character;

    public AbstractState(C character){
        this.character = character;
    }

    public C getCharacter(){
        return this.character;
    }

    @Override
    public void enter(){

    }

    @Override
    public void exit(){

    }
}

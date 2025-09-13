public abstract class JucaAbstractState implements State {
    protected final JucaStateMachine juca;

    public JucaAbstractState(JucaStateMachine juca){
        this.juca = juca;
    }

    @Override
    public void enter(){

    }

    @Override
    public void exit(){

    }

    public void update() {

    }
}

package core;

public interface State<C> {
    C getCharacter();
    void enter();
    void update();
    void exit();

}

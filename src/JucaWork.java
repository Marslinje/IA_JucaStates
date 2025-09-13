public class JucaWork extends JucaAbstractState {

    public JucaWork(JucaStateMachine juca) {
        super(juca);
    }

    @Override
    public void enter() {
        System.out.println(", de volta ao trabalho ");
    }

    @Override
    public void update() {
        System.out.println("[Trabalhando]");
        juca.setHunger(juca.getHunger() + 2);
        juca.setFatigue(juca.getFatigue() + 5);
        juca.displayInfo();

        if (juca.getFatigue() >= 50) {
            juca.switchState(juca.sleepState);
        }
        else if (juca.getHunger() >= 10) {
            juca.switchState(juca.eatState);
        }
    }

    @Override
    public void exit(){
        if (juca.getFatigue() >= 50)
            System.out.print("deu por hoje");
        else if (juca.getHunger() >= 10)
            System.out.print("hora do lanche");
        else System.out.print("vish");
    }
}

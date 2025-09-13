public class JucaEat extends JucaAbstractState {

    public JucaEat(JucaStateMachine juca) {
        super(juca);
    }

    @Override
    public void enter(){
        System.out.println(", mas que fome... ");
    }

    @Override
    public void update(){
        System.out.println("[Intervalo]");
        juca.setHunger(juca.getHunger() - 5);
        juca.displayInfo();

        if (juca.getHunger() <= 0) {
            juca.setHunger(0);
            juca.switchState(new JucaWork(juca));
        }
    }

    @Override
    public void exit(){
        if (juca.getHunger() <= 0)
            System.out.print("já estou cheio");
        else System.out.print("vish ");
    }
}

public class JucaEat extends JucaAbstractState {

    public JucaEat(JucaStateMachine juca) {
        super(juca);
    }

    @Override
    public void enter(){
        if (juca.getHunger() < 10)
            System.out.println(", deixa eu voltar a comer");
        else if (juca.getHunger() > 10) System.out.println(", to morrendo de fome");
        else System.out.println(", mas que fome... ");
    }

    @Override
    public void update(){
        System.out.println("[Intervalo]");
        juca.setHunger(juca.getHunger() - 5);
        if (juca.getHunger() < 0) juca.setHunger(0);
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

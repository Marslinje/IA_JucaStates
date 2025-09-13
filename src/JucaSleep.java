public class JucaSleep extends JucaAbstractState {

    public JucaSleep(JucaStateMachine juca) {
        super(juca);
    }

    @Override
    public void enter() {
        if (juca.getFatigue() < 50)
            System.out.println(", que sono...");
        else System.out.println(", hora de dormir...");
    }

    @Override
    public void update() {
        System.out.println("[Dormindo]");
        juca.setFatigue(juca.getFatigue() - 10);
        juca.setHunger(juca.getHunger() + 1);
        juca.displayInfo();

        if (juca.getFatigue() <= 0) {
            juca.setFatigue(0);
            if (juca.getHunger() <= 10)
                juca.switchState(new JucaWork(juca));
            else if (juca.getHunger() >= 10){
                juca.switchState(juca.eatState);
            }
        }
    }

    @Override
    public void exit(){
        if (juca.getFatigue() <= 0)
            System.out.print("mais um dia");
        else System.out.print("Ahh");

    }
}

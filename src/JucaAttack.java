public class JucaAttack extends JucaAbstractState{

    public JucaAttack(JucaStateMachine juca){
        super(juca);
    }

    @Override
    public void enter(){
        System.out.println(", que isso?");
    }

    @Override
    public void update(){
        double chance = 0.2; //death chance
        if (Math.random() < chance) { // 1.0 ~ 0.0 < chance
            juca.setAlive(false);
            System.out.println("[Juca teve um ataque cardiaco e morreu]");
            return;
        }

        if (juca.getFatigue() >= 50) juca.switchState(juca.sleepState);
        else if (juca.getHunger() >= 10) juca.switchState(juca.eatState);
        else juca.switchState(juca.workState);
    }

    @Override
    public void exit(){
        if (juca.isAlive()) {
            juca.delay(2000);
            System.out.println("[Juca sobreviveu um ataque cardiaco!]");
            System.out.print("deve ser refluxo");
        }
    }
}

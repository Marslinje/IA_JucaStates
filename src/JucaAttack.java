public class JucaAttack extends JucaAbstractState{
    int survivedTimes;

    public JucaAttack(JucaStateMachine juca){
        super(juca);
    }

    @Override
    public void enter(){
        System.out.println(", que isso?");
    }

    @Override
    public void update(){
        double chance = 0.05; //death chance
        if (Math.random() < chance) { // 1.0 ~ 0.0 < chance
            juca.setAlive(false);
            juca.displayInfo();
            System.out.println("[Juca teve um ataque cardiaco e morreu]");
            System.out.println("[Juca sobreviveu a " + survivedTimes + " ataque(s) cardiaco(s)]");
            return;
        }

        survivedTimes ++;
        if (juca.getFatigue() >= 50) juca.switchState(juca.sleepState);
        else if (juca.getHunger() >= 10) juca.switchState(juca.eatState);
        else juca.switchState(juca.workState);
    }

    @Override
    public void exit(){
        if (juca.isAlive()) {
            System.out.println("[Juca sobreviveu a " + survivedTimes + " ataque(s) cardiaco(s)!]");
            System.out.print("deve ser refluxo");
            juca.delay(2000);
        }
    }
}

public class JucaStateMachine {
    private State currentState;

    public JucaWork workState;
    public JucaSleep sleepState;
    public JucaEat eatState;
    public JucaAttack attackState;

    private int hunger = 0;
    private int fatigue = 0;
    private boolean alive = true;

    private Object juca;

    public JucaStateMachine(){
        workState = new JucaWork(this);
        sleepState = new JucaSleep(this);
        eatState = new JucaEat(this);
        attackState = new JucaAttack(this);

        currentState = workState;
    }

    public void switchState(State newState){
        if (currentState != null) currentState.exit(); //leave current state
        currentState = newState; //assign new state
        if (currentState != null) currentState.enter(); //enter current state
        delay(2000);
    }

    public void update() {
        if (currentState != null) currentState.update();
        checkHeart();
        delay(700);
    }

    void checkHeart(){
        double chance = 0.1; // heart attack chance

        if (Math.random() < chance) {
            switchState(attackState);
        }
    }

    static void delay(int time){
        try {
            Thread.sleep(time); // 3000 milliseconds = 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void displayInfo(){
        System.out.println("Fome: " + hunger + " | Fadiga: " + fatigue);
    }

    //getter setter
    public boolean isAlive() { return alive; }
    public void setAlive(boolean alive) { this.alive = alive; }
    public int getHunger() { return hunger; }
    public void setHunger(int hunger) { this.hunger = hunger; }
    public int getFatigue() { return fatigue; }
    public void setFatigue(int fatigue) { this.fatigue = fatigue; }
}

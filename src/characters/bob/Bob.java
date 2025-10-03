package characters.bob;

import characters.Character;
import core.*;

public class Bob implements Character {
    private int timer = 0; //em minutos

    private State<Bob> state = new Sleep(this);

    @Override
    public void setState(State newState) {
        this.state.exit();
        this.state = newState;
        state.enter();
    }

    @Override
    public void printStats(String stats) {
        System.out.println("BOB");
        System.out.println(stats);
        System.out.print("Horas: ");
        System.out.printf("%d:%02d", timer / 60, timer % 60);
        System.out.println();
    }

    @Override
    public void update() {
        timer += 30;
        if (timer >= 1440) timer = 0;
        state.update();
    }

    public int getTimer() {
        return timer;
    }
    public int setTimer(int time) {
        return this.timer = time;
    }
}

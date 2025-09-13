//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JucaStateMachine juca = new JucaStateMachine();

        while (juca.isAlive()) {
            for (int i = 0; i < 40; i++) System.out.println();
            juca.update();
        }
    }
}
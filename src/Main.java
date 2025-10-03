import characters.Character;
import characters.juca.Juca;
import characters.bob.Bob;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();

        characters.add(new Juca());
        characters.add(new Bob());

        while(true) {
            for (Character person : characters) {
                person.update();
                delay();
                System.out.println();
            }
        }
    }

    static void delay(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
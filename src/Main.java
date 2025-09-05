//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        float hunger = 0;
        float fatigue = 0;
        String state = "work";
        float hours = 0;

        boolean alive = true;

        while (alive){
            Message(hunger, fatigue, hours);
            switch(state) {
                case "sleep":
                    System.out.println("~Dormindo");
                    fatigue -= 10;
                    hunger += 1;
                    if (fatigue <= 0){
                        fatigue = 0;
                        if (hunger <= 10)
                            state = "work";
                        else if (hunger > 10)
                            System.out.println("bateu a fome..");
                            state = "eat";
                    }
                    break;
                case "eat":
                    System.out.println("~Comendo");
                    hunger -= 5;
                    if (hunger <= 0) {
                        hunger = 0;
                        state = "work";
                        System.out.println("Ufa! Já estou cheio..");
                    }
                    break;
                default:
                    System.out.println("~Trabalhando");
                    hunger += 2;
                    fatigue += 5;
                    if (fatigue >= 50) {
                        System.out.println("bateu um sono..");
                        state = "sleep";
                    }
                    else if (hunger >= 10) {
                        System.out.println("bateu a fome..");
                        state = "eat";
                    }
                    break;
            }
            Delay();
        }



    }
    static void Message(float hunger, float fatigue, float hours){
        System.out.println("fome: " + hunger);
        System.out.println("fadiga: " + fatigue);
        System.out.println("");
    }
    static void Delay(){
        try {
            Thread.sleep(2000); // 3000 milliseconds = 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
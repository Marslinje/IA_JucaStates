package characters;
import core.State;

public interface Character {
    void update();

    void setState(State newState);

    void printStats(String stats);
}

import java.awt.*;

// A class to simulate the behavior of animal type giant
public class Giant extends Critter {
    private int stepCounter, stepRestart;

    public Giant(){
        this.stepCounter = 0;
        this.stepRestart = 24;
    }

    // Increase stepCounter by 1 on every move.
    // If stepCounter reaches stepRestart (24), reset field stepCounter back to 0.
    // Return Action.INFECT on front threat, Action.HOP if getFront() == Neighbor.EMPTY.
    // Return Action.RIGHT otherwise.
    public Action getMove(CritterInfo info) {
        this.stepCounter++;
        if(this.stepCounter >= this.stepRestart) this.stepCounter = 0;

        if (info.frontThreat()) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY)
            return Action.HOP;
        else
            return Action.RIGHT;
    }

    // Always return Color.GREY
    public Color getColor() {
        return Color.GRAY;
    }

    // Return name “fee” if stepCounter < 6, “fie” if between 6-11
    // “foe” if between 12-17, “fum” if between 18-23
    public String toString() {
        String name;

        if(this.stepCounter<6)
            name = "fee";
        else if(this.stepCounter<12)
            name = "fie";
        else if(this.stepCounter<18)
            name = "foe";
        else
            name = "fum";

        return name;
    }
}
import java.awt.*;

public class Giant extends Critter {
    private int stepCounter, stepRestart;

    public Giant(){
        this.stepCounter = 0;
        this.stepRestart = 24;
    }

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

    public Color getColor() {
        return Color.GRAY;
    }

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
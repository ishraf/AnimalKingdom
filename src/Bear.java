import java.awt.*;

// A class to simulate the behavior of animal type bear
public class Bear extends Critter {
    private boolean polar;
    private String name;

    public Bear(boolean polar){
        this.polar = polar;
        this.name = "/";
    }

    // Set name to alternate value of front slash & back slash on every move.
    // Return Action.INFECT on front threat, Action.HOP if getFront() == Neighbor.EMPTY.
    // Return Action.LEFT otherwise.
    public Action getMove(CritterInfo info) {
        if(this.name.equals("/"))
            this.name = "\\";
        else
            this.name = "/";

        if (info.frontThreat()) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }
        else
            return Action.LEFT;
    }

    // If field polar == true, return Color.WHITE, else return Color.BLACK.
    public Color getColor() {
        if(this.polar)
            return Color.WHITE;
        else
            return Color.BLACK;
    }

    // Return this animal name
    public String toString() {
        return this.name;
    }
}
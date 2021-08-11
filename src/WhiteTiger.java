import java.awt.*;

// A class to simulate the behavior of animal type white tiger
public class WhiteTiger extends Critter {
    private String name;

    public WhiteTiger(){
        this.name = "tgr";
    }

    // If frontThreat() is true, set name to “TGR” and return Action.INFECT
    // Else if getFront() == WALL or getRight() == WALL, return Action.LEFT
    // Else if getFront() == SAME, return Action.RIGHT
    // Else return Action.HOP
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            this.name = "TGR";
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        } else if(info.getFront() == Neighbor.SAME)
            return Action.RIGHT;
        else
            return Action.HOP;
    }

    // Return animal color - always WHITE
    public Color getColor() {
        return Color.WHITE;
    }

    // Return this animal name
    public String toString() {
        return this.name;
    }
}
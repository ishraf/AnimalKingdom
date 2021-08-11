import java.awt.*;

// A class to simulate the behavior of animal type ninja cat
public class NinjaCat extends Critter {
    private Color color;
    private String name;

    public NinjaCat(){
        this.color = Color.BLACK;
        this.name = "X";
    }

    // If frontThreat() is true, return Action.INFECT
    // Else if getFront() returns SAME, set color to black and return Action.RIGHT
    // Else if getFront() returns WALL, set color to magenta and returns Action.LEFT
    // Else return Action.HOP
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.SAME) {
            this.color = Color.BLACK;
            return Action.RIGHT;
        } else if(info.getFront() == Neighbor.WALL ){
            this.color = Color.MAGENTA;
            return Action.LEFT;
        } else {
            return Action.HOP;
        }
    }

    // Return this animal color
    public Color getColor() {
        return this.color;
    }

    // Return this animal name
    public String toString() {
        return this.name;
    }
}
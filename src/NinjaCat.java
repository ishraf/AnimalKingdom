import java.awt.*;

public class NinjaCat extends Critter {
    private Color color;
    private String name;

    public NinjaCat(){
        this.color = Color.BLACK;
        this.name = "X";
    }

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

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return this.name;
    }
}
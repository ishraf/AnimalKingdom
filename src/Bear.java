import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private String name;

    public Bear(boolean polar){
        this.polar = polar;
        this.name = "/";
    }

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

    public Color getColor() {
        if(this.polar)
            return Color.WHITE;
        else
            return Color.BLACK;
    }

    public String toString() {
        return this.name;
    }
}
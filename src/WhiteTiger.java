import java.awt.*;

public class WhiteTiger extends Critter {
    private String name;

    public WhiteTiger(){
        this.name = "tgr";
    }

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

    public Color getColor() {
        return Color.WHITE;
    }

    public String toString() {
        return this.name;
    }
}
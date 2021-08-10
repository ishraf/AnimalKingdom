import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private int stepCounter, stepChangeColor;
    private Color color;
    private String name;

    public Tiger(){
        this.stepCounter = 0;
        this.stepChangeColor = 3;
        this.color = this.randomColor();
        this.name = "TGR";
    }

    public Action getMove(CritterInfo info) {
        this.stepCounter++;

        if (info.frontThreat()) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        } else if(info.getFront() == Neighbor.SAME)
            return Action.RIGHT;
        else
            return Action.HOP;
    }

    private Color randomColor(){
        Color[] list = {Color.RED, Color.GREEN, Color.BLUE};
        int max = list.length;
        int random = new Random().nextInt(max);
        return list[random];
    }

    public Color getColor() {
        if(this.stepCounter >= this.stepChangeColor){
            this.color = this.randomColor();
            this.stepCounter = 0;
        }

        return this.color;
    }

    public String toString() {
        return this.name;
    }
}
import java.awt.*;
import java.util.Random;

// A class to simulate the behavior of animal type tiger
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

    // Increase field stepCounter on every movement
    // If frontThreat() is true, return Action.INFECT
    // Else if getFront() == WALL or getRight() == WALL, return Action.LEFT
    // Else if getFront() == SAME, return Action.RIGHT
    // Else return Action.HOP
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

    // Get random color between RED, GREEN or BLUE
    private Color randomColor(){
        Color[] list = {Color.RED, Color.GREEN, Color.BLUE};
        int max = list.length;
        int random = new Random().nextInt(max);
        return list[random];
    }

    // If stepCounter >= stepChangeColor, reset color to new random color
    // and reset stepCounter to 0. Return the new color
    public Color getColor() {
        if(this.stepCounter >= this.stepChangeColor){
            this.color = this.randomColor();
            this.stepCounter = 0;
        }

        return this.color;
    }

    // Return this animal name
    public String toString() {
        return this.name;
    }
}
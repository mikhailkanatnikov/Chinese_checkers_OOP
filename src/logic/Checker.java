package logic;

import java.awt.*;

public class Checker {

    int x;
    int y;
    PlayerColor color;

    public Checker(int x, int y, PlayerColor color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public PlayerColor getCheckerColor(){
        return color;
    }

}



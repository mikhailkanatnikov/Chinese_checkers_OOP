package logic;

import java.util.ArrayList;
import java.util.Arrays;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }


    public static ArrayList<Point> specialPoints = new ArrayList<Point>(Arrays.asList(
            new Point(1,0),
            new Point(2,0),
            new Point(0,1),
            new Point(1,1),
            new Point(0,2),
            new Point(0,0),
            new Point(7,5),
            new Point(6,6),
            new Point(7,6),
            new Point(5,7),
            new Point(6,7),
            new Point(7,7)));

}



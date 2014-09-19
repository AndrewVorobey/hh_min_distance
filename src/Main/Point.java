package Main;

import java.util.Comparator;

import static java.lang.Math.sqrt;

/**
 * Created by Андрей on 17.09.2014.
 */
public class Point {
    public int x;
    public int y;

    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }

    public static double dist(Point A, Point B) {
        return sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y) + .0);
    }
}

class compareX implements Comparator<Point> {
    @Override
    public int compare(Point A, Point B) {
        if(A.x < B.x || (A.x == B.x && A.y < B.y))
            return 1;
        else if(A.x == B.x && A.y == B.y)
            return 0;
        else return -1;
    }
}

class compareY implements Comparator<Point> {
    @Override
    public int compare(Point A, Point B) {
        if (A.y < B.y)
            return 1;
        else if (A.y == B.y)
            return 0;
        else
            return -1;
    }
}
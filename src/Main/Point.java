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

    public int compare(Point A, Point B) {
        return (A.x < B.x || A.x == B.x && A.y < B.y) ? 1 : 0;
    }
}

    class compareY implements Comparator<Point> {

    public int compare(Point A, Point B) {
        return (A.y < B.y) ? 1 : 0;
    }
}
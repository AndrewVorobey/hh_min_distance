package Main;

/**
 * Created by Андрей on 17.09.2014.
 */
public class Point {
    public int x;
    public int y;
    public int id;
    private static int count;

    public Point(int _x, int _y){
        x = _x;
        y = _y;
        id = count++;
    }
}

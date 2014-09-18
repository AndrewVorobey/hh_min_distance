
import Main.Point;
import Main.PointsFild;
import junit.framework.TestCase;
import static java.lang.Math.sqrt;

public class Tests extends TestCase {

    public static void testByHH(){//positive testing
        PointsFild fild = new PointsFild();
        fild.addPoint(new Point(10,10));
        fild.addPoint(new Point(20,10));
        fild.addPoint(new Point(20,15));
        assertTrue("Тест из примера завален",fild.findMinDistance() == 5);
    }

    public static void testSamePoints(){
        PointsFild fild = new PointsFild();
        fild.addPoint(new Point(10,10));
        fild.addPoint(new Point(20,10));
        fild.addPoint(new Point(20,15));
        fild.addPoint(new Point(20,10));
        assertTrue("Тест с совпадающими точками завален",fild.findMinDistance() == 0);
    }

    public static void testNotIntegerResult(){
        PointsFild fild = new PointsFild();
        fild.addPoint(new Point(10,10));
        fild.addPoint(new Point(20,20));
        assertTrue("Тест на нецелочисленный результат завален",fild.findMinDistance() == sqrt(200));
    }

    public static void testMerge(){//white box
        PointsFild fild = new PointsFild();
        fild.addPoint(new Point(10,11));
        fild.addPoint(new Point(220,204));
        fild.addPoint(new Point(160,105));
        fild.addPoint(new Point(250,230));
        fild.addPoint(new Point(107,103));
        fild.addPoint(new Point(209,206));
        fild.addPoint(new Point(101,103));
        fild.addPoint(new Point(208,204));
        fild.addPoint(new Point(10,10));
        fild.addPoint(new Point(201,20));
        assertTrue("Тест на слияние пройден завален",fild.findMinDistance() == 1);
    }

}
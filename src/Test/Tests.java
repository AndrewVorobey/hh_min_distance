
import Main.Point;
import Main.PointsFild;
import junit.framework.TestCase;
import static java.lang.Math.sqrt;

public class Tests extends TestCase {

    public static void testByHH(){//positive testing
        PointsFild fild = new PointsFild(3);
        fild.addPoint(new Point(10,10));
        fild.addPoint(new Point(20,10));
        fild.addPoint(new Point(20,15));
        assertTrue("Тест из примера завален",fild.findMinDistance() == 5);
    }

    public static void testSamePoints(){
        PointsFild fild = new PointsFild(4);
        fild.addPoint(new Point(10,10));
        fild.addPoint(new Point(20,10));
        fild.addPoint(new Point(20,15));
        fild.addPoint(new Point(20,10));
        assertTrue("Тест с совпадающими точками завален",fild.findMinDistance() == 0);
    }

    public static void testNotIntegerResult(){
        PointsFild fild = new PointsFild(2);
        fild.addPoint(new Point(10,10));
        fild.addPoint(new Point(20,20));
        assertTrue("Тест на нецелочисленный результат завален",fild.findMinDistance() == sqrt(200));
    }

    public static void testMerge1(){//white box
        PointsFild fild = new PointsFild(5);
        fild.addPoint(new Point(10,11));
        fild.addPoint(new Point(220,204));
        fild.addPoint(new Point(208,204));
        fild.addPoint(new Point(201,20));
        fild.addPoint(new Point(10,10));
        double A= fild.findMinDistance();
        assertTrue("Тест на слияние 1 завален",fild.findMinDistance() == 1);
    }

    public static void testMerge2(){//white box
        PointsFild fild = new PointsFild(10);
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
        assertTrue("Тест на слияние 2 завален",fild.findMinDistance() == 1);
    }

    public static void testBorder(){//white box
        PointsFild fild = new PointsFild(7);
          fild.addPoint(new Point(43,15));
          fild.addPoint(new Point(43,611));
          fild.addPoint(new Point(43,513));
          fild.addPoint(new Point(47,316));
          fild.addPoint(new Point(47,15));
          fild.addPoint(new Point(47,217));
          fild.addPoint(new Point(47,119));
         assertTrue("Тест на граничные условия сортировок 2 завален",fild.findMinDistance() == 4);
    }

}
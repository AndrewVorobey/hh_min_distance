package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Андрей on 17.09.2014.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PointsFild pointsFild = new PointsFild();
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++) {
            String a = inputStream.readLine();
            String[] StringPint = a.split(" ");
            pointsFild.addPoint(new Point(Integer.parseInt(StringPint[0]), Integer.parseInt(StringPint[1])));
        }

        System.out.print(pointsFild.findMinDistance());
    }
}

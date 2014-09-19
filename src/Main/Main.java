package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Андрей on 17.09.2014.
 * Входные данные:
 * N - количество точке.
 * X1 Y1
 * ...
 * XN YN
 * Выходные данные:
 * minDist
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(inputStream.readLine());
        PointsFild pointsFild = new PointsFild(N);
        for (int i = 0; i < N; i++) {
            String inputLine = inputStream.readLine();
            String[] StringPint = inputLine.split(" ");
            pointsFild.addPoint(new Point(Integer.parseInt(StringPint[0]), Integer.parseInt(StringPint[1])));
        }

        System.out.print(pointsFild.findMinDistance());
    }
}

package Main;

import static java.lang.Math.abs;
import static java.util.Arrays.sort;

/**
 * Created by Андрей on 17.09.2014.
 */
public class PointsFild {
    Point[] points;
    int size;

    public PointsFild(int N) {
        points = new Point[N];
        auxiliaryArray = new Point[N];
    }

    public void addPoint(Point A) {
        points[size++] = A;
    }

    public double findMinDistance() {
        minDist = Point.dist(points[0], points[1]);
        sort(points, 0, size - 1, new compareX());
        recursion(0, size - 1);
        return minDist;
    }

    double minDist;
    Point[] auxiliaryArray;

    /*
        Метод поиска кратчайшего расстояния по принципу "разделяй и властвуй"
        O(N*Log(N))
     */
    void recursion(int Begin, int End) {
        if (End - Begin <= 3) {
            findMinDistInShortSubArray(Begin, End);
            return;
        }

        int middle = (Begin + End) >> 1;
        int midx = points[middle].x;
        recursion(Begin, middle);
        recursion(middle + 1, End);
        mergeSort(points,Begin,middle+1,middle+1,End +1, auxiliaryArray, new compareY());
        System.arraycopy(auxiliaryArray, 0, points, Begin, End - Begin);

        int tsz = 0;
        for (int i = Begin; i <= End; ++i)
            if (abs(points[i].x - midx) < minDist) {
                for (int j = tsz - 1; j >= 0 && points[i].y - auxiliaryArray[j].y < minDist; --j)
                    testTheHypothesis(points[i], auxiliaryArray[j]);
                auxiliaryArray[tsz++] = points[i];
            }

    }

    void findMinDistInShortSubArray(int Begin, int End) {
        for (int i = Begin; i <= End; ++i)
            for (int j = i + 1; j <= End; ++j)
                testTheHypothesis(points[i], points[j]);
        sort(points, Begin, End + 1, new compareY());
    }

    void testTheHypothesis(Point a, Point b) {
        double dist = Point.dist(a, b);
        if (dist < minDist) {
            minDist = dist;
        }
    }

    void mergeSort(Point[] from, int begin1, int end1, int begin2, int end2,Point[] to, compareY cmp){
        int i = 0;
        for(;(begin1 < end1 && begin2 < end2); i++){
            if(cmp.compare(from[begin1],from[begin2]) > 0)
                to[i++] = from[begin1++];
            else
                to[i++] = from[begin2++];
        }

        for(;begin1 < end1; i++){
            to[i++] = from[begin1++];
        }

        for(;begin2 < end2; i++){
            to[i++] = from[begin2++];
        }
    }

}

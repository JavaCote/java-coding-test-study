/**
 * PackageName : week16.이상억.backjoon;
 * FileName    : 마라톤_1
 * Author      : sangeok
 * Date        : 2025. 08. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 12.     sangeok               Initial creation
 */



import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    static int dist(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }

        long base = 0;
        for (int i = 1; i < n; i++) {
            base += dist(arr[i - 1], arr[i]);
        }

        // 하나를 건너뛸 때 절약되는 거리 중 최댓값
        long bestSave = 0;
        for (int i = 1; i < n - 1; i++) {
            long save = dist(arr[i - 1], arr[i])
                    + dist(arr[i], arr[i + 1])
                    - dist(arr[i - 1], arr[i + 1]);
            if (save > bestSave) bestSave = save;
        }

        System.out.println(base - bestSave);
    }
}

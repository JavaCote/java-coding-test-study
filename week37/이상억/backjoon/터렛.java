// (1) 같은 원 -1
// (2) 교점이 없음 0
// (3) 원 안에 원 0
// (4) 한 점에서 만남 1
// (5) 두 점에서 만남

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int result = circle_option(x1, y1, r1 , x2, y2, r2);
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }

    public static int circle_option(int x1, int y1, int r1, int x2, int y2, int r2){

        int dx = x1 - x2;
        int dy = y1 - y2;
        int d = dx*dx + dy*dy;

        int sum = r1 + r2;
        int diff = Math.abs(r1 - r2);

        if (d == 0 && r1 == r2) {
            return -1;
        } else if (d > sum*sum) {
            return 0;
        } else if (d < diff*diff) {
            return 0;
        } else if (d == sum*sum || d == diff*diff) {
            return 1;
        } else {
            return 2;
        }
    }
}

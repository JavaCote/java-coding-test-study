import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            lectures[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            events.add(new int[]{lectures[i][0], 1});   // 시작: +1
            events.add(new int[]{lectures[i][1], -1});  // 종료: -1
        }


        events.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int now = 0;
        int maxRoom = 0;

        for (int[] e : events) {
            now += e[1];
            maxRoom = Math.max(maxRoom, now);
        }

        System.out.println(maxRoom);
    }
}

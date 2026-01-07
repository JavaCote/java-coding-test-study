import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] A;
    static boolean[] used;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);
        System.out.println(count);
    }

    static void dfs(int day, int weight) {
        if (weight < 500) return;

        if (day == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(day + 1, weight + A[i] - K);
                used[i] = false;
            }
        }
    }
}

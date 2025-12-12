import java.util.*;
import java.io.*;

public class Main {

    static int k;
    static int[] S;
    static int[] pick = new int[6];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, sb);
            sb.append("\n");  
        }

        System.out.print(sb.toString());
    }

    public static void dfs(int start, int depth, StringBuilder sb) {

        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(pick[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            pick[depth] = S[i];
            dfs(i + 1, depth + 1, sb);
        }
    }
}

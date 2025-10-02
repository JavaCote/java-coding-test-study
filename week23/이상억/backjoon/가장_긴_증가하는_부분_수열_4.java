import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] sequence_array = new int[N];
        int[] dp = new int[N];
        int[] prev = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence_array[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            prev[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence_array[i] > sequence_array[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxlen = 0;
        int last = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] > maxlen) {
                maxlen = dp[i];
                last = i;
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (last != -1) {
            list.addFirst(sequence_array[last]);
            last = prev[last];
        }

        System.out.println(maxlen);
        for (int x : list) System.out.print(x + " ");
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static int[] next;
    static boolean[] visited;
    static boolean[] finished;
    static List<Integer> answer = new ArrayList<>();

    static void dfs(int cur) {
        visited[cur] = true;
        int nxt = next[cur];

        if (!visited[nxt]) {
            dfs(nxt);
        }
        else if (!finished[nxt]) {
            int temp = nxt;
            answer.add(temp);

            while (temp != cur) {
                temp = next[temp];
                answer.add(temp);
            }
        }

        finished[cur] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        next = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            next[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int x : answer) {
            System.out.println(x);
        }
    }
}

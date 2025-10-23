import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 0);

        System.out.println(result % 2 == 1 ? "Yes" : "No");
    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        boolean is_leaf = true;

        for (int next : tree[node]) {
            if (!visited[next]) {
                is_leaf = false;
                dfs(next, depth + 1);
            }
        }

        if (is_leaf) {
            result += depth;
        }
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 일반 시야
        visited = new boolean[N][N];
        int normal = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    normal++;
                }
            }
        }

        // 적록색약
        visited = new boolean[N][N];
        int blind = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    blind++;
                }
            }
        }

        System.out.println(normal + " " + blind);
    }

    static void bfs(int x, int y, boolean colorblind) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        char start = map[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                char next = map[nx][ny];

                if (sameColor(start, next, colorblind)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean sameColor(char a, char b, boolean blind) {
        if (!blind) return a == b;

        if (a == 'B' || b == 'B') return a == b;
        return true;
    }
}

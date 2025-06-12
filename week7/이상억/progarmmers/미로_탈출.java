/**
 * PackageName : week7.이상억.progarmmers;
 * FileName    : 뒤에_있는_큰_수_찾기
 * Author      : sangeok
 * Date        : 2025. 6. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 12.     sangeok               Initial creation
 */

// 회고 :     2차원 평면에 dx, dy 문제를 풀지를 못하겠다. bfs에 대한 이해도가 현저히 떨어지는 것 같다. 추후 다시 해봐야겠다.

import java.util.*;

public class Solution {
    static int n, m;
    static char[][] grid;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        grid = new char[n][m];

        int sr=0, sc=0, lr=0, lc=0, er=0, ec=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = maps[i].charAt(j);
                if (grid[i][j] == 'S') { sr = i; sc = j; }
                else if (grid[i][j] == 'L') { lr = i; lc = j; }
                else if (grid[i][j] == 'E') { er = i; ec = j; }
            }
        }

        int d1 = bfs(sr, sc, 'L');
        if (d1 == -1) return -1;

        int d2 = bfs(lr, lc, 'E');
        if (d2 == -1) return -1;

        return d1 + d2;
    }

    private int bfs(int r0, int c0, char targetChar) {
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        visited[r0][c0] = true;
        dist[r0][c0] = 0;
        q.offer(new int[]{r0, c0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (grid[r][c] == targetChar) {
                return dist[r][c];
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc] || grid[nr][nc] == 'X') continue;

                visited[nr][nc] = true;
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return -1;
    }
}

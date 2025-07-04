/**
 * PackageName : week9.이상억.progarmmers;
 * FileName    : 빛의_경로_사이클
 * Author      : sangeok
 * Date        : 2025. 6. 26.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 26.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    // 방향: 상(0), 우(1), 하(2), 좌(3)
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        int h = grid.length;
        int w = grid[0].length();
        boolean[][][] visited = new boolean[h][w][4];
        List<Integer> result = new ArrayList<>();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                for (int d = 0; d < 4; d++) {
                    if (!visited[y][x][d]) {
                        int cycleLen = tracecycle(grid, y, x, d, visited);
                        result.add(cycleLen);
                    }
                }
            }
        }

        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int tracecycle(String[] grid, int sy, int sx, int sd, boolean[][][] visited) {
        int h = grid.length;
        int w = grid[0].length();
        int y = sy, x = sx, d = sd;
        int count = 0;

        while (true) {
            if (visited[y][x][d]) break;

            visited[y][x][d] = true;
            count++;

            // 이동
            int ny = (y + dy[d] + h) % h;
            int nx = (x + dx[d] + w) % w;

            // 방향 변경
            char cmd = grid[ny].charAt(nx);
            if (cmd == 'L') {
                d = (d + 3) % 4; // 좌회전
            } else if (cmd == 'R') {
                d = (d + 1) % 4; // 우회전
            }
            // 'S'는 그대로

            y = ny;
            x = nx;
        }

        return count;
    }
}

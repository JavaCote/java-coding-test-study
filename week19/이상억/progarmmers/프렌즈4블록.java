/**
 * PackageName : week19.이상억.progarmmers;
 * FileName    : 비밀지도
 * Author      : sangeok
 * Date        : 2025. 09. 04.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 04.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int removedCount = 0;

        while (true) {
            Set<String> toRemove = checkSameBlock(m, n, map);

            if (toRemove.isEmpty()) break;

            removedCount += removeBlock(toRemove, map);

            dropBlock(m, n, map);
        }

        return removedCount;
    }

    // 2x2 같은 블록 찾기
    private Set<String> checkSameBlock(int m, int n, char[][] map) {
        Set<String> toRemove = new HashSet<>();

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = map[i][j];
                if (c != '-' &&
                        c == map[i][j+1] &&
                        c == map[i+1][j] &&
                        c == map[i+1][j+1]) {
                    toRemove.add(i + "," + j);
                    toRemove.add(i + "," + (j+1));
                    toRemove.add((i+1) + "," + j);
                    toRemove.add((i+1) + "," + (j+1));
                }
            }
        }
        return toRemove;
    }

    // 블록 지우기
    private int removeBlock(Set<String> toRemove, char[][] map) {
        for (String pos : toRemove) {
            String[] parts = pos.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            map[x][y] = '-';
        }
        return toRemove.size();
    }

    // 중력 처리
    private void dropBlock(int m, int n, char[][] map) {
        for (int j = 0; j < n; j++) {
            int emptyRow = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j] != '-') {
                    char temp = map[i][j];
                    map[i][j] = '-';
                    map[emptyRow][j] = temp;
                    emptyRow--;
                }
            }
        }
    }
}

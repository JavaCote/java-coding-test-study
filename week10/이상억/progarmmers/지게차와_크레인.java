/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 지게차와_크레인
 * Author      : sangeok
 * Date        : 2025. 07. 03.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 03.     sangeok               Initial creation
 */



//  세로 : n 가로 : m
// 출고 요청이 들어오면 지게차로 창고에서 접근 가능한 해당 종류의 컨테이너를 모두 꺼냄
// 접근 가능한 컨테이너란 4면 중 적어도 1면이 창고 외부와 연결된 컨테이너 => 가장자리에 있는 걸 의미 ?
// 모든 요청을 순서대로 완료 한 후 남은 컨테이너 수를 return
// 두번 반복되는 애들은 크레인 한번은 지게차


// 접근 방식 : request 에서 두글자면 그냥 전체 순회해서 제거
//                          한글자면 bfs 로 외곽에서 접근 가능한 친구들만 제거
import java.util.*;

class Solution {
    public int solution(String[] storageInput, String[] requests) {
        int n = storageInput.length;
        int m = storageInput[0].length();

        // 1) 패딩해서 테두리에 빈 칸('.')을 둘러줌
        int N = n + 2, M = m + 2;
        char[][] storage = new char[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(storage[i], '.');
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                storage[i + 1][j + 1] = storageInput[i].charAt(j);
            }
        }

        // 상하좌우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (String req : requests) {
            char target = req.charAt(0);

            if (req.length() == 2) {
                //  크레인: 모든 target 전부 제거
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (storage[i][j] == target) {
                            storage[i][j] = '.';
                        }
                    }
                }
            } else {
                //  지게차: 빈 칸 BFS → 인접 컨테이너만 제거
                boolean[][] visitedEmpty = new boolean[N][M];
                Queue<int[]> q = new LinkedList<>();
                // (0,0)부터 패딩된 빈 칸 출발
                q.offer(new int[]{0, 0});
                visitedEmpty[0][0] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d], ny = y + dy[d];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if (visitedEmpty[nx][ny]) continue;
                        if (storage[nx][ny] == '.') {
                            visitedEmpty[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }

                // 접근 가능한 target 모아두기
                List<int[]> toRemove = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (storage[i][j] != target) continue;
                        // 네 방향에 하나라도 visitedEmpty == true 면 접근 가능
                        for (int d = 0; d < 4; d++) {
                            int ni = i + dx[d], nj = j + dy[d];
                            if (visitedEmpty[ni][nj]) {
                                toRemove.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }
                // 한꺼번에 제거
                for (int[] p : toRemove) {
                    storage[p[0]][p[1]] = '.';
                }
            }
        }

        // 남은 컨테이너 세기
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (storage[i][j] != '.') answer++;
            }
        }
        return answer;
    }
}


package week5.강성욱.programmers;

import java.util.*;

public class 피로도 {
    //들어갈 던전에 번호별 제한은 없다.
        //즉, 1번 -> 3번 -> 2번 던전 순서대로 진입은 가능. 즉, 텔레포트로 이동한다고 생각할 것.
    //결국 조합별 탐색을 진행하면 됨.
    //재귀함수
        //각, 던전을 방문했는지 확인할 visited[] 필요. 사이즈는, dungeons.length;
        //방문 가능한지가, 1차 종료 조건. 만약 방문할 수 없다면, 종료함과 동시에 지금까지 방문한 depth 반환
        //더 이상 방문할 곳이 없는지가 2차 조건.
        //방문할 곳이 있다면, 그곳으로 방문(재귀 함수 호출)

    //시간복잡도는, O(n!), n == 8 (던전 개수)
    //이건, 8x7x6...x1 이기때문에 팩토리얼.
    //가능은 함.

    class Solution {
        public int solution(int k, int[][] dungeons) {
            boolean[] visited = new boolean[dungeons.length];
            return dfs(k, dungeons, visited, 0);
        }

        private int dfs(int nowHp, int[][] dungeons, boolean[] visited, int depth) {
            int maxDepth = depth;

            for (int i=0; i<dungeons.length; i++) {
                if (visited[i]) continue;
                if (nowHp < dungeons[i][0]) continue;

                boolean[] nextVisited = Arrays.copyOf(visited, visited.length);
                nextVisited[i] = true;
                int result = dfs(nowHp-dungeons[i][1], dungeons, nextVisited, depth+1);
                maxDepth = Math.max(maxDepth, result);
            }
            return maxDepth;
        }
    }
}

package week6.강성욱.programmers;

import java.util.*;

public class 전력망을_두개로_나누기 {
    // 어느 한 지점에서 시작해서, 들릴수 있는 모든 곳을 들린 뒤, 들린 횟수를 count check 하면, 그게 연결된 횟수다.
    // [1, 3], [2, 3] 이 있다면, 1->3->2 를 갈 수 있다는 뜻?
    // 배열에 담아서, 갈 수 있는가? 없는가를 체크하자.
    // 그럼 범위는 [101][101] 에, boolean 을 담아두고, [시작][도착] = true 로 하면, 시작->도착은 갈 수 있다. 라는 뜻으로 판단
    // 반복으로 해결
    // 시간 복잡도는, 모르겠는데 (계산이 안됨 ㅠ), 100 이하라 완탐으로 풀어도될듯.

    class Solution {
        public int solution(int n, int[][] wires) {
            boolean[][] tree = new boolean[n+1][n+1];
            int startNode = wires[0][0]; //시작 노드는 어느 노드든 상관없는데, 존재만 하면 됨.

            //초기 송전탑 전선 구성
            for(int[] wire : wires) {
                int a = wire[0];
                int b = wire[1];
                tree[a][b] = true;
                tree[b][a] = true;
            }

            int diffResult = Integer.MAX_VALUE;

            //wires
            for(int[] wire : wires) {
                // 끊어볼 전선의 정보, 추후 다시 연결해야되므로 저장.
                int a = wire[0];
                int b = wire[1];

                // 전선 끊어보기
                tree[a][b] = false;
                tree[b][a] = false;

                // startNode 로부터 연결된 개수 점검
                int nowCount = checkConnect(tree, new boolean[101], startNode, n);
                int nowCount2 = n - nowCount;

                diffResult = Math.min(Math.abs(nowCount - nowCount2), diffResult);

                // 전선 복구
                tree[a][b] = true;
                tree[b][a] = true;
            }

            return diffResult;
        }

        private int checkConnect(boolean[][] tree, boolean[] visited, int startNode, int n) {
            int count = 1;
            Queue<Integer> q = new LinkedList<>();
            q.offer(startNode);
            visited[startNode] = true;

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int i = 1; i <= n; i++) {
                    if (tree[node][i] && !visited[i]) {
                        visited[i] = true;
                        count++;
                        q.offer(i);
                    }
                }
            }
            return count;
        }
    }
}

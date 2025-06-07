/**
 * PackageName : week6.이상억.progarmmers;
 * FileName    : 전력망_둘로_나누기
 * Author      : sangeok
 * Date        : 2025. 6. 5.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 5.     sangeok               Initial creation
 */

// 문제 요구사항 : 	전선을 통해 하나의 트리 형태, 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할
//        이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게
//        송전탑의 개수 : n / 전선 정보 : wires
//          [v1, v2] 는 v1번과 v2 번 송전탑이 전선으로 연결 되어 있다는 뜻

//        접근 방식 : (1) dfs 로
//        1) 길이 만큼 반복문
//        2) 배열(간선) 제거
//        3) 자른 리스트를 트리로 만들기
//        4) 한 컴포넌트의 갯수 세서 전체의 노드 수 빼서 절대 값 처리

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        List<int[]> wirelist = new ArrayList<>();
        for (int[] wire : wires) {
            wirelist.add(wire);
        }

        for (int i = 0; i < wirelist.size(); i++) {
            List<int[]> wirecopy = new ArrayList<>(wirelist);
            wirecopy.remove(i);

            // 그래프 만들기
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int[] wire : wirecopy) {
                int a = wire[0];
                int b = wire[1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            //  한 쪽 컴포넌트만 DFS 탐색
            boolean[] visited = new boolean[n + 1];
            int count = dfs(graph, visited, 1);  // 1번 노드부터 탐색

            // (3) 나머지는 n - count → 차이의 절댓값 계산
            int diff = Math.abs(n - 2 * count);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        int count = 1;

        for (int a : graph.get(node)) {
            if (!visited[a]) {
                count += dfs(graph, visited, a);
            }
        }

        return count;
    }
}

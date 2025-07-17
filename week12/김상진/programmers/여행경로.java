package week12.김상진.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class 여행경로 {
import java.util.*;

   import java.util.*;

    class Solution {
        Map<String, PriorityQueue<String>> graph;
        List<String> resultPath; // 최종 경로 (역순으로 저장 후 뒤집을 예정)


        public String[] solution(String[][] tickets) {
            graph = new HashMap<>();
            resultPath = new LinkedList<>(); // LinkedList를 사용하면 addFirst가 효율적

            // 그래프 초기화 (Map에 항공권 정보 저장, 도착지는 PriorityQueue로 알파벳 순 정렬)
            for (String[] ticket : tickets) {
                graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
            }

            // "ICN"에서 DFS 탐색 시작
            dfs("ICN");

            // 경로가 역순으로 저장되었으므로 뒤집기
            Collections.reverse(resultPath);

            // List를 String[] 배열로 변환하여 반환
            return resultPath.toArray(new String[0]);
        }
        private void dfs(String currentAirport) {
            // 현재 공항에서 출발하는 항공권들이 있다면 (즉, 아직 방문하지 않은 간선이 있다면)
            // while문으로 PriorityQueue가 빌 때까지 반복합니다.
            // PriorityQueue.poll()은 해당 요소를 큐에서 제거합니다.
            while (graph.containsKey(currentAirport) && !graph.get(currentAirport).isEmpty()) {
                String nextAirport = graph.get(currentAirport).poll(); // 가장 빠른 도착지 선택 후 제거
                dfs(nextAirport); // 다음 공항으로 재귀 호출
            }
            // 더 이상 갈 곳이 없으면 (또는 모든 간선을 다 사용했으면) 현재 공항을 경로에 추가
            // 이 공항은 '더 이상 갈 곳이 없는' 마지막 지점이거나,
            // 해당 공항에서 나가는 모든 간선을 이미 방문했다는 의미입니다.
            resultPath.add(currentAirport);
        }
    }
}

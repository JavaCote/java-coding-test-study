/**
 * PackageName : week12.이상억.progarmmers;
 * FileName    : 여행경로
 * Author      : sangeok
 * Date        : 2025. 07. 14.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 14.     sangeok               Initial creation
 */


// 항상 "ICN" 에서 출발
// 모든 공항 대문자 3글자
// [a,b] a->b
// 주어진 공항은 모두 사용
// 만일 가능한 경로 2개 이상일 경우 알파벳 순서가 앞서는 경우
// 모든 도시를 방문 할 수 없는 경우는 주어지지 않음

// DFS 가 더 적합할 것 같음

// dfs 안에 우선 이전 tickets[1]과 다음 tickets[0]이 동일한지 판단
// 근데 그 동일한 후보군들을 어디에 담아야 할 거 같은데 ? 그 담고 알파벳 순
// 그리고 visited = true 처리

// 동일 후보군들을 담는게 아니라 애초에 tickets 배열을 정렬 시켜놓고 가장 먼저 완성되는 path 가 문제 요구사항에서 원하는 경로
import java.util.*;

class Solution {
    static List<String> answerlist = null;

    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");

        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        dfs("ICN", tickets, path, visited);

        return answerlist.toArray(new String[0]);
    }

    public void dfs(String current, String[][] tickets, List<String> path, boolean[] visited) {
        if (path.size() == tickets.length + 1) {
            if (answerlist == null) {
                answerlist = new ArrayList<>(path);  // 처음 완성된 경로만 저장
            }

            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(current) && !visited[i]) {
                visited[i] = true;
                path.add(tickets[i][1]);

                dfs(tickets[i][1], tickets, path, visited);

                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}

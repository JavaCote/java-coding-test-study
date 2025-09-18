/**
 * PackageName : week21.이상억.progarmmers;
 * FileName    : 혼자_놀기의_달인
 * Author      : sangeok
 * Date        : 2025. 09. 17.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 17.     sangeok               Initial creation
 */



// cycle 확인 -> cycle.length 최대값

import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[cards.length];

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int cur = i;
                int length = 0;
                while (!visited[cur]) {
                    visited[cur] = true;
                    cur = cards[cur] - 1;
                    length++;
                }
                list.add(length);
            }
        }
        list.sort((a, b) -> Integer.compare(b, a));

        if(list.size() < 2) return 0;
        return list.get(0) * list.get(1);
    }
}
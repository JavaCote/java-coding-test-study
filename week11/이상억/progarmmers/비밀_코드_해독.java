/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 비밀_코드_해독
 * Author      : sangeok
 * Date        : 2025. 07. 10.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 10.     sangeok               Initial creation
 */


// 시스템은 1 ~ n 까지 서로 다른 정수 5개가 오름차순으로 정렬
// m 번을 시도 할 수 있음
// 각 시도마다 서로 다른 정수 5개를 입력하면 시스템은 그 중 몇개가 비밀 코드에 포함 되어있는지 알려줌

// 1,2,3,4,5 => 2
// 6,7,8,9,10 => 3
// 3,7,8,9,10 => 4
// 2,5,7,9,10 => 3
// 3,4,5,6,7 => 3

// 완전탐색 문제 ? - > dfs 로 시도

// 배열 뽑아서 hashset에 등록 ? 그 후 계속 q 배열을 돌려서 시스템응답이 일치하는지 ? 체크해서 맞는 수의 조합만 추가 ?

import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = i + 1;

        whgkq(numbers, new ArrayList<>(), q, ans, 0);

        answer = validcount;
        return answer;
    }

    int validcount = 0;

    public void whgkq(int[] numbers, List<Integer> current, int[][] q, int[] ans, int idx) {
        if (current.size() == 5) {
            if (isvalid(current, q, ans)) validcount++;
            return;
        }
        if (idx >= numbers.length) return;

        current.add(numbers[idx]);
        whgkq(numbers, current, q, ans, idx + 1);

        current.remove(current.size() - 1);
        whgkq(numbers, current, q, ans, idx + 1);
    }

    public boolean isvalid(List<Integer> current, int[][] q, int[] ans) {
        Set<Integer> set = new HashSet<>(current);

        for (int i = 0; i < q.length; i++) {
            int count = 0;
            for (int k : q[i]) {
                if (set.contains(k)) count++;
            }

            if (ans[i] != count) return false;
        }
        return true;
    }
}

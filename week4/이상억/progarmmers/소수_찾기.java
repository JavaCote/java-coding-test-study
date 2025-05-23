package week4.이상억.progarmmers;

/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 소수_찾기
 * Author      : sangeok
 * Date        : 2025. 5. 23.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 23.     sangeok               Initial creation
 */
// 문제 요구사항 : 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇개 인지

// 회고 :  완전탐색에 대한 지식이 현저히 떨어져서 뭐 감이 오지 않아 찾아보면서 풀었지만 이게 내가 푼게 맞나 싶다
// 구조가 이해가 가지만 이 문제는 추후 다시 풀어보고 완전탐색에 대해 공부를 해보며 알고리즘 자체를 구현해봐야 겠다.

import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];

        dfs(numbers, "", visited);

        int count = 0;
        for (int num : set) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    void dfs(String numbers, String current, boolean[] visited) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

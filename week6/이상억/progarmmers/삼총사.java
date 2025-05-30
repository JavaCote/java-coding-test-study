/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 삼총사
 * Author      : sangeok
 * Date        : 2025. 5. 30.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 30.     sangeok               Initial creation
 */

// 접근 방식 : (1) dfs 로 접근해서 풀었다

// 회고 : 보자마자 완전탐색 유형의 문제임이 많이 느껴졌다. for문을 사용해서 푸는 방식이 먼저 떠올랐지만 학습을 위해 dfs 로 시도 해봤다.
// 5주차를 풀고 자신감을 많이 얻고 다른 문제도 쉽게 풀 수 있을거라 생각했지만 아직은 dfs 유형에 더 익숙해져야 함을 느꼈다.


class Solution {
    int answer = 0;

    public int solution(int[] number) {
        dfs(number, 0, 0, 0);
        return answer;
    }

    public void dfs(int[] number, int idx, int start, int sum) {
        if (idx == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }

        for (int i = start; i < number.length; i++) {
            dfs(number, idx + 1, i + 1, sum + number[i]);
        }
    }
}

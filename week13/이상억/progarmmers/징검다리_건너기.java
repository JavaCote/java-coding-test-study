/**
 * PackageName : week13.이상억.progarmmers;
 * FileName    : 최댓값과_최솟값
 * Author      : sangeok
 * Date        : 2025. 07. 24.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 24.     sangeok               Initial creation
 */


class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000; // 최대값
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(stones, k, mid)) {
                // mid명까지 건널 수 있음 → 더 많이 시도
                answer = mid;
                left = mid + 1;
            } else {
                // 못 건너면 사람 수 줄이기
                right = mid - 1;
            }
        }

        return answer;
    }

    // x명이 건널 수 있는가? -> 연속으로 0 이하가 k개 이상 나오면 false
    private boolean canCross(int[] stones, int k, int x) {
        int count = 0;

        for (int stone : stones) {
            if (stone - x < 0) {
                count++;
                if (count >= k) return false;
            } else {
                count = 0;
            }
        }

        return true;
    }
}

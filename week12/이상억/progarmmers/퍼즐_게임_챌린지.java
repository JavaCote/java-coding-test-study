/**
 * PackageName : week12.이상억.progarmmers;
 * FileName    : 퍼즐_게임_챌린지
 * Author      : sangeok
 * Date        : 2025. 07. 21.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 21.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // diffs 중 가장 큰 값 구하기
        int maxDiff = 0;
        for (int diff : diffs) {
            if (diff > maxDiff) maxDiff = diff;
        }

        int left = 1;
        int right = maxDiff;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            long totalTime = 0;
            for (int i = 0; i < diffs.length; i++) {
                int prevTime = (i == 0) ? 0 : times[i - 1];
                totalTime += cleartime(mid, diffs[i], times[i], prevTime);
                if (totalTime > limit) break; // 가지치기
            }

            if (totalTime <= limit) {
                answer = mid;
                right = mid - 1; // 더 낮은 level 시도
            } else {
                left = mid + 1; // 더 높은 level 시도
            }
        }

        return answer;
    }

    public int cleartime(int level, int diff, int time, int prevTime) {
        if (diff <= level) {
            return time;
        } else {
            return (time + prevTime) * (diff - level) + time;
        }
    }
}

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        if (k <= 0) return 0;

        int max = 0;
        for (int t : tangerine) {
            max = Math.max(max, t);
        }

        int[] count = new int[max + 1];

        for (int i : tangerine) {
            count[i]++;
        }

        Arrays.sort(count);

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == 0) break;
            if (k <= 0) break;

            k -= count[i];
            answer++;
        }

        return answer;
    }
}

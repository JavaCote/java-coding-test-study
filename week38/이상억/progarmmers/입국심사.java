import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        return binarySearch(n, times);
    }

    public long binarySearch(int n, int[] times) {
        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long people = 0;
            for (int i = 0; i < times.length; i++) {
                people += mid / times[i];
                if (people >= n) break; // 최적화
            }

            if (people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}

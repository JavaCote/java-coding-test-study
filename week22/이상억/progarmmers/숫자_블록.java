import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];

        for (long i = begin; i <= end; i++) {
            answer[(int)(i - begin)] = block_number(i);
        }
        return answer;
    }

    public int block_number(long n) {
        if (n == 1) return 0;

        int result = 1;

        for (long d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                long pair = n / d;

                if (d <= 10_000_000) {
                    result = Math.max(result, (int)d);
                }

                if (pair <= 10_000_000) {
                    // 가장 큰 약수를 바로 찾았으므로 반환
                    return (int)pair;
                }
            }
        }
        return result;
    }
}

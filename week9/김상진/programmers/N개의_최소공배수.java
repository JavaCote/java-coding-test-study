package week9.김상진.programmers;

public class N개의_최소공배수 {
    // 문제의 구현 방법이 떠오르지를 않아서 ai랑 풀면서 이해
    import java.util.*;
    class Solution {

        public int solution(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return 0;
            }

            if (numbers.length == 1) {
                return numbers[0];
            }

            long currentLcm = numbers[0];

            for (int i = 1; i < numbers.length; i++) {
                int gcdValue = calculateGcd((int) currentLcm, numbers[i]);
                currentLcm = (currentLcm * numbers[i]) / gcdValue;
            }

            return (int) currentLcm;
        }

        private static int calculateGcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return calculateGcd(b, a % b);
        }
    }

}

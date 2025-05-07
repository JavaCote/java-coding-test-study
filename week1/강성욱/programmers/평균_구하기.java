package week1.강성욱.programmers;

import java.util.Arrays;

public class 평균_구하기 {
    class Solution {
        public double solution(int[] arr) {
            return Arrays.stream(arr).average().orElse(0);
        }
    }
}

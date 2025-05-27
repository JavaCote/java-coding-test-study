package week5.김나은.programmers;

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for(int i = 0; i < d.length; i++) {
            if(d[i] <= budget) {
                answer += 1;
                budget -= d[i];
            } else {
                break;
            }
        }

        return answer;
    }
}
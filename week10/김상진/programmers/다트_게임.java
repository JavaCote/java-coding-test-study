package week10.김상진.programmers;

public class 다트_게임 {
    import java.util.*;

    class Solution {
        public int solution(String dartResult) {
            int[] scores = new int[3];
            int idx = -1;

            for (int i = 0; i < dartResult.length(); i++) {
                char c = dartResult.charAt(i);

                if (Character.isDigit(c)) {
                    idx++;
                    // 10 처리
                    if (c == '1' && i + 1 < dartResult.length() && dartResult.charAt(i+1) == '0') {
                        scores[idx] = 10;
                        i++;
                    } else {
                        scores[idx] = c - '0';
                    }
                } else if (c == 'S') {
                    scores[idx] = (int)Math.pow(scores[idx], 1);
                } else if (c == 'D') {
                    scores[idx] = (int)Math.pow(scores[idx], 2);
                } else if (c == 'T') {
                    scores[idx] = (int)Math.pow(scores[idx], 3);
                } else if (c == '*') {
                    if (idx > 0) scores[idx-1] *= 2;
                    scores[idx] *= 2;
                } else if (c == '#') {
                    scores[idx] *= -1;
                }
            }

            return scores[0] + scores[1] + scores[2];
        }
    }

}

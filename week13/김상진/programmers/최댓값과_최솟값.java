package week13.김상진.programmers;

import java.util.Arrays;

public class 최댓값과_최솟값 {
    import java.util.*;

    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] arr = s.split(" ");
            int[] num = new int[arr.length];
            for (int i = 0; i < num.length; i++) {
                num[i]=Integer.parseInt(arr[i]);
            }
            Arrays.sort(num);
            answer+=num[0]+" "+num[num.length-1];
            return answer;
        }
    }

}

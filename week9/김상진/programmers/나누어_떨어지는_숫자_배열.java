package week9.김상진.programmers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나누어_떨어지는_숫자_배열 {
import java.util.*;
    class Solution {
        public List<Integer> solution(int[] arr, int divisor) {
            Arrays.sort(arr);
            List<Integer> answer= new ArrayList<>();
            for(int i : arr){
                if(i%divisor ==0) answer.add(i);
            }
            if(answer.isEmpty())answer.add(-1);
            return answer;
        }
    }
}

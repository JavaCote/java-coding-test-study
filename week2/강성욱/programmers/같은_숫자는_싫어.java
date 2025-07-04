package week2.강성욱.programmers;

import java.util.*;

public class 같은_숫자는_싫어 {
    public class Solution {
        public int[] solution(int []arr) {
            Deque<Integer> dq = new ArrayDeque<>();

            for(int ar : arr) {

                if(!dq.isEmpty()) {
                    Integer temp = dq.peekLast();
                    if(temp.equals(ar)) continue;
                }
                dq.addLast(ar);
            }

            return dq.stream().mapToInt(i -> i.intValue()).toArray();
        }
    }
}

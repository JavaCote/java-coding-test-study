package week11.김상진.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두_개_뽑아서_더하기 {
    import java.util.*;

    class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < numbers.length; i++) {
                for(int j = i + 1; j < numbers.length; j++) {
                    set.add(numbers[i] + numbers[j]);
                }
            }

            int[] answer = new int[set.size()];
            int index = 0;
            for(int num : set) {
                answer[index++] = num;
            }

            Arrays.sort(answer);
            return answer;
        }
    }

}

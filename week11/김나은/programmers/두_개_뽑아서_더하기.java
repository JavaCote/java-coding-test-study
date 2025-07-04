package week11.김나은.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두_개_뽑아서_더하기 {

    class Solution {

        public int[] solution(int[] numbers) {

            // 중복되는 값이 들어가면 안되므로, Set 사용
            Set<Integer> set = new HashSet<>();

            // 서로 다른 인덱스의 두 수를 더함
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    int sum = numbers[i] + numbers[j];
                    set.add(sum);
                }
            }

            // 정렬을 위해 set을 배열로 변환
            int[] answer = new int[set.size()];
            int idx = 0;

            // 배열에 set 값을 하나씩 넣어줌
            for (int num : set) {
                answer[idx++] = num;
            }

            Arrays.sort(answer);

            return answer;
        }
    }
}

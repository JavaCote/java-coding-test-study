package week8.김나은.programmers;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {

    class Solution {

        public int solution(int[] elements) {
            int answer = 0;

            // 중복 없는 합을 저장할 Set
            Set<Integer> sumSet = new HashSet<>();

            int length = elements.length;

            // size : 부분 수열의 길이 (1부터 length까지)
            for (int size = 1; size <= length; size++) {
                int sum = 0;
                int start = 0;

                // 초기 부분 수열 합 계산 (맨 앞에서 size 길이 만큼)
                for (int i = 0; i < size; i++) {
                    sum += elements[i];
                }
                // 합을 Set에 추가
                sumSet.add(sum);

                // start를 1씩 증가시키며 다음 부분 수열 합 계산 (원형 수열 처리)
                while (start < length - 1) {
                    // 부분 수열의 맨 앞 값을 제거하고
                    sum -= elements[start];
                    // 다음 위치 값을 더함 (원형이므로 % length 처리)
                    sum += elements[(start + size) % length];
                    start++;

                    // 새로 계산된 합을 Set에 추가
                    sumSet.add(sum);
                }
            }

            // 서로 다른 합의 개수가 정답
            answer = sumSet.size();
            return answer;
        }
    }
}

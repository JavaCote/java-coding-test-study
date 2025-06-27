package week9.김나은.programmers;

import java.util.Arrays;

public class 나누어_떨어지는_숫자_배열 {

    class Solution {

        public int[] solution(int[] arr, int divisor) {
            int count = 0; // divisor로 나누어 떨어지는 요소의 개수를 세기 위한 변수

            // 첫 번째 반복문: 나누어 떨어지는 숫자의 개수 세기
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % divisor == 0) { // 나누어 떨어지는 경우
                    count++; // 개수 증가
                }
            }

            if (count == 0) {
                // 나누어 떨어지는 숫자가 없을 경우, -1을 원소로 가지는 배열 반환
                return new int[]{-1};
            }

            // 결과 배열 선언 (크기는 나누어 떨어지는 숫자의 개수만큼)
            int[] answer = new int[count];

            int index = 0; // answer 배열에 값을 넣기 위한 인덱스

            // 두 번째 반복문: 실제로 나누어 떨어지는 숫자를 answer 배열에 담음
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % divisor == 0) { // 나누어 떨어지면
                    answer[index++] = arr[i]; // 배열에 저장하고 인덱스 증가
                }
            }

            // 결과 배열을 오름차순으로 정렬
            Arrays.sort(answer);

            return answer;
        }
    }
}

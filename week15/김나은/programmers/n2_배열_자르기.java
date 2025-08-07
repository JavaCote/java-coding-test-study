package week15.김나은.programmers;

public class n2_배열_자르기 {

    class Solution {

        public int[] solution(int n, long left, long right) {
            // (right - left + 1) 크기의 정답 배열을 만든다
            int[] answer = new int[(int) (right - left) + 1];

            for (int i = 0; i < answer.length; i++) {
                // (i + left)는 1차원 배열에서의 실제 인덱스
                // n으로 나눠서 몫에 +1을 하면 "가상의 2차원 배열에서 행(1-based)"이 된다
                int row = (int) ((i + left) / n) + 1; // 1-base 행 번호

                // n으로 나눈 나머지에 +1을 하면 "가상의 2차원 배열에서 열(1-based)"이 된다
                int col = (int) ((i + left) % n) + 1; // 1-base 열 번호

                // 가상 2차원 배열의 (row, col) 위치의 값은 두 값 중 더 큰 값
                answer[i] = Math.max(row, col);
            }

            return answer;
        }
    }
}
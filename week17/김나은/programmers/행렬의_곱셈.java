package week17.김나은.programmers;

public class 행렬의_곱셈 {

    class Solution {

        public int[][] solution(int[][] arr1, int[][] arr2) {
            // 결과를 저장할 2차원 배열
            int[][] answer = new int[arr1.length][arr2[0].length];

            // arr1의 행 수만큼 반복
            for (int i = 0; i < arr1.length; i++) {
                // arr2의 열 수만큼 반복
                for (int j = 0; j < arr2[0].length; j++) {
                    // 행렬의 곱셈
                    for (int k = 0; k < arr1[0].length; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }

            return answer;
        }
    }
}
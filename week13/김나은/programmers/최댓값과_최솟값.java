package week13.김나은.programmers;

public class 최댓값과_최솟값 {

    class Solution {

        public String solution(String s) {
            // 입력받은 문자열을 공백(" ") 기준으로 split해서 배열로 만듬
            String[] sNum = s.split(" ");

            // 배열의 첫 번째 값을 int로 변환해서 max, min에 초기값으로 설정
            int max = Integer.parseInt(sNum[0]);
            int min = Integer.parseInt(sNum[0]);

            // 배열 전체를 돌면서 최대값과 최소값을 찾음
            for (String str : sNum) {
                int intNum = Integer.parseInt(str); // 현재 값을 int로 변환

                // 현재 숫자가 max보다 크거나 같으면 max 갱신
                if (intNum > max) {
                    max = intNum;
                    // 현재 숫자가 min보다 작으면 min 갱신
                } else if (intNum < min) {
                    min = intNum;
                }
            }

            // 최소값과 최대값을 "min max" 형태로 반환
            return min + " " + max;
        }
    }
}
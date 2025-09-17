package week21.김나은.programmers;

public class 숫자_짝꿍 {

    class Solution {

        public String solution(String X, String Y) {

            // 0~9까지 각 숫자의 등장 횟수를 저장할 배열
            int[] cntX = new int[10];
            int[] cntY = new int[10];

            // 문자열 X와 Y에 등장하는 숫자를 카운트해서 배열에 저장
            countNumInArr(X, cntX);
            countNumInArr(Y, cntY);

            // 결과 길이의 상한은 두 문자열 길이의 최솟값
            StringBuilder sb = new StringBuilder(Math.min(X.length(), Y.length()));

            // 큰 수를 만들어야 하므로 9부터 0까지 역순으로 확인
            for (int d = 9; d >= 0; d--) {
                // X와 Y에서 공통으로 가진 숫자의 개수 = 두 배열의 최소값
                int common = Math.min(cntX[d], cntY[d]);
                // 공통 개수만큼 결과 문자열에 추가
                for (int i = 0; i < common; i++) {
                    sb.append(d);
                }
            }

            // 예외 처리 1: 공통된 숫자가 전혀 없는 경우
            if (sb.length() == 0) {
                return "-1";
            }
            // 예외 처리 2: 결과가 모두 0으로만 이루어진 경우
            if (sb.charAt(0) == '0') {
                return "0";
            }

            return sb.toString();

        }

        // 주어진 문자열 s에 포함된 숫자들을 세어 배열 arr에 기록하는 메서드
        private void countNumInArr(String s, int[] arr) {
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - '0'; // 입력이 숫자 문자열이라는 전제
                arr[idx]++;
            }
        }
    }
}
package week8.김나은.programmers;

public class 이상한_문자_만들기 {

    class Solution {

        public String solution(String s) {
            String answer = "";
            // 주어진 문자열 s를 배열로 변환
            String[] strArr = s.split("");
            // 짝수 번째인지 홀수 번째인지 구분하기 위한 변수 선언
            int idx = 0;

            for (int i = 0; i < strArr.length; i++) {
                // 공백인 경우, idx를 1로 설정하여 다음 단어를 대문자로 만들어 준다.
                if (strArr[i].equals(" ")) {
                    idx = 1;
                }

                // 짝수 번째인 경우 대문자, 홀수 번째인 경우 소문자로 변환
                answer += idx % 2 == 0 ? strArr[i].toUpperCase() : strArr[i].toLowerCase();
                idx++;
            }

            return answer;
        }
    }
}

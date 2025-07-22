package week12.김나은.programmers;

public class 숫자_문자열과_영단어 {

    class Solution {

        public int solution(String s) {
            // 0부터 9까지의 숫자에 대응하는 영어 표기를 배열에 저장
            String[] strNum = {"zero", "one", "two", "three", "four", "five", "six", "seven",
                    "eight", "nine"};

            // strNum 배열을 순회하면서, 문자열 s에 포함된 영어 숫자를 해당 숫자로 치환
            for (int i = 0; i < strNum.length; i++) {
                // s에 strNum[i] (예: "one")이 있으면, 해당 부분을 i (예: "1")로 모두 바꾼다
                s = s.replace(strNum[i], Integer.toString(i));
            }

            // 모든 영어 숫자가 실제 숫자로 바뀐 s를 정수로 변환해서 반환
            return Integer.parseInt(s);
        }
    }
}

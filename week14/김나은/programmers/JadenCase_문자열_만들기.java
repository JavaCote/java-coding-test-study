package week14.김나은.programmers;

public class JadenCase_문자열_만들기 {

    class Solution {

        public String solution(String s) {
            StringBuilder sb = new StringBuilder(); // 결과 문자열을 저장할 StringBuilder
            boolean isFirstChar = true; // 단어의 첫 문자인지 여부 체크

            // 입력 문자열을 한 글자씩 순회
            for (char c : s.toCharArray()) {
                if (c == ' ') { // 공백 문자인 경우
                    sb.append(c);      // 그대로 결과에 추가
                    isFirstChar = true; // 다음 문자를 단어의 첫 문자로 처리
                } else {
                    if (isFirstChar) { // 단어의 첫 문자라면
                        sb.append(Character.toUpperCase(c)); // 대문자로 변환 후 추가
                        isFirstChar = false; // 첫 문자가 아니게 상태 변경
                    } else {
                        sb.append(Character.toLowerCase(c)); // 단어의 첫 문자가 아니면 소문자로 변환 후 추가
                    }
                }
            }
            return sb.toString(); // 결과 문자열 반환
        }
    }
}
package week15.김나은.programmers;

public class 삼진법_뒤집기 {

    class Solution {

        public int solution(int n) {
            int answer = 0;

            // n을 3진수 문자열로 변환 (예: 45 → "1200")
            String str = Integer.toString(n, 3);

            // 3진수 문자열을 뒤집기 (예: "1200" → "0021")
            String reverse = new StringBuilder(str).reverse().toString();

            // 뒤집힌 3진수 문자열을 10진수로 변환 (예: "0021" → 7)
            answer = Integer.valueOf(reverse, 3);

            return answer;
        }
    }
}

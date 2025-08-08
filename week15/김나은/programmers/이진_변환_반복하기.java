package week15.김나은.programmers;

public class 이진_변환_반복하기 {

    class Solution {

        public int[] solution(String s) {
            // 결과를 저장할 배열 (answer[0]: 이진 변환 횟수, answer[1]: 제거된 0의 개수)
            int[] answer = new int[2];

            // s의 길이가 1이 될 때까지 반복
            while (s.length() > 1) {
                int one = 0; // 문자열 내 1의 개수

                // 문자열을 한 글자씩 확인
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '0') {
                        answer[1]++; // 0이 나오면 제거된 0의 개수 증가
                    } else {
                        one++; // 1이면 one 증가
                    }
                }

                // 1의 개수를 2진수 문자열로 변환하여 s에 저장
                s = Integer.toBinaryString(one);
                answer[0]++; // 변환 횟수 증가
            }

            return answer;
        }
    }
}
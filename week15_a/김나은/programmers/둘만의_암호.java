package week15_a.김나은.programmers;

public class 둘만의_암호 {

    class Solution {

        public String solution(String s, String skip, int index) {
            // 변환된 문자열을 담을 StringBuilder
            StringBuilder sb = new StringBuilder();

            // 주어진 문자열 s의 각 문자를 순회
            for (char ch : s.toCharArray()) {
                // skip에 없는 알파벳을 몇 번 건너뛰었는지 세는 변수
                int count = 0;

                // count가 index에 도달할 때까지 반복
                while (count < index) {
                    // 현재 문자가 'z'라면 'a'부터 다시 시작 (알파벳 순환)
                    if (ch == 'z') {
                        ch = 'a';
                    } else {
                        ch++; // 다음 알파벳으로 이동
                    }
                    // skip 문자열에 현재 ch가 없으면 count 증가
                    // skip에 있으면 그냥 건너뛰기 (count 증가 안함)
                    if (!skip.contains(String.valueOf(ch))) {
                        count++;
                    }
                }
                // index만큼 건너뛴 최종 문자 추가
                sb.append(ch);
            }
            return sb.toString();
        }
    }
}
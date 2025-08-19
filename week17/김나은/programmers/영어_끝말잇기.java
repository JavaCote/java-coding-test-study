package week17.김나은.programmers;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {

    class Solution {

        public int[] solution(int n, String[] words) {
            // 이전에 나온 단어를 저장할 HashSet
            Set<String> usedWords = new HashSet<>();

            // 이전 단어를 저장할 변수
            String previousWord = words[0];

            // 첫 번째 단어는 HashSet에 추가
            usedWords.add(previousWord);

            // 두 번째 단어부터 검사
            for (int i = 1; i < words.length; i++) {
                String currentWord = words[i];

                // 1. 끝말잇기 규칙 위반 검사
                if (previousWord.charAt(previousWord.length() - 1) != currentWord.charAt(0)) {
                    return calculateAnswer(i, n);
                }

                // 2. 중복된 단어 사용 검사
                // add 메서드는 추가에 성공하면 true를 반환, 이미 존재하면 false를 반환
                if (!usedWords.add(currentWord)) {
                    return calculateAnswer(i, n);
                }

                // 현재 단어를 다음 턴의 '이전 단어'로 설정
                previousWord = currentWord;
            }

            // 모든 단어를 성공적으로 통과하면 [0, 0] 반환
            return new int[]{0, 0};
        }

        // 탈락자의 번호와 차례를 계산하는 헬퍼 함수
        private int[] calculateAnswer(int index, int n) {
            int personNumber = (index % n) + 1;
            int turnNumber = (index / n) + 1;
            return new int[]{personNumber, turnNumber};
        }
    }
}

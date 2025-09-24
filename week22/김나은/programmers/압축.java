package week22.김나은.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {

    class Solution {

        public List<Integer> solution(String msg) {

            List<Integer> answerList = new ArrayList<>();

            Map<String, Integer> map = new HashMap<>();

            // 사전 초기화
            int index = init(map);

            // 입력 문자열을 모두 처리할 때까지 반복
            int i = 0;
            while (i < msg.length()) {
                int j = i + 1;

                // 사전에 등록된 가장 긴 문자열을 찾을 때까지 j를 확장
                while (j <= msg.length() && map.containsKey(msg.substring(i, j))) {
                    j++;
                }
                // (i, j-1) 구간이 사전에 있는 가장 긴 문자열
                String w = msg.substring(i, j - 1);
                // 해당 문자열의 인덱스를 결과 리스트에 추가
                answerList.add(map.get(w));

                // 다음 글자까지 붙인 새 단어 등록 (있을 때만)
                if (j <= msg.length()) {
                    String wc = msg.substring(i, j); // w + 다음 글자
                    map.put(wc, index++);
                }

                // 포인터 i를 w 길이만큼 전진 (이미 처리한 부분은 건너뜀)
                i += w.length();
            }

            return answerList;
        }

        // 사전 초기화 메서드
        private int init(Map<String, Integer> map) {
            int index = 1;

            for (char ch = 'A'; ch <= 'Z'; ch++) {
                map.put(String.valueOf(ch), index++);
            }

            // 다음 새 문자열이 등록될 인덱스를 반환 (27부터 시작)
            return index;
        }
    }
}
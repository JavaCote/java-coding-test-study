package week20.김나은.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 튜플 {

    class Solution {

        public int[] solution(String s) {
            int[] answer = {};

            // 입력 문자열에서 맨 앞 "{{" 와 맨 뒤 "}}" 제거
            s = s.substring(2, s.length() - 2);
            // "},{“ 구분자를 기준으로 집합 단위로 분리
            String[] arr = s.split("\\},\\{");

            // 각 숫자의 등장 횟수를 저장할 Map
            Map<String, Integer> map = new HashMap<>();

            // 모든 집합을 순회하며 숫자 등장 횟수 카운트
            for (String str : arr) {
                String[] numArr = str.split(",");
                for (String num : numArr) {
                    // num이 이미 있으면 +1, 없으면 1로 초기화
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }

            // keySet()으로 숫자(문자열)를 뽑아 리스트로 변환
            List<String> keyList = new ArrayList<>(map.keySet());
            // 등장 횟수를 기준으로 내림차순 정렬
            keyList.sort((s1, s2) -> map.get(s2) - map.get(s1));

            // 정답 배열 생성
            answer = new int[keyList.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = Integer.parseInt(keyList.get(i));
            }

            return answer;
        }
    }
}
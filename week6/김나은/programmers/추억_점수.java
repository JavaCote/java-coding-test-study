package week6.김나은.programmers;

import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {

    class Solution {

        public int[] solution(String[] name, int[] yearning, String[][] photo) {

            // 각 photo마다 계산된 점수를 담을 배열 선언 (photo의 길이만큼)
            int[] answer = new int[photo.length];

            // name과 yearning 값을 매칭해서 저장할 Map 선언
            Map<String, Integer> map = new HashMap<>();

            // name[i]와 yearning[i]를 map에 저장 (이름&그리움 점수 매칭)
            for (int i = 0; i < name.length; i++) {
                map.put(name[i], yearning[i]);
            }

            // 각 photo 배열을 순회하면서 점수 계산
            int index = 0; // answer 배열의 인덱스

            for (String[] p : photo) {
                for (String s : p) {
                    // map에서 s(이름)에 해당하는 그리움 점수 가져옴. 없으면 0점
                    answer[index] += map.getOrDefault(s, 0);
                }
                index++; // 다음 photo로 인덱스 증가
            }

            return answer;
        }
    }
}
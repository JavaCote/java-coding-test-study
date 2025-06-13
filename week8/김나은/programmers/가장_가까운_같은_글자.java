package week8.김나은.programmers;

import java.util.HashMap;

public class 가장_가까운_같은_글자 {

    class Solution {

        public int[] solution(String s) {

            int[] answer = new int[s.length()];

            // 각 문자와 그 문자가 마지막으로 등장한 인덱스를 저장하는 맵
            HashMap<Character, Integer> map = new HashMap<>();

            // 문자열을 왼쪽부터 오른쪽으로 순회
            for (int i = 0; i < s.length(); i++) {
                // 현재 인덱스의 문자
                if (!map.containsKey(s.charAt(i))) {
                    // 해당 문자가 처음 나왔다면 -1
                    answer[i] = -1;
                } else {
                    // 이전에 나왔던 문자라면 현재 인덱스와 마지막 등장 인덱스 차이를 저장
                    answer[i] = i - map.get(s.charAt(i));
                }

                // 현재 문자의 인덱스를 맵에 갱신
                map.put(s.charAt(i), i);
            }

            return answer;
        }
    }
}
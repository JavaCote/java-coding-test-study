package week2.강성욱.programmers;

import java.util.*;

public class 완주하지_못한_선수 {
    // List 에 담아두고, remove 로 처리 하면 될듯?
    // 근데, 100_000 까지니깐, 시간 복잡도가 맨끝에 있는거부터 처리한다고 치면..
        // o(100_000) + o(99_999) + .... o(1) 이렇게 걸릴 수도 있음.
        // 결국 보수적으로 보면, o(n^2) 시간복잡도.
        // 너무 큼.
    // Set은 안되고. (중복 이름이 있으니), Hash 로 해결

    class Solution {
        public String solution(String[] participant, String[] completion) {

            Map<String, Integer> map = new HashMap<>();//key : 이름, value : 몇명인지. 동명이인 있어서 이렇게.,,
            // 참가자 Map 에 저장. 만약, 동명이인 있으면, value 가 증가함.
            for(String name : participant) {
                map.put(name, map.getOrDefault(name, 0) + 1);
            }

            // 참가자 Map 에서, 완주자 삭제
            for(String name : completion) {
                map.put(name, map.getOrDefault(name, 0) - 1);
            }

            // map 에서 미완주자 찾기.
            // 1 이상이면 참가는 했는데, 완주 못한거.
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() >= 1) {
                    return entry.getKey();
                }
            }

            // 그럴일은 없지만, 모두 완주한 경우. 케이스 없음.
            return "";
        }
    }
}

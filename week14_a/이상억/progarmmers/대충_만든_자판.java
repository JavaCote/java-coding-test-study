// 1번키 한번 누르면 a 두번 누르면 b 세번 누르면 c
// 키의 개수 1 ~ 100

// 배열 인덱스로 해시맵 만들면 될 듯

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();

        for(String keys : keymap) {
            for(int i = 0 ; i < keys.length(); i++){
                char c = keys.charAt(i);
                int touchcount = i + 1;

                map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), touchcount));
            }
        }

        for(int i = 0 ; i < targets.length; i ++){
            String target = targets[i];
            int total = 0;
            boolean ip = false;

            for(char c : target.toCharArray()){
                if(map.containsKey(c)){
                    total += map.get(c);
                } else {
                    total =-1;
                    ip = true;
                    break;
                }
            }
            answer[i] = total;
        }

        return answer;
    }
}
/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 추억_점수
 * Author      : sangeok
 * Date        : 2025. 5. 30.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 30.     sangeok               Initial creation
 */

// 접근 방식 : (1) hashmap 사용

// 회고 : 다른 방식으로 문제를 풀어보려고 했는데 hashmap 이 머리에 박혀서 그냥 이걸로 풀었다.

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> scoremap = new HashMap<>();

        for(int i = 0; i < name.length; i++){
            scoremap.put(name[i], yearning[i]);
        }
        int x = 0 ;
        for(String[] a : photo){
            int sum = 0;
            for(String b : a){
                sum += scoremap.getOrDefault(b,0);
            }
            answer[x] = sum;
            x++;

        }
        return answer;
    }
}
/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 제일_작은_수_제거하기
 * Author      : sangeok
 * Date        : 2025. 6. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 29.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int min = Integer.MAX_VALUE;
        for(int a : arr){
            if( a < min) min = a;
        }

        List<Integer> list = new ArrayList<>();

        for(int a : arr){
            if(a > min) list.add(a);
        }
        int[] answer = new int[list.size()];

        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
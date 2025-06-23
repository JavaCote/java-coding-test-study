/**
 * PackageName : week9.이상억.progarmmers;
 * FileName    : 나누어_떨어지는_숫자_배열
 * Author      : sangeok
 * Date        : 2025. 6. 23.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 23.     sangeok               Initial creation
 */



import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();

        for(int i : arr) {
            if( i % divisor == 0) list.add(i);
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        if(list.isEmpty()) return new int[]{-1};
        Arrays.sort(answer);
        return answer;
    }
}
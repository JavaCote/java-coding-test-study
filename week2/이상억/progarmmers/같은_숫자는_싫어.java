package week2.이상억.progarmmers;

/**
 * PackageName : week2.이상억.programmers
 * FileName    : 같은_숫자는_싫어
 * Author      : sangeok
 * Date        : 2025. 5. 6.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 6.     sangeok               Initial creation
 */

import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i<arr.length-1;i++){
            if(arr[i] != arr[i+1]){
                answer.add(arr[i]);
            }
        }
        answer.add(arr[arr.length-1]);
        return answer;
    }
}
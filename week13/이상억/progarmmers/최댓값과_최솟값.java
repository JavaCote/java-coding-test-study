/**
 * PackageName : week13.이상억.progarmmers;
 * FileName    : 최댓값과_최솟값
 * Author      : sangeok
 * Date        : 2025. 07. 22.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 22.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public String solution(String s) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        String[] split_s = s.split(" ");
        for(String number : split_s){
            int n = Integer.parseInt(number);
            min = Math.min(n,min);
            max = Math.max(n,max);
        }

        return min + " " + max;
    }
}
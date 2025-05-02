package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : 평균_구하기
 * Author      : sangeok
 * Date        : 2025. 4. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 29.     sangeok               Initial creation
 */

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int num : arr){
            answer+=num;
        }
        return answer/(arr.length);
    }
}
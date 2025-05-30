/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 카펫
 * Author      : sangeok
 * Date        : 2025. 5. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 29.     sangeok               Initial creation
 */

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for(int i = 3; i<= total; i++){
            int j = total / i;

            if( (( i - 2 ) * ( j - 2 )) == yellow ){
                answer[0] = i;
                answer[1] = j;
            }
        }
        return answer;
    }
}
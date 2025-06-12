/**
 * PackageName : week7.이상억.progarmmers;
 * FileName    : 음양_더하기
 * Author      : sangeok
 * Date        : 2025. 6. 9.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 9.     sangeok               Initial creation
 */

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++){
            if(signs[i] == true) answer += absolutes[i];
            if(signs[i] == false) answer -= absolutes[i];
        }
        return answer;
    }
}
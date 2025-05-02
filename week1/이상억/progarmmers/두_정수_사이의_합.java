package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : 두_정수_사이의_합
 * Author      : sangeok
 * Date        : 2025. 4. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 29.     sangeok               Initial creation
 */

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int ch = 0;
        if (a>b) {
            ch = a;
            a = b;
            b = ch;
        }
        for(int i = a; i<=b; i++){
            answer += (long)i;
        }
        return answer;
    }
}
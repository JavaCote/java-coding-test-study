package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : 자리숫_더하기
 * Author      : sangeok
 * Date        : 2025. 4. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 29.     sangeok               Initial creation
 */
import java.util.*;


public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n>0){
            answer += n%10;
            n /= 10;
        }
        return answer;
    }
}
package week2.이상억.progarmmers;

/**
 * PackageName : week2.이상억.programmers
 * FileName    : 최솟값_만들기
 * Author      : sangeok
 * Date        : 2025. 5. 6.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 6.     sangeok               Initial creation
 */

import java.util.Arrays;

class Solution
{
    public int solution(int []a, int []b)
    {

        int answer = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0; i<a.length;i++){
            answer += a[i] * b[a.length-i-1];
        }

        return answer;
    }
}
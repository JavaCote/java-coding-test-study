/**
 * PackageName : week7.이상억.progarmmers;
 * FileName    : 정수_내림차순으로_배치하기
 * Author      : sangeok
 * Date        : 2025. 6. 9.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 9.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public long solution(long n) {
        char[] number = String.valueOf(n).toCharArray();
        Arrays.sort(number);

        StringBuilder rb = new StringBuilder(new String(number));

        return Long.parseLong(rb.reverse().toString());
    }
}
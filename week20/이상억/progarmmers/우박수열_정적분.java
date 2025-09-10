/**
 * PackageName : week20.이상억.progarmmers;
 * FileName    : 우박수열_정적분
 * Author      : sangeok
 * Date        : 2025. 09. 09.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 09.     sangeok               Initial creation
 */

/**
 * PackageName : week19.이상억.progarmmers;
 * FileName    : N으로_표현
 * Author      : sangeok
 * Date        : 2025. 09. 04
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 04.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int solution(int N, int number) {

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {

            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatedN);

            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }

            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}

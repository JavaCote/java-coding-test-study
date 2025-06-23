/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 연속_부분_수열_합의_개수
 * Author      : sangeok
 * Date        : 2025. 6. 17.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 17.     sangeok               Initial creation
 */

// 회고 : 문제에 있는 원형 구조?
// 이걸 보고 원형큐를 생각해 큐를 사용해서 작성했다가 굳이라는 생각으 들어 % len을 사용해 문제를 풀었다.


import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumset = new HashSet<>();
        int len = elements.length;

        for (int window = 1; window <= len; window++) {
            for (int start = 0; start < len; start++) {
                int sum = 0;
                for (int k = 0; k < window; k++) {
                    sum += elements[(start + k) % len];
                }
                sumset.add(sum);
            }
        }

        return sumset.size();
    }
}

/**
 * PackageName : week17.이상억.progarmmers;
 * FileName    : 점_찍기
 * Author      : sangeok
 * Date        : 2025. 08. 20.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 20.     sangeok               Initial creation
 */


class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        long K = k;
        long D = d;
        long dist = D * D;

        for(long x = 0; x <= D; x+=K){
            long y_dist = dist - (x * x);
            long y = (long)Math.sqrt(y_dist);
            answer += (y/k) + 1;

        }

        return answer;
    }
}
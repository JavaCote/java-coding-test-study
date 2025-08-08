/**
 * PackageName : week15.이상억.progarmmers;
 * FileName    : 연속된_부분_수열의_합
 * Author      : sangeok
 * Date        : 2025. 08. 06.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 06.     sangeok               Initial creation
 */

// 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열
// 부분 수열의 합 : k
// 합이 k 인 부분 수열이 여러개인 경우 길이가 가장 짧은 수열
// 길이가 짧은 수열이 여러 개의 경우 ( 시작 인덱스가 작은 )


// 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열
// 부분 수열의 합 : k
// 합이 k 인 부분 수열이 여러개인 경우 길이가 가장 짧은 수열
// 길이가 짧은 수열이 여러 개의 경우 ( 시작 인덱스가 작은 )


class Solution {
    public int[] solution(int[] sequence, int k) {

        int sum = 0;

        int minlen = Integer.MAX_VALUE;
        int beststart = 0;
        int bestend = 0;

        int start = 0;
        int end = 0;

        while( end < sequence.length){
            sum += sequence[end];

            while(sum > k){
                sum -= sequence[start];
                start++;
            }

            if(sum == k){

                int len = end - start + 1;

                if(minlen > len){
                    minlen = len;
                    beststart = start;
                    bestend = end;
                }
            }

            end ++;
        }

        return new int[]{beststart,bestend};
    }
}
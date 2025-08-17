/**
 * PackageName : week16.이상억.progarmmers;
 * FileName    : 2개_이하로_다른_비트
 * Author      : sangeok
 * Date        : 2025. 08. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 12.     sangeok               Initial creation
 */


// x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            // 짝수면 무조건 x + 1이 비트 1개만 다름
            if ((x & 1) == 0) {
                answer[i] = x + 1;
            } else {
                // 홀수면 가장 낮은 0을 1로  그 바로 오른쪽 1을 0으로 바꿈
                long bit = 1L;

                while ((x & bit) != 0) {
                    bit <<= 1;
                }

                answer[i] = x + bit - (bit >> 1);
            }
        }

        return answer;
    }
}


// 테스트케이스 10,11에서 시간 초과 남 -> 완전 탐색의 방식으로 접근하기엔 무리가 있어보임


//class Solution {
//    public long[] solution(long[] numbers) {
//        long[] answer = new long[numbers.length];
//
//        for (int i = 0; i < numbers.length; i++) {
//            long x = numbers[i];
//
//            for (long cand = x + 1; ; cand++) {
//                int diff = Long.bitCount(x ^ cand);  // XOR 후 1의 개수 = 비트 차이 개수
//                if (diff == 1 || diff == 2) {
//                    answer[i] = cand;
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }
//}
//

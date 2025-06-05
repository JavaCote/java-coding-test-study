/**
 * PackageName : week6.이상억.progarmmers;
 * FileName    : 요격_시스템
 * Author      : sangeok
 * Date        : 2025. 6. 3.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 3.     sangeok               Initial creation
 */

//문제 요구사항 : 	[1,4], [3,7], [4,5], [4,8], [5,12], [10,14], [11,13]
//        이 직선을 다 격추시키려면 3개의 미사일이 필요

//        접근 방식 : (1) 미사일이 끝나는 targets[x][1] 기준 정렬
//        마지막 샷보다 새로 날아오는 미사일의 시작값이 크면 ? -> 새로운 쏴야하는 미사일 시작

// 전에 프로그래머스 시험 볼 때 풀지 않았었나 ? 풀었던 문제라 금방 풀었다.
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int shot = -1;

        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] target : targets) {
            if (target[0] >= shot) {
                answer++;
                shot = target[1];
            }
        }

        return answer;
    }
}

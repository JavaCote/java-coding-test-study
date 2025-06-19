/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 실패율
 * Author      : sangeok
 * Date        : 2025. 6. 18.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 18.     sangeok               Initial creation
 */


//문제 요구사항 :	실패율 => 클리어 못한 players / stages 도달한 players
//			전체 stage : N  // 현재 사용자가 멈춰 있는 번호가 담긴 배열 : stage
//			실패율이 높은 스테이지 부터 내림차순
//
//접근 방식 : stage 깬 사람과 도달한 사람을 hashmap으로 등록해서 나타내면 될 거같음. stages 배열을 돌면서 그 안에 또 for문을 사용해 clear와 falied 를 등록하니 시간 복잡도가 터짐 ( N X M )
//          => 정수 배열만을 두고 사용
//			중간 계산식에서 double 로 캐스팅 하기 싫어서 정수형으로 최대로 나타낼 수 있는 숫자  -2,100,000,000 ~ 2,100,000,000 이거 대충 생각하고 1억인가 10억 곱하는거로 했다가 overflow 나타남
//          그래서 결국엔 dobule 로 캐스팅 해서 풀었는데 중간에 0일 때를 따로 빼고 하지 않아서 테스트 케이스에서 오류가 많이나서 조건문 추가 해 해결

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int len = stages.length;

        int[] answer = new int[N];
        int[] failed = new int[N+2];

        List<double[]> list = new ArrayList<>();

        for( int stage : stages ){
            if( stage <= N ) failed[stage]++;
        }
        int total = len;
        for(int i = 1 ; i <= N; i++){
            int fail = failed[i];
            double failrate = (total == 0) ? 0.0 : (double) fail / total;
            list.add(new double[]{i,failrate});
            total -= fail;
        }

        list.sort((a, b) -> {
            int cmp = Double.compare(b[1], a[1]);
            if (cmp == 0) return (int)(a[0] - b[0]);
            return cmp;
        });

        for(int i = 0; i < N; i++){
            answer[i] = (int)list.get(i)[0];
        }
        return answer;
    }
}
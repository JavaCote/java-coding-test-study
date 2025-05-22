package week4.이상억.progarmmers;

/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 체육복
 * Author      : sangeok
 * Date        : 2025. 5. 22.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 22.     sangeok               Initial creation
 */

//문제 요구사항 :	 체육복을 앞/뒤 번호로만 빌려 줄 수 있음 = > 최대한 적절히 빌려 최대한 많은 학생이 입어야 함
//        전체 학생수 => n  / 체육복을 도난당한 학생들의 번호 담긴 배열 => lost
//        여벌 체육복을 가져온 학생 => reserve / 들을 수 있는 학생 최댓값 return

//        접근 방식 : 	(1) for 문과 list 만을 사용해서 작성해봤는데 13,18 에서 계속 실패하고 인덱스가 자꾸 밀리고 겹치는 학생 및 여러 조건을 처리하는데 list를 계속 선언해야하는 불편함이 생김 => 그냥 이 방법 유기하기로 함
//                      (2) hashset 사용

//        회고 : 어려운 문제는 아니였는데 자꾸 바로 생각나는 풀이로 시도하다보니 삽질 좀 했다. 아직까지 고쳐지지 않는 문제인데
                좀 더 넓게 봐야하는데 바로 앞만 보는거 같다.


import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        Set<Integer> lostset = new HashSet<>();
        Set<Integer> reserveset = new HashSet<>();

        for(int l : lost) lostset.add(l);
        for(int r : reserve) reserveset.add(r);

        for (int r : reserve) {
            if (lostset.contains(r)) {
                lostset.remove(r);
                reserveset.remove(r);
            }
        }

        for (int r : reserveset) {
            if (lostset.contains(r - 1)) {
                lostset.remove(r - 1);
            } else if (lostset.contains(r + 1)) {
                lostset.remove(r + 1);
            }
        }

        return n-lostset.size();
    }
}
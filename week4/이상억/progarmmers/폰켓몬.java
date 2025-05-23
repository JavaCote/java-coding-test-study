package week4.이상억.progarmmers;

/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 폰켓몬
 * Author      : sangeok
 * Date        : 2025. 5. 22.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 22.     sangeok               Initial creation
 */


//        문제 요구사항 : 	N마리 중 N/2 마리 가져가도 좋다
//        [3,1,2,3] 이래 있음 (3,1) , (3,2) , (3,3), (1,2), (1,3), (2,3) => 6가지 방법 가져 갈 수 있는 최대 포켓몬 2마리
//        최대한 많은 N/2마리를 가져가는 방법

//        접근 방식 : (1) list 선언해서 중복 안되는 값 담고 n/2 넘는지만 검사하면 될 거 같음.

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }

        return Math.min(list.size(), nums.length / 2);
    }
}

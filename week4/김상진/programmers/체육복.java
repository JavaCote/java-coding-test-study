package week4.김상진.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week4.김상진.programmers
 * FileName    : 체육복
 * Author      : sangxxjin
 * Date        : 2025. 5. 22.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 22.     sangxxjin               Initial creation
 */
public class 체육복 {
	// 중요한 점은 여벌 체육복이 있어도 도난 당할 수 있음.
	// 도난 당했을  경우 다른 사람에게 빌려줄 수 없음 -> 즉 reserve에 해당하지 않음
	// Set을 사용한 이유는 순서 상관 없음, 배열보다 탐색과 같은게 빠름
	import java.util.*;
	class Solution {
		public int solution(int n, int[] lost, int[] reserve) {
			Set<Integer> lostSet = new HashSet<>();
			Set<Integer> reserveSet = new HashSet<>();
			for(int i : reserve){
				reserveSet.add(i);
			}
			for(int i : lost){
				if(reserveSet.contains(i)){
					reserveSet.remove(i);
				}
				else lostSet.add(i);
			}
			for(Integer i : reserveSet){
				//앞사람 빌려준 경우
				if(lostSet.contains(i-1)){
					lostSet.remove(i-1);
				}
				//뒷사람 빌려준 경우
				else if(lostSet.contains(i+1)){
					lostSet.remove(i+1);
				}
			}
			return n-lostSet.size();
		}
	}
}

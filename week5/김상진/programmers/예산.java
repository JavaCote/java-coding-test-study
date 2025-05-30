package week5.김상진.programmers;

import java.util.Arrays;

/**
 * PackageName : week5.김상진.programmers
 * FileName    : 예산
 * Author      : sangxxjin
 * Date        : 2025. 5. 25.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 25.     sangxxjin               Initial creation
 */
public class 예산 {
	import java.util.*;
	class Solution {
		public int solution(int[] d, int budget) {
			int answer = 0;
			Arrays.sort(d);
			for(int i=0; i<d.length; i++){
				if(d[i]<=budget){
					answer++;
					budget-=d[i];
				}
			}
			return answer;
		}
	}
}

package week1.김상진.programmers;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 푸드_파이트_대회
 * Author      : sangxxjin
 * Date        : 2025. 4. 28.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 28.     sangxxjin               Initial creation
 */
public class 푸드_파이트_대회 {
	class Solution {
		public String solution(int[] food) {
			String answer = "";
			for(int i=1; i<food.length; i++){
				for(int j=0; j<food[i]/2; j++){
					answer+=i;
				}

			}
			return makeResult(answer);
		}
		private String makeResult(String s) {
			StringBuffer sb = new StringBuffer(s);
			String sbReverse = sb.reverse().toString();
			return s + "0" + sbReverse;
		}
	}
}

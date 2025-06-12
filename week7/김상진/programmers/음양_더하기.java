package week7.김상진.programmers;

/**
 * PackageName : week7.김상진.programmers
 * FileName    : 음양_더하기
 * Author      : sangxxjin
 * Date        : 2025. 6. 9.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 9.     sangxxjin               Initial creation
 */
public class 음양_더하기 {
	class Solution {
		public int solution(int[] absolutes, boolean[] signs) {
			int answer = 0;
			for(int i=0; i<absolutes.length; i++){
				if(signs[i])answer+=absolutes[i];
				else answer-=absolutes[i];
			}
			return answer;
		}
	}

}

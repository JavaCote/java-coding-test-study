package week4.김상진.programmers;

/**
 * PackageName : week4.김상진.programmers
 * FileName    : 숫자의_표현
 * Author      : sangxxjin
 * Date        : 2025. 5. 17.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 17.     sangxxjin               Initial creation
 */
public class 숫자의_표현 {
	class Solution {
		public int solution(int n) {
			int answer = 0;
			for(int i=1; i<=n; i++){
				int sum = 0;
				for(int j=i; j<=n; j++){
					sum+=j;
					if(sum==n){
						answer++;
						break;
					}
					if(sum>n){
						break;
					}
				}
			}
			return answer;
		}
	}
}

package week8.김상진.programmers;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 기사단원의_무기
 * Author      : sangxxjin
 * Date        : 2025. 6. 15.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 15.     sangxxjin               Initial creation
 */
public class 기사단원의_무기 {
	class Solution {
		public int solution(int number, int limit, int power) {
			int answer = 0;
			for(int i=1; i<=number; i++){
				int count = countDivisors(i);
				if(count>limit)answer+=power;
				else answer+=count;
			}
			return answer;
		}
		private int countDivisors(int num){
			int count=0;
			for(int i=1; i<=Math.sqrt(num);i++){
				if(num%i==0){
					count++;
					//약수일때 다른 한쪽의 약수도 추가
					if(i != num/i) count++;
				}
			}
			return count;
		}
	}
}

package week3.김상진.programmers;

/**
 * PackageName : week3.김상진.programmers
 * FileName    : 지폐_접기
 * Author      : sangxxjin
 * Date        : 2025. 5. 15.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 15.     sangxxjin               Initial creation
 */
public class 지폐_접기 {
	class Solution {
		public int solution(int[] wallet, int[] bill) {
			int answer = 0;
			//문제 설명을 보고 최소 횟수 구하는 과정을 이해하는데 시간이 조금 걸림 90도 회전 때문
			while(true){
				if(Math.max(wallet[0],wallet[1]) < Math.max(bill[0],bill[1]) || Math.min(wallet[0],wallet[1]) < Math.min(bill[0],bill[1])){
					if(bill[0]>bill[1]){
						bill[0]/=2;
						answer++;
					}
					else {
						bill[1]/=2;
						answer++;
					}
				}
				else break;
			}

			return answer;
		}
	}
}

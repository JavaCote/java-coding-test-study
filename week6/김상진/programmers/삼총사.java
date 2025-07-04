package week6.김상진.programmers;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 삼총사
 * Author      : sangxxjin
 * Date        : 2025. 6. 1.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 1.     sangxxjin               Initial creation
 */
public class 삼총사 {
	// n의 범위가 13이하임으로 On3제곱 가능함 1억 이하.
	// 더 좋은 방법이 있을까 고민했는데 3개의 조합이라서 못찾았음.
	// 문제 풀이 이후 다른 사람의 풀이를 봤는데 dfs와 같은 풀이방식도 있는데
	// 문제 풀이 시간은 3중 반복문과 유사
	import java.util.*;
	class Solution {
		public int solution(int[] number) {
			int answer = 0;
			for(int i=0; i<number.length-2; i++){
				for(int j=i+1; j<number.length-1; j++){
					for(int k=j+1; k<number.length; k++){
						if((number[i]+number[j]+number[k])==0)answer++;
					}
				}
			}
			return answer;
		}
	}
}

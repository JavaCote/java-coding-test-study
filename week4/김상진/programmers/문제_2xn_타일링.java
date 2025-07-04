package week4.김상진.programmers;

/**
 * PackageName : week4.김상진.programmers
 * FileName    : 문제_2xn_타일링
 * Author      : sangxxjin
 * Date        : 2025. 5. 20.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 20.     sangxxjin               Initial creation
 */
public class 문제_2xn_타일링 {
	//문제를보고 1칸또는 2칸 규칙이 생각나서 피보나치수열이 맞는지 예시를 몇개 확인해보니 맞았습니다
	class Solution {
		public int solution(int n) {
			int[] arr = new int[n];
			arr[0]=1;
			arr[1]=2;
			for(int i=2; i<n; i++){
				arr[i] = (arr[i-2]+arr[i-1])%1000000007;
			}
			return arr[n-1];
		}
	}
}

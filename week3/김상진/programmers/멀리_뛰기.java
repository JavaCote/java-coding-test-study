package week3.김상진.programmers;

/**
 * PackageName : week3.김상진.programmers
 * FileName    : 멀리_뛰기
 * Author      : sangxxjin
 * Date        : 2025. 5. 15.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 15.     sangxxjin               Initial creation
 */
public class 멀리_뛰기 {
	class Solution {
		//어떻게 풀어야할지 감이 전혀 안왔음.
		// 구글링 해보니 정해진 범위만큼 이동하는 문제는 대부분 피보나치 수열을 활용한다고 개념 파악.
		public long solution(int n) {
			int[] arr = new int[n+2];
			arr[1]=1;
			arr[2]=2;
			for(int i=3; i<=n; i++){
				arr[i]= (arr[i-2]+arr[i-1])%1234567;
			}
			return arr[n];
		}
	}
}

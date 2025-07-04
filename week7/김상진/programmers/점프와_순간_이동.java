package week7.김상진.programmers;

/**
 * PackageName : week7.김상진.programmers
 * FileName    : 점프와_순간_이동
 * Author      : sangxxjin
 * Date        : 2025. 6. 7.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 7.     sangxxjin               Initial creation
 */
public class 점프와_순간_이동 {
	// 알고리즘 짜는데 10분이상 소요됌
	// 순간이동은 무조건 2배임으로 홀수일때만 1씩 추가
	public class Solution {
		public int solution(int n) {
			int ans = 0;
			while(n>0){
				if(n%2==1){
					ans++;
				}
				n/=2;
			}
			return ans;
		}
	}
}

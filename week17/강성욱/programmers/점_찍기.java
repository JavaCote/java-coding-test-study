package week17.강성욱.programmers;

/**
 * PackageName : week17.강성욱.programmers
 * FileName    : 점_찍기
 * Author      : Baekgwa
 * Date        : 2025-08-19
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-19     Baekgwa               Initial creation
 */
public class 점_찍기 {
	class Solution {
		public long solution(long k, long d) {
			long answer = 0;

			for(long x = 0; x <= d; x += k){
				long maxY = (long) Math.sqrt(d*d - x*x);
				answer += maxY / k + 1;
			}

			return answer;
		}
	}
}

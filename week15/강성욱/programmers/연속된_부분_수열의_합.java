package week15.강성욱.programmers;

/**
 * PackageName : week15.강성욱.programmers
 * FileName    : 연속된_부분_수열의_합
 * Author      : Baekgwa
 * Date        : 2025-08-08
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-08     Baekgwa               Initial creation
 */
public class 연속된_부분_수열의_합 {

	class Solution {
		public int[] solution(int[] sequence, int k) {
			int start = 0;
			int end = 0;
			int sum = 0;
			int ans1 = 0;
			int ans2 = 0;
			int size = sequence.length;

			for(end=0; end < sequence.length; end++){
				sum += sequence[end];

				while(sum > k){
					sum -= sequence[start];
					start++;
				}

				if(sum == k){
					if(size > end-start) {
						size = end-start;
						ans1 = start;
						ans2 = end;
					}
					else if(size == end-start) {
						ans1 = Math.min(ans1, start);
						ans2 = Math.min(ans2, end);
					}
				}
			}

			return new int[] {ans1, ans2};
		}
	}
}

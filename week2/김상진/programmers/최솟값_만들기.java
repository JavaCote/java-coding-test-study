package week2.김상진.programmers;

import java.util.Arrays;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 최솟값_만들기
 * Author      : sangxxjin
 * Date        : 2025. 5. 8.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangxxjin               Initial creation
 */
public class 최솟값_만들기 {
	class Solution
	{
		public int solution(int []A, int []B)
		{
			int answer = 0;
			Arrays.sort(A);
			Arrays.sort(B);
			for(int i=0; i<A.length; i++){
				answer+=A[i]*B[B.length-1-i];
			}

			return answer;
		}
	}
}

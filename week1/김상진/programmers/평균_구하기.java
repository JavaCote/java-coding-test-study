package week1.김상진.programmers;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 평균_구하기
 * Author      : sangxxjin
 * Date        : 2025. 4. 27.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 27.     sangxxjin               Initial creation
 */
public class 평균_구하기 {
	public double solution(int[] arr) {
		double answer = 0;
		for (int j : arr) {
			answer += j;
		}
		answer/=arr.length;
		return answer;
	}
}

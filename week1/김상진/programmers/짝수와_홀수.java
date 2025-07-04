package week1.김상진.programmers;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 짝수와_홀수
 * Author      : sangxxjin
 * Date        : 2025. 4. 27.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 27.     sangxxjin               Initial creation
 */
public class 짝수와_홀수 {
	public String solution(int num) {
		String answer = "";
		if (num % 2 == 0)
			answer = "Even";
		else
			answer = "Odd";
		return answer;
	}
}

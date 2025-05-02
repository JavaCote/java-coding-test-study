package week1.김상진.programmers;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 약수의_합
 * Author      : sangxxjin
 * Date        : 2025. 4. 26.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 26.     sangxxjin               Initial creation
 */
public class 약수의_합 {
	public int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (n%i==0)answer+=i;
		}
		return answer;
	}
}

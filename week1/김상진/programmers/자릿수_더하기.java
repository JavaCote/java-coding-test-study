package week1.김상진.programmers;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 자릿수_더하기
 * Author      : sangxxjin
 * Date        : 2025. 4. 27.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 27.     sangxxjin               Initial creation
 */
public class 자릿수_더하기 {
	public int solution(int n) {
		int answer = 0;
		while (n>=1){
			answer+=n%10;
			n/=10;
		}

		return answer;
	}
}

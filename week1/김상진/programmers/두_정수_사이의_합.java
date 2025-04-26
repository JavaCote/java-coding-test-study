package week1.김상진.programmers;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 두_정수_사이의_합
 * Author      : sangxxjin
 * Date        : 2025. 4. 27.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 27.     sangxxjin               Initial creation
 */
public class 두_정수_사이의_합 {
	public long solution(int a, int b) {
		long answer = 0;
		if (a<=b){
			for (int i = a; i <= b; i++) {
				answer+=i;
			}
		}
		else{
			for (int i = b; i <= a; i++) {
				answer+=i;
			}
		}
		return answer;
	}
}

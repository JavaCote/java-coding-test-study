package week1.김상진.programmers;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 나머지가_1이_되는_수_찾기
 * Author      : sangxxjin
 * Date        : 2025. 4. 27.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 27.     sangxxjin               Initial creation
 */
public class 나머지가_1이_되는_수_찾기 {
	public int solution(int n) {
		int answer = 0;
		for (int i = 1; i < n; i++) {
			if (n%i==1){
				answer=i;
				break;
			}
		}
		return answer;
	}
}

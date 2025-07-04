package week7.김상진.programmers;

/**
 * PackageName : week7.김상진.programmers
 * FileName    : 예상_대진표
 * Author      : sangxxjin
 * Date        : 2025. 6. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 12.     sangxxjin               Initial creation
 */
public class 예상_대진표 {
	// 이기고 올라갔을때 순서는 항상  (a+1)/2
	// 5번 6번이 겨루면 누가 이기든 다음 대진표에서는 3번임
	class Solution
	{
		public int solution(int n, int a, int b)
		{
			int answer = 0;

			while (a != b) {
				a = (a + 1) / 2;
				b = (b + 1) / 2;
				answer++;
			}

			return answer;
		}
	}
}

package Week1.김누리.programmers;

/**
 * PackageName : Week1.김누리.programmers
 * FileName    : 하샤드_수
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 */
public class 하샤드_수 {
	public boolean solution(int x) {
		boolean answer = true;
		int harshad = 0;
		int tmp = x;

		while (tmp > 0) {
			harshad += tmp % 10; // 자리수 더하기
			tmp /= 10;
		}

		answer = x%harshad == 0 ? true : false;

		return answer;
	}

	public void call_solution(int x) {
		boolean answer = solution(x);
		System.out.println(answer);
	}
}

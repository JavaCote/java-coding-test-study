package Week1.김누리.programmers;

/**
 * PackageName : Week1.김누리.programmers
 * FileName    : 약수의_합
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 */

import java.util.stream.IntStream;

public class 약수의_합 {

	public int solution(int n) {
		return IntStream.rangeClosed(1, n)
			.filter(i -> n%i == 0 )
			.sum();
	}

	public void call_solution(int n) {
		int answer = solution(n);

		System.out.println(answer);
	}
}

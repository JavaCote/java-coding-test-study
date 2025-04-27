package Week1.김누리.programmers;

import java.util.stream.IntStream;

/**
 * PackageName : Week1.김누리.programmers
 * FileName    : 두_정수_사이의_합
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 * 2025. 04. 27.     김누리               Stream API 버전
 */
public class 두_정수_사이의_합 {
	public int solution(int a, int b) {
		//  Stream API 이용
		return IntStream.rangeClosed(a, b).sum();

		// Stream API 이용 X
	}

	public void call_solution(int a, int b) {
		int answer = solution(a, b);

		System.out.println(answer);
	}
}

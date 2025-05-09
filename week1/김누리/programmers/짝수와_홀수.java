package week1.김누리.programmers;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * PackageName : Week1.김누리.programmers
 * FileName    : 짝수와_홀수
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 */
public class 짝수와_홀수 {
	public String solution(int num) {
		//  Stream API 이용 버전
/*		return Stream.of(num)
			.map(n -> num%2 == 0 ? "Even": "Odd")
			.findFirst()
			.get();*/

		//  Stream API 이용하지 않은 버전
		return num%2 == 0 ? "Even" : "Odd";
	}

	public void call_solution(int num) {
		String answer = solution(num);

		System.out.println(answer);
	}
}

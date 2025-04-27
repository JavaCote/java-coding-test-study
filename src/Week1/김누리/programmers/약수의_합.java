package Week1.김누리.programmers;

/*
 * PackageName : Week1.김누리.programmers
 * FileName    : 약수의_합
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 * 2025. 04. 26.     김누리               Stream API 버전 작성
 * 2025. 04. 27.     김누리               Stream API을 이용하지 않는 버전 작성
 */

import java.util.stream.IntStream;

public class 약수의_합 {

	public int solution(int n) {
		//  Stream API 버전
/*		return IntStream.rangeClosed(1, n)
			.filter(i -> n%i == 0 )
			.sum();*/

		//  Stream API를 이용하지 않은 버전
		int answer = 0;

		for(int i = 1; i <= n; i++) {
			if(n%i == 0) {
				answer += i;
			}
		}

		return answer;
	}

	public void call_solution(int n) {
		int answer = solution(n);

		System.out.println(answer);
	}
}

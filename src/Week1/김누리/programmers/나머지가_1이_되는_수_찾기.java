package Week1.김누리.programmers;

import java.util.stream.IntStream;

/*
 * PackageName : Week1.김누리.programmers
 * FileName    : 나머지가_1이_되는_수_찾기
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 * 2025. 04. 27.     김누리               Stream API 버전 개발
 * 2025. 04. 27.     김누리               Stream API을 이용하지 않는 버전 개발
 */
public class 나머지가_1이_되는_수_찾기 {
	public int solution(int n) {
		//  Stream API 이용 버전
/*		return IntStream.rangeClosed(1,n)
			.filter(i -> n % i == 1)
			.min()
			.orElse(0);*/

		//  Stream API 이용하지 않은 버전
		int answer = 0;

		for(int i = 1; i <= n; i++ ) {
			if(n % i == 1) {
				answer = i;
				break; // ex) 10을 1, 2, 3 ~ 순차적으로 나눠 가면서 나머지가 1 인 값 중 최소값이 발견되는 경우 반복 종료.
			}
		}

		return answer;
	}

	public void call_solution(int n) {
		int answer = solution(n);
		System.out.println(answer);
	}
}

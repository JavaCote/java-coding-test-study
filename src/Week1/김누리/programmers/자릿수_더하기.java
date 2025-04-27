package Week1.김누리.programmers;

import java.util.stream.IntStream;

/**
 * PackageName : Week1.김누리.programmers
 * FileName    : 자릿수_더하기
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 * 2025. 04. 27.     김누리               Stream API 버전 작성
 * 2025. 04. 27.     김누리               Stream API을 이용하지 않는 버전 작성
 */

public class 자릿수_더하기 {
	 public int solution(int n) {
		 //  Stream API 이용 버전
/*		 return IntStream.iterate(n, i -> i > 0, i -> i / 10) // i가 0보다 클 경우, i를 10으로 나눈다
			 .map(i -> i % 10)
			 .sum();*/

		 //  Stream API 이용하지 않은 버전
		 int answer = 0;

		 while(n > 0) {
			 answer += n % 10;
			 n /= 10;
		 }
		 return answer;
	 }

	 public void call_solution(int n) {
		int answer = solution(n);

		System.out.println(answer);
	 }
}

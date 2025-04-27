package Week1.김누리.programmers;

import java.util.stream.IntStream;

/*
 * PackageName : Week1.김누리.programmers
 * FileName    : x만큼_간격이_있는_n개의_숫자
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 * 2025. 04. 27.     김누리               Stream API를 이용하지 않은 버전 작성
 * 2025. 04. 27.     김누리               Stream API를 이용하는 버전 작성
 */
public class x만큼_간격이_있는_n개의_숫자 {
	public long[] solution(int x, int n) {
		//  Stream API 이용 버전
/*		return IntStream.rangeClosed(1,n)
			.mapToLong(i -> (long)x*(i))
			.toArray();*/

		//  Stream API 이용하지 않는 버전
		long[] answer = new long[n];

		for (int i = 0; i < n; i++) {
			answer[i] = (long)x*(i+1);
		}
		return answer;
	}

	public void call_solution(int x, int n) {
		long[] answer = solution(x, n);

		for(long i : answer) {
			System.out.println(i);
		}
	}
}

package Week1.김누리.programmers;

import java.util.stream.Stream;

/**
 * PackageName : Week1.김누리.programmers
 * FileName    : 평균_구하기
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

public class 평균_구하기 {
	public double solution(int[] arr) {
		//  Stream API 이용 버전

		//  Stream API 이용하지 않은 버전
		double answer = 0;
		double size = arr.length;

		for(int i : arr) {
			answer += i;
		}

		answer /= size;

		return answer;
	}
}

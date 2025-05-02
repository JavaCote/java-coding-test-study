package Week1.김누리.programmers;

/**
 * PackageName : Week1.김누리.programmers
 * FileName    : 푸드_파이트_대회
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 */

/*
* 해석
* [1,3,4,6]의 경우
* [0] = 물 갯수는 1, 중앙값
* [1] = 1번 음식 : 3개, 1개는 잉여니 제외 => 구성 101
* [2] = 2번 음식 : 4개, 구성 => 1220221
* [3] = 3번 음식 : 6개, 구성 => 1223330333221
*
* answer = "1223330333221"
*
*/

public class 푸드_파이트_대회 {
	public String solution(int[] food) {
		String answer = "";
		StringBuilder left = new StringBuilder();

		// A vs B중 일단 A 부분만 먼저 구성
		for(int i = 0; i < food.length; i++) {

			//  food[0] 일때는 물, 1개만 있을 테니, i!=0일때만 돌린다고 가정
			if(i != 0 ) {
				//  food[i]의 값이 홀수이면 food[i] -1
				if(food[i]%2 == 1) food[i]--;

				//  food[i]의 값이 짝수이면 StringBuilder 조합 시작
				for(int j = 0; j < food[i]/2; j++) {
					left.append(i);
				}
			}
		}

		answer = left.toString();

		answer = answer + "0" + left.reverse().toString();

		return answer;
	}

	public void call_solution(int[] food) {
		String answer = solution(food);
	}
}

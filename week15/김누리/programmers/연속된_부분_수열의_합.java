package week15.김누리.programmers;

/**
 * PackageName : week15.김누리.programmers
 * FileName    : 연속된_부분_수열의_합
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 06.     김누리(NRKim)               Initial creation
 */

/*

시작점과 끝점을 선언

끝점의 위치를 추가해가며 더해가면 됨

*/

public class 연속된_부분_수열의_합 {
	public int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];
		int start = 0, end = 0; //  시작점 및 끝점
		int sum = sequence[0]; //  시퀀스 위치에 해당하는 값들을 더하는 변수

		int min = Integer.MAX_VALUE; //  최소 길이 비교용 변수

		while(end < sequence.length) {
			if(sum < k) {
				end++;
				if(end < sequence.length) sum += sequence[end]; //  끝점이 위치가 배열을 벗어나는지 체크
			} else {
				if (sum == k) {
					if((end - start) < min) {
						min = end - start; //  최소 거리값 계산.
						answer[0] = start; //  시작점
						answer[1] = end; //  끝점
					}
				}

				sum -= sequence[start]; //  시작점 변동을 위해 시작점 만큼 뺌
				start++; // 시작점 변경

				//  시작점을 옮긴 후 위치 확인
				if (start > end && start < sequence.length) {
					end = start;
					sum = sequence[start];
				}
			}
		}

		return answer;
	}
}

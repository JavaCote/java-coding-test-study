package week10.김누리.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PackageName : week10.김누리.programmers
 * FileName    : 디스크_컨트롤러
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-03
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 03.     김누리(NRKim)               Initial creation
 */

/*

for(int[] job : jobs) {
    job[0] => 시점
    job[1] => 시작 되는 작업 내용
}

jobs =
[
    [0, 3],
    [1, 9],
    [3, 5]
]

PriorityQueue 채용

1.  0ms 시점에 3ms 가 소요 되는 작업 << queue에 입력 << 작업 진행
2.  1ms 시점에 9ms 가 소요 되는 작업 << queue에 입력
3.  2ms 시점에 1번 작업 진행 중.
4.  3ms 시점에 1번 작업 종료 << poll() << 2번 작업 진행 <<  5ms가 소요되는 작업 << queue에 입력

~ 이하 생략 ~

job[1] 을 우선순위로 두고 빨리 끝나는 작업부터 처리 시키면 됨


*/

public class 디스크_컨트롤러 {
	public int solution(int[][] jobs) {
		int answer = 0;
		//  우선순위 큐. job[1]을 기준으로 정렬 예정
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

		int time = 0, idx = 0, cnt = 0;
		int len = jobs.length; // 총 요청 작업 갯수

		//  시점 기준으로 정렬
		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

		while(cnt < len) {
			//  현재 들어온 모든 작업 내용 큐에 추가
			while (idx < len && jobs[idx][0] <= time) {
				pq.offer(jobs[idx++]);
			}

			//  등록된 작업이 없다면?
			if(pq.isEmpty()) {
				time = jobs[idx][0];
			} else {
				int[] job = pq.poll();
				time += job[1]; //  처리 시간
				answer += time - job[0]; //  처리시간 (ms) - 현재 시점 (ms)
				cnt++;
			}
		}

		return answer / len;
	}
}

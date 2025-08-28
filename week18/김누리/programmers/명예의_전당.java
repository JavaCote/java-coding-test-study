package week18.김누리.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * PackageName : week18.김누리.programmers
 * FileName    : 명예의_전당
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-28
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 28.     김누리(NRKim)               Initial creation
 */

/*

  배열 사이즈 = k
  7 < 취득 점수 배열 : [score] < 1000
  0 < 점수 < 2000

  Queue 이용
  Queue의 사이즈 == k ? pop ==> queue의 가장 처음 들어온거 out

  score[0] queue && answer[0]에 입력, min 변수에도 입력
  score[1] > min보다 작으면 min 갱신
                      min 보다 크면 queue에 입력


  Case 1
    1일차 : score[0] == 10,
            queue={10},
            min = 10 answer = {10}
    2일차 : score[1] == 100,
            queue={10,100},
            min = 10 answer = {10,10}
    3일차 : score[2] == 20,
            queue={10,20,100},
            min = 10 answer = {10,10,10}  >> queue.size > K(3)
    4일차 : score[3] == 150,
            queue={20,100,150}
            min = 20 answer = {10,10,10,20}
    5일차 : score[4] == 1,
            queue={20,100,150}
            min = 20 answer = {10,10,10,20,20}
    6일차 : score[6] == 100,
            queue={100,100,150}
            min = 20 answer = {10,10,10,20,20,100}
    7일차 : score[7] == 200,
            queue={100,150,200}
            min = 20 answer = {10,10,10,20,20,100,100}

*/


public class 명예의_전당 {
	public List<Integer> solution(int k, int[] score) {
		List<Integer> answer = new ArrayList<>();
		PriorityQueue<Integer> hall = new PriorityQueue<>();

		for (int s : score) {
			if(hall.size() < k) {
				hall.add(s);
			} else {
				if(s > hall.peek()) {
					hall.poll();
					hall.add(s);
				}
			}
			answer.add(hall.peek());
		}

		return answer;
	}
}

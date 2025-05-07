package week2.김누리.programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * PackageName : week2.김누리.programmers
 * FileName    : 기능개발
 * Author      : 김누리
 * Date        : 2025-05-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 05.     김누리               Initial creation
 * 2025. 05. 05.     김누리               챗GPT 도움 받아 1차적인 코딩을 진행하였기 때문에,
 * 											   2025-05-07에 다시 풀어 볼 예정
 * 2025. 05. 07.     김누리               Queue를 통한 풀이 완료
 */
public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> progQue = new LinkedList<>();  //  작업 진도가 들어갈 큐
		Queue<Integer> speedQue = new LinkedList<>(); //  작업 속도가 들어갈 큐
		List<Integer> comp = new LinkedList<>(); //  작업 결과가 들어갈 큐

		for (int progresse : progresses) progQue.offer(progresse); //  작업 진도 큐 구성
		for (int speed : speeds) speedQue.offer(speed); //  작업 속도 구성

		//  작업 진도를 계속 진행
		while(!progQue.isEmpty()) {
			int size = progQue.size();

			for(int i = 0; i < size; i++) {
				int spent = speedQue.poll();
				int current_prog = progQue.poll() + spent;

				progQue.offer(current_prog);
				speedQue.offer(spent);
			}

			int deploy = 0; // 배포 가능 갯수

			while(!progQue.isEmpty() && progQue.peek() >= 100) {
				progQue.poll();
				speedQue.poll();
				deploy++;
			}

			//  배포 가능한 갯수 만큼
			if(deploy > 0) {
				comp.add(deploy);
			}
		}

		int[] answer = new int[comp.size()];
		int idx = 0;

		for(int i : comp) {
			answer[idx++] = i;
		}

		return answer;
	}
}

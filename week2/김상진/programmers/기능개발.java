package week2.김상진.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 기능개발
 * Author      : sangxxjin
 * Date        : 2025. 5. 8.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangxxjin               Initial creation
 */
public class 기능개발 {
	class Solution {
		public List<Integer> solution(int[] progresses, int[] speeds) {
			Queue<Integer> queue = new LinkedList<>();
			List<Integer> answer = new ArrayList<>();

			for(int i=0; i<progresses.length; i++){
				queue.add((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
			}
			while(!queue.isEmpty()){
				int count = 1;
				int min = queue.poll();
				while(!queue.isEmpty() && (queue.peek()<=min)){
					queue.poll();
					count++;
				}
				answer.add(count);
			}
			return answer;
		}
	}
}

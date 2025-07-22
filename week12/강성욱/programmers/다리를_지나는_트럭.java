package week12.강성욱.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week12.강성욱.programmers
 * FileName    : 다리를_지나는_트럭
 * Author      : Baekgwa
 * Date        : 2025-07-21
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-21     Baekgwa               Initial creation
 */
public class 다리를_지나는_트럭 {

	class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {
			Queue<Integer> bridge = new LinkedList<>();
			int time = 0;
			int currentWeight = 0;
			int idx = 0;

			for(int i = 0; i < bridge_length; i++) {
				bridge.offer(0);
			}

			while(idx < truck_weights.length) {
				time++;

				currentWeight -= bridge.poll();

				if(currentWeight + truck_weights[idx] <= weight) {
					bridge.offer(truck_weights[idx]);
					currentWeight += truck_weights[idx];
					idx++;
				} else {
					bridge.offer(0);
				}
			}

			time += bridge_length;

			return time;
		}
	}
}

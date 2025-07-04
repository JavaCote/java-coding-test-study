package week10.강성욱.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PackageName : week10.강성욱.programmers
 * FileName    : 호텔_대실
 * Author      : Baekgwa
 * Date        : 2025-07-03
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-03     Baekgwa               Initial creation
 */
public class 호텔_대실 {
	class Solution {
		public int solution(String[][] book_time) {
			int max = book_time.length;
			int[][] times = new int[max][2];

			for(int i=0; i<max; i++) {
				times[i][0] = convertToMin(book_time[i][0]);
				times[i][1] = convertToMin(book_time[i][1]);
			}

			Arrays.sort(times, (a, b) -> {
				return Integer.compare(a[0], b[0]);
			});

			PriorityQueue<Integer> room = new PriorityQueue<>();

			int nowTime = 0;
			int cnt = 0;

			for(int[] time : times){

				if(!room.isEmpty() && room.peek() <= time[0]) {
					room.poll();
				}

				room.offer(time[1] + 10);
			}

			return room.size();
		}

		private static int convertToMin(String time) {
			String[] times = time.split(":");
			return (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
		}
	}
}

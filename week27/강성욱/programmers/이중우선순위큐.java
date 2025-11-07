package week27.강성욱.programmers;

import java.util.TreeMap;

/**
 * PackageName : week27.강성욱.programmers
 * FileName    : 이중우선순위큐
 * Author      : Baekgwa
 * Date        : 25. 11. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 6.     Baekgwa               Initial creation
 */
public class 이중우선순위큐 {
	class Solution {
		public int[] solution(String[] operations) {
			TreeMap<Integer, Integer> map = new TreeMap<>();

			for (String op : operations) {
				String[] parts = op.split(" ");
				String order = parts[0];
				int num = Integer.parseInt(parts[1]);

				if (order.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else if (order.equals("D")) {
					if(map.isEmpty()) continue;

					int key = (num == 1) ? map.lastKey() : map.firstKey();
					int count = map.get(key); //해당 숫자가 몇개 있는지 확인

					if (count == 1) map.remove(key);
					else map.put(key, count - 1);
				}
			}

			if (map.isEmpty()) return new int[]{0, 0};
			return new int[]{map.lastKey(), map.firstKey()};
		}
	}
}

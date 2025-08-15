package week16.강성욱.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week16.강성욱.programmers
 * FileName    : 의상
 * Author      : Baekgwa
 * Date        : 2025-08-14
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-14     Baekgwa               Initial creation
 */
public class 의상 {
	class Solution {
		public static int cnt;

		public int solution(String[][] clothes) {
			Map<String, Integer> map = new HashMap<>(); //key : 의상 종류, value = 의상 이름 list

			for(String[] cloth : clothes) {
				String clothType = cloth[1];
				map.put(clothType, map.getOrDefault(clothType, 0) + 1);
			}

			int result = 1;
			for(int cnt : map.values()) {
				result *= cnt + 1;
			}

			return result - 1;
		}
	}
}

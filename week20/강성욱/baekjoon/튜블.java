package week20.강성욱.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PackageName : week20.강성욱.baekjoon
 * FileName    : 튜블
 * Author      : Baekgwa
 * Date        : 2025-09-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-11     Baekgwa               Initial creation
 */
public class 튜블 {
	class Solution {
		public int[] solution(String s) {
			Set<Integer> visited = new HashSet<>();
			List<Integer> result = new ArrayList<>();

			String[] sArray = s.substring(2, s.length() - 2).split("\\},\\{");
			Arrays.sort(sArray, Comparator.comparingInt(String::length));

			for(String str : sArray) {
				String[] strArray = str.split(",");
				for(String strNumber : strArray) {
					int number = Integer.parseInt(strNumber);
					if(!visited.contains(number)) {
						visited.add(number);
						result.add(number);
					}
				}
			}

			int[] list = new int[result.size()];
			for(int i=0; i<result.size(); i++) {
				list[i] = result.get(i);
			}

			return list;
		}
	}
}

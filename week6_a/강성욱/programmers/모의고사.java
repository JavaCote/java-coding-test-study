package week6_a.강성욱.programmers;

import java.util.ArrayList;

/**
 * PackageName : week6_a.강성욱.programmers
 * FileName    : 모의고사
 * Author      : Baekgwa
 * Date        : 2025-06-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-06     Baekgwa               Initial creation
 */
public class 모의고사 {

	class Solution {
		private static final int[] oneAnswer = {1, 2, 3, 4, 5}; //5
		private static final int[] twoAnswer = {2, 1, 2, 3, 2, 4, 2, 5}; //8
		private static final int[] threeAnswer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10

		public int[] solution(int[] answers) {
			ArrayList<int[]> result = new ArrayList<>(); //[n번 수포자, 현재점수];
			for(int i=1; i<=3; i++) {
				result.add(new int[]{i, 0});
			}

			int testCount = 0;
			for(int answer : answers) {
				if(oneAnswer[testCount%5] == answer){
					int[] ints = result.get(0);
					result.set(0, new int[]{ints[0], ints[1] + 1});
				}
				if(twoAnswer[testCount%8] == answer){
					int[] ints = result.get(1);
					result.set(1, new int[]{ints[0], ints[1] + 1});
				}

				if(threeAnswer[testCount%10] == answer){
					int[] ints = result.get(2);
					result.set(2, new int[]{ints[0], ints[1] + 1});
				}
				testCount++;
			}

			result.sort((a, b) -> Integer.compare(b[1], a[1]));
			int maxValue = result.get(0)[1];

			return result.stream()
				.filter(value -> value[1] == maxValue)
				.mapToInt(value -> value[0])
				.toArray();
		}
	}
}
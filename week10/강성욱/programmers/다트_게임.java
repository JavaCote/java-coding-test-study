package week10.강성욱.programmers;

/**
 * PackageName : week10.강성욱.programmers
 * FileName    : 다트_게임
 * Author      : Baekgwa
 * Date        : 2025-07-02
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-02     Baekgwa               Initial creation
 */
public class 다트_게임 {
	class Solution {
		public int solution(String dartResult) {
			int[] results = new int[3];
			int idx = 0;
			int round = 0;

			while (idx < dartResult.length()) {
				int point = 0;

				// 10점 처리
				if (dartResult.charAt(idx) == '1' &&
					idx + 1 < dartResult.length() && dartResult.charAt(idx + 1) == '0') {
					point = 10;
					idx += 2;
				} else {
					point = dartResult.charAt(idx++) - '0';
				}

				// 보너스 처리
				char bonus = dartResult.charAt(idx++);
				if (bonus == 'S') {
					results[round] = (int) Math.pow(point, 1);
				} else if (bonus == 'D') {
					results[round] = (int) Math.pow(point, 2);
				} else if (bonus == 'T') {
					results[round] = (int) Math.pow(point, 3);
				}

				if (idx < dartResult.length() &&
					(dartResult.charAt(idx) == '*' || dartResult.charAt(idx) == '#')) {
					char option = dartResult.charAt(idx++);
					if (option == '*') {
						results[round] *= 2;
						if (round > 0) {
							results[round - 1] *= 2;
						}
					} else if (option == '#') {
						results[round] *= -1;
					}
				}
				round++;
			}

			return results[0] + results[1] + results[2];
		}
	}
}

package week17.강성욱.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week17.강성욱.programmers
 * FileName    : 숫자_카드_나누기
 * Author      : Baekgwa
 * Date        : 2025-08-19
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-19     Baekgwa               Initial creation
 */
public class 숫자_카드_나누기 {
	//arrayA 의 약수를 모두 구하고
	//arrayB 의 약수를 모두 구하기?
	// 타임아웃 걸리면, 약수 구하는걸 조금 바꿀려고 했는데 ㄱㅊ네

	class Solution {
		public int solution(int[] arrayA, int[] arrayB) {
			int result = 0;
			List<Integer> dirtnA = dirtn(arrayA);
			List<Integer> dirtnB = dirtn(arrayB);

			//A 배열의 약수 조합들 중, B가 나눠지는지 확인
			//dirtnA 는 가장 큰순서대로 정렬되어있음. 즉, 먼저 안나눠지는게 발생하면 그게 가장 큰값이니, 바로 끝내면됨.
			for(int now : dirtnA) {
				if(!canDiv(arrayB, now)) {
					result = Math.max(result, now);
					break;
				}
			}

			//B 배열의 약수 조합들 중, A가 나눠지는지 확인
			for(int now : dirtnB) {
				if(!canDiv(arrayA, now)) {
					result = Math.max(result, now);
					break;
				}
			}

			return result;
		}

		// 숫자 now 로 배열들 중, 하나라도 나눠진다면 return true
		private boolean canDiv(int[] array, int now) {
			for(int a : array) {
				if(a % now == 0) return true;
			}
			return false;
		}

		private List<Integer> dirtn(int[] array) {
			List<Integer> result = new ArrayList<>();

			Arrays.sort(array);
			for(int start = array[0]; start > 1; start--) {
				boolean flag = true;

				for(int i=0; i<array.length; i++) {
					if(array[i] % start != 0) {
						flag = false;
						break;
					}
				}

				if(flag) {
					result.add(start);
				}
			}

			result.sort(Collections.reverseOrder());
			return result;
		}
	}
}

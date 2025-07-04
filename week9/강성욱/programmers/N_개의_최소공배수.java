package week9.강성욱.programmers;

/**
 * PackageName : week9.강성욱.programmers
 * FileName    : N_개의_최소공배수
 * Author      : Baekgwa
 * Date        : 2025-06-25
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-25     Baekgwa               Initial creation
 */
public class N_개의_최소공배수 {
	// 2중 반복문으로 풀면?
	// 가장 큰 공배수일떄?
	// [99, 98, 97, 96 ... 50] 정도 까지하면 가장 큰 공배수일듯?
	// 해봣자 1백만 안될듯?
	// 1백만 반복 x 15개 반복(약수인지 확인)
	// 문제없는디?

	class Solution {
		public int solution(int[] arr) {
			int result = 0;

			int val = 1;
			while(result == 0) {
				boolean isAllOk = true;

				for(int i=0; i<arr.length; i++) {
					if(val % arr[i] == 0) continue;

					isAllOk = false;
					break;
				}

				if(isAllOk) result = val;

				val++;
			}

			return result;
		}
	}
}

package week10.김누리.programmers;

/**
 * PackageName : week10.김누리.programmers
 * FileName    : 제일_작은_수_제거하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-30
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 30.     김누리(NRKim)               Initial creation
 */

public class 제일_작은_수_제거하기 {
	public int[] solution(int[] arr) {

		if(arr.length == 1) {
			arr[0] = -1;
			return arr;
		}

		int minIdx = 0;

		for (int i = 0 ; i < arr.length; i++) {
			if(arr[minIdx] > arr[i]) {
				minIdx = i;
			}
		}

		int[] result = new int[arr.length - 1];
		int idx = 0;

		for (int i = 0 ; i < arr.length; i++) {
			if(i != minIdx ) {
				result[idx++] = arr[i];
			}
		}

		return result;
	}
}

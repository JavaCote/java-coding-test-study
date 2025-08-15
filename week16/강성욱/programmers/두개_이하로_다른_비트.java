package week16.강성욱.programmers;

/**
 * PackageName : week16.강성욱.backjoon
 * FileName    : 두개_이하로_다른_비트
 * Author      : Baekgwa
 * Date        : 2025-08-13
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-13     Baekgwa               Initial creation
 */
public class 두개_이하로_다른_비트 {
	class Solution {
		public long[] solution(long[] numbers) {
			//String 으로 바꾸면서 2진화시키고
			//뒤에서부터 찾으면서 0인걸 1로 변경하면 될듯?
			//만약, 전부다 1이면? 맨앞에 1 추가해야겠네
			// 는, 2개까지 다른거 허용이니깐 그렇게 하면 안됨.
			// 1 -> 10 으로 바꿔야되네

			long[] result = new long[numbers.length];

			for(int idx=0; idx<numbers.length; idx++) {
				result[idx] = convert(numbers[idx]);
			}

			return result;
		}

		private long convert(Long num) {
			if ((num & 1) == 0) {
				return num + 1;
			}

			String binary = Long.toBinaryString(num);
			char[] bits = binary.toCharArray();
			boolean changed = false;

			// 뒤에서부터 0 찾기
			for (int i = bits.length - 2; i >= 0; i--) {
				if (bits[i] == '0') {
					bits[i] = '1';
					bits[i + 1] = '0';
					changed = true;
					break;
				}
			}

			if (!changed) {
				return Long.parseLong("10" + binary.substring(1), 2);
			}

			return Long.parseLong(new String(bits), 2);
		}
	}
}

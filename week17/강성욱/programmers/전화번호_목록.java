package week17.강성욱.programmers;

import java.util.Arrays;

/**
 * PackageName : week17.강성욱.programmers
 * FileName    : 전화번호_목록
 * Author      : Baekgwa
 * Date        : 2025-08-21
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-21     Baekgwa               Initial creation
 */
public class 전화번호_목록 {
	class Solution {
		public boolean solution(String[] phone_book) {
			// 정렬해서 되는지 테스트
			// String[] test = new String[]{ "11", "111", "1" };
			// Arrays.sort(test);
			// for(int i=0; i<test.length; i++) {
			//     System.out.print(test[i] + ", ");
			// }

			Arrays.sort(phone_book);
			for(int i=0; i<phone_book.length - 1; i++) {
				if(phone_book[i + 1].startsWith(phone_book[i])) return false;
			}

			return true;
		}
	}
}

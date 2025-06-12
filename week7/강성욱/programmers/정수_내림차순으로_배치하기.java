package week7.강성욱.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week7.강성욱.programmers
 * FileName    : 정수_내림차순으로_배치하기
 * Author      : Baekgwa
 * Date        : 2025-06-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-11     Baekgwa               Initial creation
 */
public class 정수_내림차순으로_배치하기 {
	// long 을 각 자리수로 쪼개야됨.
	// long -> String -> char -> 정렬 -> 합쳐서 String -> long 하면 될듯?
	class Solution {
		public long solution(long n) {
			String str = String.valueOf(n);
			List<Character> list = new ArrayList<>();
			for(char c : str.toCharArray()){
				list.add(c);
			}
			Collections.sort(list, Collections.reverseOrder());

			str = "";
			for(char c : list) {
				str += c;
			}

			return Long.parseLong(str);
		}
	}
}

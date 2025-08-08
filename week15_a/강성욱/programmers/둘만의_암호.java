package week15_a.강성욱.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PackageName : week15_a.강성욱.programmers
 * FileName    : 둘만의_암호
 * Author      : Baekgwa
 * Date        : 2025-08-08
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-08     Baekgwa               Initial creation
 */
public class 둘만의_암호 {
	class Solution {
		//     public String solution(String s, String skip, int index) {
		//         //skip 확인용 set.
		//         //set에 들어있으면, 스킵해야함
		//         Set<Character> skipSet = new HashSet<>();
		//         for(Character c : skip.toCharArray()) {
		//             skipSet.add(c);
		//         }

		//         StringBuilder sb = new StringBuilder();

		//         for(Character c : s.toCharArray()) {
		//             if(skipSet.contains(c)) {
		//                 sb.append(c);
		//                 continue;
		//             }

		//             sb.append(convertByIndex(c, index));
		//         }

		//         return sb.toString();
		//     }

		//     // index 만큼 c를 미루는 메소드
		//     // z + 1(index) => a 가 되어야함.
		//     // c = a
		//     // c - 'a' + index % 26
		//     // a b c d e f g h i j k l m n o p q r s t u v w x y z //26개네
		//     private char convertByIndex(Character C, int index) {
		//         char c = C.charValue();
		//         return (char)((c-'a'+index)%26 + 'a');
		//     }

		//아 문제 잘못읽음 ㅠㅜ
		public String solution(String s, String skip, int index) {
			List<Character> aplList = new ArrayList<>();

			Set<Character> skipSet = new HashSet<>();
			for(Character c : skip.toCharArray()) {
				skipSet.add(c);
			}

			for(char c = 'a'; c <= 'z'; c++) {
				if(skipSet.contains(c)) continue;
				aplList.add(c);
			}

			StringBuilder sb = new StringBuilder();
			for(char c : s.toCharArray()) {
				sb.append(convertByIndex(c, index, aplList));
			}

			return sb.toString();
		}

		private char convertByIndex(char c, int index, List<Character> aplList) {
			int nowIdx = aplList.indexOf(c);
			int convertedIdx = (nowIdx + index) % aplList.size();
			return aplList.get(convertedIdx);
		}
	}
}

package week14_a.강성욱.programmers;

import java.util.Arrays;

/**
 * PackageName : week14_a.강성욱.programmers
 * FileName    : 대충_만든_자판
 * Author      : Baekgwa
 * Date        : 2025-08-01
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-01     Baekgwa               Initial creation
 */
public class 대충_만든_자판 {
	// 완탐으로 keymap 을 char 별로 확인해도 되긴 할듯?
	// 근데, A, B, C ... 등을 최적 몇번만에 해결 가능한지 미리 구해두면 더 좋을듯?
	// keymap = 최대 100개 * 100번 = 10,000

	class Solution {
		public int[] solution(String[] keymap, String[] targets) {
			int[] optimize = new int['Z' - 'A' + 1];
			Arrays.fill(optimize, -1);

			for(String nowKey : keymap) {
				for(int index=0; index < nowKey.length(); index++) {
					char nowChar = nowKey.charAt(index);

					if(optimize[nowChar - 'A'] == -1) optimize[nowChar - 'A'] = index + 1;
					else if(optimize[nowChar - 'A'] > index + 1) optimize[nowChar - 'A'] = index + 1;
				}
			}

			// for(int value : optimize) {
			//     System.out.print(value);
			//     System.out.print("\n");
			// }


			// targets iter 돌면서 출력하기
			int[] result = new int[targets.length];
			for(int i=0; i<targets.length; i++) {
				for(char now : targets[i].toCharArray()) {

					//목표 문자열이 없다면, optimze 에 -1 이 들어있다면, -1 return
					if(optimize[now - 'A'] == -1) {
						result[i] = -1;
						break;
					}
					result[i] += optimize[now - 'A'];
				}
			}

			return result;
		}
	}
}

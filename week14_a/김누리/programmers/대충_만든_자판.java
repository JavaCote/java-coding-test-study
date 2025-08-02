package week14_a.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week14_a.김누리.programmers
 * FileName    : 대충_만든_자판
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-02
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 02.     김누리(NRKim)               Initial creation
 */

public class 대충_만든_자판 {
	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		Map<Character,Integer> map = new HashMap<>(); // 몇번 눌렸는지 카운팅용

		for(String k : keymap) {
			for(int i = 0; i < k.length(); i++) {
				char c = k.charAt(i);

				map.put(c,Math.min(map.getOrDefault(c,Integer.MAX_VALUE),i+1));
			}
		}

		for(int i = 0; i < targets.length; i++) {
			int sum = 0;
			for(char c : targets[i].toCharArray()) {
				if(!map.containsKey(c)) {
					sum = -1;
					break;
				}
				sum += map.get(c);
			}

			answer[i] = sum;
		}


		return answer;
	}
}

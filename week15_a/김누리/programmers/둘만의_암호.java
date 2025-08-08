package week15_a.김누리.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week15_a.김누리.programmers
 * FileName    : 둘만의_암호
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-08
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 08.     김누리(NRKim)               Initial creation
 */

/*
s = a u k k s
skip = w b q d
index = 5

변환 시작

a + 5 >  c e f g h
u + 5 >  v x y z a
k + 5 >  l m n o p
k + 5 >  l m n o p
s + 5 >  t u v x y

*/

public class 둘만의_암호 {
	public String solution(String s, String skip, int index) {
		String answer = "";
		Set<Character> skipped = new HashSet<>(); //  스킵용 문자열
		char[] ch = s.toCharArray(); //  문자열 쪼개기
		StringBuilder sb = new StringBuilder();


		for(char c : skip.toCharArray()) {
			skipped.add(c);
		}

		//  로직 시작
		for(char c : ch) {
			//  진행 횟수
			int cnt = 0;

			while(cnt < index) {
				c++;

				//  z 넘어가면 a 로
				if( c > 'z') {
					c = 'a';
				}

				//  스킵 문자열에 포함되는지 확인
				if(skipped.contains(c)) {
					continue;
				}

				cnt++;
			}
			sb.append(c);

		}

		return sb.toString();
	}
}

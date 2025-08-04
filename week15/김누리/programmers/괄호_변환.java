package week15.김누리.programmers;

/**
 * PackageName : week15.김누리.programmers
 * FileName    : 괄호_변환
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-04
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 04.     김누리(NRKim)               Initial creation
 */

/*
p가 비어있다? ==> p 그대로 반환

case 1 :
p를 쪼갬 => {"(", "(", ")", "(", ")", ")", "(", ")"};
u = "(()())()", v = ""

case 2 : ")("
u = "()" v = ""

case 3 : "()))((()"
u = ()() v = ))((
u = ()()() v = )(
u = ()(())() v = ""

solution (v) 로 해서 재귀 돌림

() 상태인지 )( 상태인지 체크하는 메소드 필요

)( 상태면 appand 하는 메소드 작성

*/

public class 괄호_변환 {
	public String solution(String p) {

		if(p.isEmpty()) return p; // p가 빈문자면 p 반환

		String[] uv = splitToBalanced(p); //  p를 쪼개기
		String u = uv[0];
		String v = uv[1];

		if(isCollect(u)) return u + solution(v);

		return "(" + solution(v) + ")" + reverse(u.substring(1,u.length()-1));
	}

	//  올바른 () 문자
	public String[] splitToBalanced(String p) {
		int left = 0, right = 0;
		int idx = 0;

		//  시작 위치가 p의 끝자락에 도달하기 전 까지 반복
		while(left < p.length()) {
			char c = p.charAt(idx); //  해당 위치의 글자
			if( c == '(' ) left++;
			else right++;

			idx++;

			if(left == right) break; // 균형잡힌 괄호 완성
		}

		String u = p.substring(0,idx);
		String v = p.substring(idx);

		return new String[]{u,v};
	}

	public boolean isCollect(String s) {
		int cnt = 0;

		for(char c : s.toCharArray()) {
			if(c == '(') cnt++;
			else cnt--;

			if(cnt < 0) return false;
		}

		return true;
	}

	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();

		for(char c : s.toCharArray()) {
			sb.append(c == '(' ? ')' : '(');
		}

		return sb.toString();
	}
}

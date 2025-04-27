package Week1.김누리.programmers;

/*
 * PackageName : Week1.김누리.programmers
 * FileName    : 문자열_내_p와_y의_개수
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 */
public class 문자열_내_p와_y의_개수 {
	public boolean solution(String s) {
		boolean answer = true;
		int pCnt = 0;
		int yCnt = 0;
		String[] tmp = s.split("");

		for(String s2 : tmp) {
			if(s2.equalsIgnoreCase("p")) pCnt++;
			if(s2.equalsIgnoreCase("y")) yCnt++;
		}

		if(pCnt != yCnt) answer = false;

		return answer;
	}

	public void call_solution(String s) {
		boolean answer = solution(s);

		System.out.println(answer);
	}
}

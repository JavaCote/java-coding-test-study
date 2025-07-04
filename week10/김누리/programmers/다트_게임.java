package week10.김누리.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PackageName : week10.김누리.programmers
 * FileName    : 다트_게임
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-01
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 01.     김누리(NRKim)               Initial creation
 */

/*

S = 1제곱
D = 2제곱
T = 3제곱

* ==> 직전에 얻은 점수2배 && 현재 얻은 점수 2배
# ==> -화

*는 중첩 가능
*#도 중첩 가능

1S + 2D* + 3T

1S  => 1^1*2 ==>  2
2D* => 2^2*2 ==>  8
3T  => 3^3   ==> 27

total ==> 2 + 8 +27 ==> 37

1D2S#10S
1D + 2S# + 10S
1D  => 1^2        ==>  1
2S# => 2^1 * (-1) ==> -2
10S => 10^1       ==> 10

total ==> 1 + (-2) + 10 ==>9

그러면 정규식을 이용해 보자.

for(String s : arr) {
    switch (s) {
        case "*" :
           //  로직 구현
        case "#" :
           //  로직 구현
        case "S" :
           //  N^1
        case "D" :
           //  N^2
        case "T" :
           //  N^3
        default :
           //  로직 구현
    }
}

*/
public class 다트_게임 {
	public int solution(String dartResult) {
		int answer = 0;
		//  정규식 설정
		//  숫자, SDT(보너스), *#(옵션)
		Pattern p = Pattern.compile("(10|\\d)([SDT])([*#]?)");
		Matcher m = p.matcher(dartResult);

		List<String[]> parsed = new ArrayList<>();

		//  설정한 정규식 탐색
		while(m.find()) {
			String[] tmp = new String[3];
			tmp[0] = m.group(1);
			tmp[1] = m.group(2);
			tmp[2] = m.group(3);

			parsed.add(tmp);
		}

		int[] scores = new int[3];

		int idx = 0;

		for(String[] arr : parsed) {
			int point = Integer.parseInt(arr[0]); // 점수
			String bonus = arr[1]; // 보너스
			String opt = arr[2]; // 옵션

			switch(bonus) {
				case "S" :
					point = (int)Math.pow(point,1);
					break;
				case "D" :
					point = (int)Math.pow(point,2);
					break;
				case "T" :
					point = (int)Math.pow(point,3);
					break;
			}

			if (opt.equals("*")) {
				point *= 2;

				if(idx > 0) scores[idx-1] *= 2; // 직전 점수도 2배
			} else if (opt.equals("#")) {
				point *= -1;
			}

			scores[idx++] = point;
		}

		for(int s : scores) {
			answer += s;
		}

		return answer;
	}
}

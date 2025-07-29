package week14.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week14.김누리.programmers
 * FileName    : 성격_유형_검사하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-29
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 29.     김누리(NRKim)               Initial creation
 */

/*
survey = 선택지
예 = ["AN", "CF", "MJ", "RT", "NA"]

choices = 점수 (1 ~ 7 까지, 매우 비동의 ~ 매우 동의)
예 = [5,3,2,7,5]

arr1 = {R,T,C,F,J,M,A,N};

map1 = {
    R = 0,
    T = 0,
    C = 0,
    F = 0,
    J = 0,
    M = 0,
    A = 0,
    N = 0,
}
map2 = {
    1 = 3
    2 = 2
    3 = 1
    4 = 0
    5 = 1
    6 = 2
    7 = 3
}

예 survey[0] = AN ==> A : 비동의 N : 동의
choices[0] => 5 ==> 긍정, 5(약간 동의) 이므로 N + 1
choices[1] => 3 ==> 부정, 3(약간 부정) 이므로 C + 1
choices[2] => 2 ==> 부정, 2(비동의)    이므로 M + 2
choices[3] => 7 ==> 긍정, 7(매우 동의) 이므로 T + 3
choices[4] => 5 ==> 긍정, 5(약간 동의) 이므로 A + 1

map1 = {
    R = 0,
    T = 3,
    C = 1,
    F = 0,
    J = 0,
    M = 2,
    A = 1,
    N = 1,
}

순번대로
Rpoint vs Tpoint => T가 우세
Cpoint vs Fpoint => C가 우세
Jpoint vs Mpoint => M가 우세
Apoint vs Npoint => A와 N이 동점 ==> 사전순번에 따라 A를 선택


*/

public class 성격_유형_검사하기 {
	public String solution(String[] survey, int[] choices) {
		String answer = "";

		//  선택지 배열 사전
		String[] selection = {"R","T","C","F","J","M","A","N"};

		//  성격 체크용 배열 사전
		String[][] check = {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};

		//  득점용 계산 배열 idx = 0인 경우 0으로 해서 자리수 맞춤
		int[] point = {0, 3, 2, 1, 0, 1, 2, 3};

		//  각 선택지당 포인트 계산용 배열
		Map<String, Integer> map = new HashMap<>();

		//  유형별 획득 점수 초기화
		for(String c : selection) {
			map.put(c,0);
		}

		//  득점 계산
		for(int i = 0; i < survey.length; i++) {
			String[] tmp = survey[i].split("");
			int p = choices[i];

			if(p<= 3) {
				map.put(tmp[0],map.getOrDefault(tmp[0],0)+point[p]);
			}

			if(p >= 5) {
				map.put(tmp[1],map.getOrDefault(tmp[1],0)+point[p]);
			}
		}

		StringBuilder sb = new StringBuilder();

		//  성격 유형 조합
		for(String[] c : check) {
			if(map.get(c[0]) > map.get(c[1])) sb.append(c[0]);
			else if(map.get(c[0]) < map.get(c[1])) sb.append(c[1]);
			else sb.append(c[0]);
		}

		answer = sb.toString();

		return answer;
	}
}

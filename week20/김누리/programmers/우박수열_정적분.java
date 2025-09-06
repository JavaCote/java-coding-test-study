package week20.김누리.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week20.김누리.programmers
 * FileName    : 우박수열_정적분
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 06.     김누리(NRKim)               Initial creation
 */

/*

GPT 도움 받은 부분 :
	1.  정적분 시, idx 구하는 공식

1.  list<Long>에 콜라츠 공식으로 값 설정
2.  구간 별로 1에서 구한 넓이 계산
3.  이후 누적 합 계산
4.  결과값 정리

특별한 알고리즘은 불필요, 단순 구현이지만 정적분 공식 및 index 계산 공식에서 해맴..
*/

public class 우박수열_정적분 {
	public double[] solution(int k, int[][] ranges) {
		List<Long> temp = new ArrayList<>();
		long val = k;
		temp.add(val);

		//  콜라츠 추측 연산
		while( val > 1 ){
			if((val & 1L) == 1L) val = (val * 3) + 1; //  홀수의 경우
			else val /= 2; //  짝수의 경우

			temp.add(val);
		}

		int len = temp.size() - 1;
		double[] prev = new double[len];

		//  구간별 넓이 계산
		for(int i = 0; i < len; i++) {
			prev[i] = (double)(temp.get(i) + temp.get(i+1)) / 2.0;
		}

		//  누적 합 계산
		double[] pref = new double[len + 1];
		for(int i = 0; i < len; i++) {
			pref[i+1] = pref[i] + prev[i];
		}

		//  결과값 정리
		double[] answer = new double[ranges.length];

		for(int i = 0; i < ranges.length; i++) {
			int s = ranges[i][0];
			int eOff = ranges[i][1]; // 마지막 인덱스의 offset
			int e = len + eOff; //  마지막 인덱스

			//  인덱스 보정
			if(s < 0 || s > len || e < 0 || e > len || e < s) answer[i] = -1.0;
			else answer[i] = pref[e] - pref[s];

		}

		return answer;
	}
}

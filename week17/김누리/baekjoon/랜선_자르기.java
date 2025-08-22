package week17.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * PackageName : week17.김누리.baekjoon
 * FileName    : 랜선_자르기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 17.     김누리(NRKim)               Initial creation
 */

/*
*
* 입력
* 1번째 줄 : 가지고 있는 랜선의 갯수_필요한 랜선의 갯수
* 예) 4_11 : 가지고 있는 랜선의 갯수 4, 필요한 랜선의 갯수 : 11
*
* 2번째 줄 부터
*
* 802 cm
* 743 cm
* 457 cm
* 539 cm
*
* 그러면 나눠야 할 랜선의 길이도 필요할테니.... >> 이것 부터 구해야 풀이가 될 거 같은데...
*
* 802 cm / x >>
* 743 cm / x >>
* 457 cm / x >>
* 539 cm / x >>
*
* 위와 같이 해야 하니까..
*
* 그러면.... 가지고 있는 랜선의 갯수는 최대 1만개.... 필요한건 100만개 까지....
*
*
* 입력값의 조건들이 어마무시 하니 이진 탐색 쓰면 될거 같고.
*
* int left = 1, right = 0 ;
*
* while(left <= right) {
*
* }
*
*
*/

public class 랜선_자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer first = new StringTokenizer(br.readLine()); //  1번째줄 읽기
		int have = Integer.parseInt(first.nextToken()); //  이미 가지고 있는 랜선 수
		int need = Integer.parseInt(first.nextToken()); //  필요한 랜선 수
		long[] arr = new long[have]; //  현재 가지고 있는 랜선 수
		long max = 0; //  랜선의 최대 길이
		long answer = 0;

		//  가지고 있는 랜선들 배열에 저장
		for(int i = 0; i < have; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			arr[i] = Long.parseLong(tk.nextToken());

			if(arr[i] > max) max = arr[i];
		}

		long left = 1, right = max; //  left = 시작

		//  이진 탐색 시작
		while(left <= right) {
			long mid = (left + right) / 2;  //  중앙값
			long cnt = 0;  //  랜선 자른 갯수 cnt

			for(long a : arr) cnt += a/mid;

			if(cnt >= need) {
				answer = mid; //  필요한 갯수 이상이면 중앙값 적재
				left = mid + 1;
			} else  {
				right = mid -1;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}

package week17_a.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * PackageName : week17_a.김누리.baekjoon
 * FileName    : 스위치_켜고_끄기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-22
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 22.     김누리(NRKim)               Initial creation
 */

/*
*
* 입력 값
* 1번째 줄 : 스위치 갯수
* 2번째 줄 : 스위치 상태
* 3번째 줄 : 학생 수
* 4번째 ~ N번째 줄 : 학생 성별_받은 수
* 예 ) 1_3 : 남학생_3번 스위치 갯수
*
* 출력 : 1번 ~ N번 까지 스위치 상태 출력
*
* case 1 :
*
* 8
* 0 1 0 1 0 0 0 1
* 2
* 1 3 >> 3번 6번 스위치 변환 >> 즉 자신이 받은 수의 배수 위치에서 스위칭
* 2 3 >> 자신이 받은 스위치를 기준으로 좌우 대칭 + 가장 많은 스위치 포함 구간을 찾아 스위치 상태 변경.
* 예)  3을 받았으니, 3번을 기준으로 1,2번 / 4,5번 스위치 중 많은 갯수 즉
*
* 현재 스위치 상태는
*
* 0 1 0 1 0 0 0 1 상태이니
*
* 1 3 의 경우
*
* 0 1 1 1 0 1 0 1
*
* 이후 2 3 의 경우
*
* 1번 0, 2번 1
* 4번 1 5번 0
*
* 1,2랑 4,5 값 모두 같으니 12345 모두 스위칭
*
* 0 1 1 1 0 1 0 1
* 1 0 0 0 1 1 0 1
*
*/

public class 스위치_켜고_끄기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); //  스위치 갯수.
		int[] sw = new int[N+1]; //  자리수 맞추기 용도

		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) sw[i] = Integer.parseInt(tk.nextToken());

		int M = Integer.parseInt(br.readLine()); // 학생 수

		//  학생 수 만큼 반복
		for(int i = 0; i < M; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(token.nextToken()); //  성별
			int cnt = Integer.parseInt(token.nextToken()); //  받은 스위치 갯수

			if (sex == 1) {
				for(int j = cnt; j <= N; j+= cnt) {
					if(sw[j] == 1) sw[j] = 0;
					else sw[j] = 1;
				}
			} else {
				int left = cnt, right = cnt;
				while (left -1 >= 1 && right +1 <= N && sw[left - 1] == sw [right+1]) {
					left--;
					right++;
				}

				for(int j = left; j <= right; j++) {
					if (sw[j] == 1) {
						sw[j] = 0;
					} else {
						sw[j] = 1;
					}
				}
			}
		}

		for(int i = 1; i <= N; i++) {
			bw.write(sw[i] + (i % 20 == 0 ? "\n" : " "));
		}

		if(N % 20 != 0) bw.write("\n");

		bw.flush();
		bw.close();
	}
}

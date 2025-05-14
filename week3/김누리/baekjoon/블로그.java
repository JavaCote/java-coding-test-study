package week3.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * PackageName : week3.김누리.baekjoon
 * FileName    : 블로그
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-14
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 14.     김누리(NRKim)               Initial creation
 */

/*
입력 분석
N과 X
N은 블로그 시작한지 N일이 지남.
X는 N일 중 연속된 X 일

예 )
1번 케이스
5 2
1 4 2 5 1

1번째 명령어에서 N = 5, X = 2
2번째 명령어 방문자 = {1,4,2,5,1}

방문자[0] + 방문자[1] = 1 + 4 = 5
방문자[1] + 방문자[2] = 4 + 2 = 6
방문자[2] + 방문자[3] = 2 + 5 = 7
방문자[3] + 방문자[4] = 5 + 1 = 6

max 값은 7, 이는 1번 반복되니 출력은

7
1


2번 케이스
7 5
1 1 1 1 1 5 1

1번째 명령어에서 N = 7, X = 5
2번째 명령어 방문자 = {1,1,1,1,1,5,1}

방문자[0] + 방문자[1] + 방문자[2] + 방문자[3] + 방문자[4]= 1 + 1 + 1 + 1 + 1 = 5
방문자[1] + 방문자[2] + 방문자[3] + 방문자[4] + 방문자[5]= 1 + 1 + 1 + 1 + 5 = 9
방문자[1] + 방문자[2] + 방문자[3] + 방문자[4] + 방문자[5]= 1 + 1 + 1 + 5 + 1 = 9

max 값은 9, 이는 2번 반복되니 출력은

9
2

3번 케이스
5 3
0 0 0 0 0

1번째 명령어에서 N = 5, X = 3
2번째 명령어 방문자 = {0,0,0,0,0}

방문자[0] + 방문자[1] + 방문자[2] = 0
방문자[1] + 방문자[2] + 방문자[3] = 0
방문자[2] + 방문자[3] + 방문자[4] = 0

max는 0이니 SAD 출력

*/

public class 블로그 {
	public void solution() throws Exception {
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // N 값
		int x = Integer.parseInt(st.nextToken()); // X 값

		int[] arr = new int[n]; // N사이즈 만큼 배열 생성
		st = new StringTokenizer(br.readLine(), " ");

		//  배열에 값 입력
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;

		for(int i = 0; i < x; i++) {
			// x번째 까지 미리 합을 구함 예 ) x가 2일 때 : sum = arr[0] + arr[1]
			sum += arr[i]; // sum += sum[0]:1 > sum += sum[1]:4 = 5
		}

		int max = sum; // 더한 값이 최대일 때 // 현재 : 5
		int cnt = 1; // max 값 지속 일자

		//  x =< i < n // i = 2 3 4
		for(int i = x; i < n; i++) {
			// sum에 현재 idx - x 번째의 인덱스 값을 빼고, 현재 인덱스 값 더하기
			//  sum = sum - arr[2-2] + arr[2] > sum = sum - arr[0] + arr[2]
			//  sum = 5 - 1 + 2
			//  5-1 = (4 == arr[1])
			//  4 + 2 = arr[1] + arr[2] = 6

			//  sum = sum - arr[3-2] + arr[3] > sum = sum - arr[1] + arr[3]
			//  sum = 6 - 4 + 5
			//  6 - 4 = (2 == arr[2])
			//  2 + 5 = arr[2] + arr[3] = 7
			sum = sum - arr[i-x] + arr[i];

			if(sum > max) {
				max = sum; // 최고 수치 갱신
				cnt = 1; // max 지속일 갱신
			} else if (sum == max){
				cnt++; // max 값 ++
			}
		}

		if(max == 0) {
			bw.write("SAD" + "\n");
		} else {
			bw.write(max+"\n"+cnt+"\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}

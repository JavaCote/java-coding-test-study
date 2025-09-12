package week20.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * PackageName : week20.김누리.baekjoon
 * FileName    : 일_이_삼_더하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-07
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 07.     김누리(NRKim)               Initial creation
 */

/*

예 )
3 -> 테스트 케이스의 건수
4  -->  4를 1, 2, 3의 합으로 나타낼 것 => (1,3)/ (2,2)/ (3,1)/ (1,1,2)/ (1,2,1)/ (2,1,1)/ (1,1,1,1) ==> 7건
7  -->  7를 1, 2, 3의 합으로 나타낼 것 => (1, 3, 3)/ (2, 2, 3)/ (3, 1, 3)/ (1, 1, 2, 3)/ (1, 2, 2, 2)/ (2, 1, 2, 2)/ (1, 1, 1, 2, 2)/ (1, 2, 1, 1, 2)/ (2, 1, 1, 1, 2)/ (1, 1, 1, 1, 1, 2)/ (1, 2, 1, 1, 1, 1)/ (2, 1, 1, 1, 1, 1)/ (1, 1, 1, 1, 1, 1, 1) ==> 44건
10 --> 10를 1, 2, 3의 합으로 나타낼 것 => 274건

그러면

1 2 3 4  5  6  7  8   9  10
1 2 4 7 13 24 44 81 149 274

dp[1] = 1
dp[2] = 2
dp[3] = 4
dp[4] = 7
dp[5] = 13
dp[6] = 24

※ dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

*/

public class 일_이_삼_더하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine().trim()); //  정답 배열 크기
		int[] answer = new int[11];

		//  1의 경우 = 1, 2의 경우 = 2 , 3의 경우 = 4로 fix
		answer[0] = 1;
		answer[1] = 2;
		answer[2] = 4;

		//  dp[i] = dp[i-1] + dp[i-2] + dp[i-3], 실제 패턴은 위 주석 확인 ㄱㄱ
		for(int i = 3; i < 11; i++) answer[i] = answer[i-1] + answer[i-2] + answer[i-3];

		//  출력 처리
		for(int i = 0; i < size; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			bw.write(answer[n-1] + "\n");
		}

		bw.flush();
		bw.close();
	}
}

package week19_a.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * PackageName : week19_a.김누리.baekjoon
 * FileName    : 평범한_배낭
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 05.     김누리(NRKim)               Initial creation
 */

/*

1번째 줄 : 물품 수_무게 >> 4_7 (물품 4개, 총 무게 7)
2~N번째 줄 :  물건의 무게_가치 >> 6_13 (N-1번의 물건의 무게: 6, 가치: 13)

그러면 물건을 담을 수 있는 가치의 최대는?

dp 써야 겠네...

max = 1번째줄의 2번째(무게값)

for(int i = 0; i < 무게; i++) {
	dp[i] = 가치;
	if(i > max) continue;

	sum += dp[무게]

}

*/

public class 평범한_배낭 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(br.readLine()); //  첫번째 줄
		int n = Integer.parseInt(tk.nextToken()); //  물품 수
		int m = Integer.parseInt(tk.nextToken()); //  베낭이 버틸 수 있는 무게

		int[] w = new int[n]; //  무게 계산용 배열
		int[] v = new int[n]; //  무게 별 가치 측정용 배열

		//  물품수 만큼 배열 정렬하며 무게, 가치 배열 채우기
		for(int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(tk.nextToken());
			v[i] = Integer.parseInt(tk.nextToken());
		}

		int[] dp = new int[m+1]; //  dp 배열은 가치 확인용으로

		for(int i = 0; i < n; i++) {
			int wgt = w[i], val = v[i];

			//  역방향 순회
			for(int j = m; j >= wgt; j--) {
				dp[j] = Math.max(dp[j], dp[j-wgt] + val);
			}
		}

		bw.write(dp[m] + "\n");
		bw.flush();
		bw.close();
	}
}

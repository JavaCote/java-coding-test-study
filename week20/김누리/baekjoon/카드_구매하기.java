package week20.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * PackageName : week20.김누리.baekjoon
 * FileName    : 카드_구매하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-07
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 07.     김누리(NRKim)               Initial creation
 */

/*

4 ==> 구매 갯수 (카드 갯수)
1 5 6 7

그러면
카드 1개가 든 카드팩은 1원, 이걸 4팩을 사야 카드를 4개 구매하게 됨. 그럼 소비액 ==> 4원
카드 2개가 든 카드팩은 5원, 이걸 2팩을 사야 카드를 4개 구매하게 됨. 그럼 소비액 ==> 10원
카드 3개가 든 카드팩은 6원, 이걸 1팩, 그리고 1개가 든 카드팩 1팩을 사야 카드를 4개 구매하게 됨. 그럼 소비액 ==> 7원
카드 4개가 든 카드팩은 7원, 이걸 1팩을 사야 카드를 4개 구매하게 됨. 그럼 소비액 ==> 7원


*/

public class 카드_구매하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine()); //  카드 갯수
		int[] price = new int[size+1];
		StringTokenizer tk = new StringTokenizer(br.readLine());

		//  카드팩 당 카드팩 가격 (1개입 팩 : 1원, 2개입 팩 : 5원 등등)
		for(int i = 1; i < size;i++) price[i] = Integer.parseInt(tk.nextToken());

		int[] dp = new int[size+1];

		for(int i = 1; i <= size; i++) {
			int tmp = 0;

			for(int j = 1; j <= i; j++) {
				//  최댓값 구하기
				tmp = Math.max(tmp, price[j] + dp[i-j]);
			}

			dp[i] = tmp;
		}

		bw.write(String.valueOf(dp[size]));
		bw.flush();
		bw.close();
	}
}

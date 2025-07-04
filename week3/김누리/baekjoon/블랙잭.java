package week3.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * PackageName : week3.김누리.baekjoon
 * FileName    : 블랙잭
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-14
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 14.     김누리(NRKim)               Initial creation
 */

public class 블랙잭 {
	public static void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int l = Integer.parseInt(st.nextToken()); // 덱에 들어갈 카드 갯수
		int target = Integer.parseInt(st.nextToken()); // 타겟 숫자

		int[] cards = new int[l]; // 덱에 들어갈 만큼 카드 갯수 지정
		st = new StringTokenizer(br.readLine()," "); // 카드 입력
		for(int i = 0 ; i < l ; i++) cards[i] = Integer.parseInt(st.nextToken()); // 덱에 카드 입력

		int max = 0; // 3장의 카드를 더해질 변수

		for(int i =0 ; i < l-2 ; i++) {
			for(int j = i+1 ; j < l-1 ; j++) {
				for(int k = j+1 ; k < l ; k++) {
					int comb = cards[i] + cards[j] + cards[k];

					if(comb <= target) {
						if (comb > max) {
							max = comb;
						}
					}
				}
			}
		}
		bw.write(String.valueOf(max)+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

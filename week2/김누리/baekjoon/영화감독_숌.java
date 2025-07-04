package week2.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * PackageName : week2.김누리.baekjoon
 * FileName    : 영화감독_숌
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 06.     김누리(NRKim)               Initial creation
 */

public class 영화감독_숌 {
	public static void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); //  n번째 수 받아오기 위한 코드 
		int num = 666; //  타겟 수 
		int cnt = 0;

		//  n번 동안 반복 
		while(cnt < n) {
			if(String.valueOf(num).contains("666")) cnt++;
			num++;
		}

		bw.write(String.valueOf(num-1)+"\n");
		br.close();
		bw.close();
	}
}


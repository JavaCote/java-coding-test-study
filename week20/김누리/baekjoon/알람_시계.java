package week20.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * PackageName : week20.김누리.baekjoon
 * FileName    : 알람_시계
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 10.     김누리(NRKim)               Initial creation
 */

/*

첫번째 줄 : H_M >> 10 10 >> 10:10

그러면 H : M 을 M단위로 변경 후 45를 -

이후 다시 H M 형태로 반환

*/

public class 알람_시계 {
	public static void main(String[] args) throws  Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] hm = br.readLine().split(" ");
		int h = Integer.parseInt(hm[0]);
		int m = Integer.parseInt(hm[1]);

		int min = toMin(h, m);

		min = (min - 45 + 24*60) % (24 * 60);

		bw.write(toHM(min));
		bw.flush();
		bw.close();
	}

	private static int toMin(int h, int m) {
		return  h * 60 + m;
	}

	private static String toHM (int min) {
		int h = min / 60;
		int m = min % 60;

		return Integer.toString(h) + " " + Integer.toString(m);
	}
}

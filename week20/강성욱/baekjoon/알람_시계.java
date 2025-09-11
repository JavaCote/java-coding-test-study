package week20.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;

/**
 * PackageName : week20.강성욱.baekjoon
 * FileName    : 알람_시계
 * Author      : Baekgwa
 * Date        : 2025-09-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-11     Baekgwa               Initial creation
 */
public class 알람_시계 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			LocalTime nowTime = LocalTime.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			LocalTime alramTime = nowTime.minusMinutes(45L);

			System.out.println(alramTime.getHour() + " " + alramTime.getMinute());
		}
	}
}

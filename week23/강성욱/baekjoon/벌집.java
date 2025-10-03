package week23.강성욱.baekjoon;

import java.io.IOException;
import java.util.Scanner;

/**
 * PackageName : week23.강성욱.baekjoon
 * FileName    : 벌집
 * Author      : Baekgwa
 * Date        : 2025-09-29
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-29     Baekgwa               Initial creation
 */
public class 벌집 {
	// 입력값에 따라서 범위가 지정됨
	// 1 -> 2 ~ 7 -> 8 ~ 19 ...
	// 1 -> 6개 -> 12개 -> 18개 ... 6개씩 늘어남
	public class Main {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			long N = sc.nextLong();
			sc.close();

			long cnt = 1;
			long now = 1;
			while(now < N) {
				now += cnt * 6;
				cnt++;
			}

			System.out.println(cnt);
		}
	}
}

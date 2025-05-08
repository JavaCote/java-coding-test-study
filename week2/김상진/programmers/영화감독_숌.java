package week2.김상진.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 영화감독_숌
 * Author      : sangxxjin
 * Date        : 2025. 5. 8.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangxxjin               Initial creation
 */
public class 영화감독_숌 {

	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int num = 666;
			int count = 1;
			while(count != N) {
				num++;
				if(String.valueOf(num).contains("666")) {
					count++;
				}
			}
			System.out.println(num);
		}
	}
}

package week31.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PackageName : week31.강성욱.baekjoon
 * FileName    : 잃어버린_괄호
 * Author      : Baekgwa
 * Date        : 25. 12. 2.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 2.     Baekgwa               Initial creation
 */
public class 잃어버린_괄호 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] split = br.readLine().split("-"); // - 기준으로 나눔

			int result = 0;

			result += sum(split[0]);

			for (int i = 1; i < split.length; i++) {
				result -= sum(split[i]);
			}

			System.out.println(result);
		}

		private static int sum(String split) {
			// 이 안에는 + 밖에없음
			String[] array = split.split("\\+");

			int result = 0;
			for (String s : array) {
				result += Integer.parseInt(s);
			}

			return result;
		}
	}
}

package week39.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PackageName : week39.강성욱.baekjoon
 * FileName    : A와_B
 * Author      : Baekgwa
 * Date        : 26. 1. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 30.     Baekgwa               Initial creation
 */
public class A와_B {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String start = br.readLine();
			String end = br.readLine();

			while(true) {
				if(end.length() < start.length()) {
					System.out.println(0);
					return;
				}

				String lastChar = end.substring(end.length()-1, end.length());
				end = end.substring(0, end.length()-1);

				// B 였으면, B 빼고 뒤집기
				if(lastChar.equals("B")) {
					end = reverseEnd(end);
				}

				if(end.equals(start)) {
					System.out.println(1);
					return;
				}
			}
		}

		private static String reverseEnd(String end) {
			StringBuilder sb = new StringBuilder();
			for(int i=end.length()-1;i>=0;i--) {
				sb.append(end.charAt(i));
			}
			return sb.toString();
		}
	}
}

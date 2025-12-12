package week32.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week32.강성욱.baekjoon
 * FileName    : 로또
 * Author      : Baekgwa
 * Date        : 25. 12. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 12.     Baekgwa               Initial creation
 */
public class 로또 {
	public class Main {

		static int k;
		static int[] s;
		static int[] picked = new int[6];
		static StringBuilder sb = new StringBuilder();

		public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				String line = br.readLine();
				if (line.equals("0")) break;

				StringTokenizer st = new StringTokenizer(line);
				k = Integer.parseInt(st.nextToken());

				s = new int[k];
				for (int i = 0; i < k; i++) {
					s[i] = Integer.parseInt(st.nextToken());
				}

				back(0, 0);
				sb.append("\n");
			}

			System.out.println(sb.toString());
		}

		private static void back(int depth, int start) {
			if (depth == 6) {
				for (int i = 0; i < 6; i++) {
					sb.append(picked[i]).append(" ");
				}
				sb.append("\n");
				return;
			}

			for (int i = start; i < k; i++) {
				picked[depth] = s[i];
				back(depth + 1, i + 1);
			}
		}
	}
}

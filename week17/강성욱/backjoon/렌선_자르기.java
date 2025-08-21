package week17.강성욱.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PackageName : week17.강성욱.backjoon
 * FileName    : 렌선_자르기
 * Author      : Baekgwa
 * Date        : 2025-08-21
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-21     Baekgwa               Initial creation
 */
public class 렌선_자르기 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int[] cables = new int[k];
			long left = 1;
			long right = 0;

			for (int i = 0; i < k; i++) {
				cables[i] = Integer.parseInt(br.readLine());
				right = Math.max(right, cables[i]);
			}

			long result = 0;

			while (left <= right) {
				long mid = left + (right - left) / 2;

				long count = 0;
				for (int i = 0; i < k; i++) {
					count += cables[i] / mid;
				}

				if (count >= n) {
					result = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

			System.out.println(result);
		}
	}
}

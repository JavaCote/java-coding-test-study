package week22.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * PackageName : week22.강성욱.baekjoon
 * FileName    : 두_수의_합
 * Author      : Baekgwa
 * Date        : 2025-09-26
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-26     Baekgwa               Initial creation
 */
public class 두_수의_합 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int cnt = Integer.parseInt(br.readLine());
			int[] arr = new int[cnt];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<cnt; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int target = Integer.parseInt(br.readLine());

			Arrays.sort(arr);

			int left = 0;
			int right = cnt - 1;
			int result = 0;

			while(left < right) {
				int value = arr[left] + arr[right];

				if(value == target) {
					result++;
					left++;
					right--;
				}
				else if(value > target) {
					right--;
				} else {
					left++;
				}
			}

			System.out.println(result);
		}
	}
}

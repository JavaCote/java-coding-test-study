package week17_A.강성욱.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PackageName : week17_A.강성욱.backjoon
 * FileName    : 스위치_켜고_끄기
 * Author      : Baekgwa
 * Date        : 2025-08-22
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-22     Baekgwa               Initial creation
 */
public class 스위치_켜고_끄기 {
	public class Main {

		public static final int MAN = 1;
		public static final int WOMAN = 2;

		public static void main(String args[]) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			boolean[] status = new boolean[n];

			String[] tokenArray = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				status[i] = tokenArray[i].equals("1");
			}

			//명령어 개수 입력 받기
			int count = Integer.parseInt(br.readLine());

			for(int i=0; i<count; i++) {
				String[] newTokenArray = br.readLine().split(" ");
				int gender = Integer.parseInt(newTokenArray[0]);
				int order = Integer.parseInt(newTokenArray[1]);

				if(gender == MAN) {
					for (int index = order; index <= n; index += order) {
						status[index - 1] = !status[index - 1];
					}
				}
				else {
					int center = order - 1;
					status[center] = !status[center];

					int left = center - 1;
					int right = center + 1;
					boolean flag = true;

					while (flag) {
						if (left < 0 || right >= n) break;
						if (status[left] != status[right]) break;

						// 대칭이면 즉시 양쪽 바꿈
						status[left] = !status[left];
						status[right] = !status[right];

						left--;
						right++;
					}

				}
			}

			for(int i=0; i<n; i++) {
				System.out.print(status[i] ? "1" : "0");
				if (i != n - 1) System.out.print(" ");
				if ((i + 1) % 20 == 0) System.out.println();
			}
		}
	}
}

package week31.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * PackageName : week31.강성욱.baekjoon
 * FileName    : 먹을_것인가_먹힐_것인가
 * Author      : Baekgwa
 * Date        : 25. 12. 2.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 2.     Baekgwa               Initial creation
 */
public class 먹을_것인가_먹힐_것인가 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int testCase = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();

			for(int i=0; i<testCase; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int aCount = Integer.parseInt(st.nextToken());
				int bCount = Integer.parseInt(st.nextToken());

				int[] a = new int[aCount];
				int[] b = new int[bCount];

				st = new StringTokenizer(br.readLine());
				for(int idx=0; idx<aCount; idx++) {
					a[idx] = Integer.parseInt(st.nextToken());
				}

				st = new StringTokenizer(br.readLine());
				for(int idx=0; idx<bCount; idx++) {
					b[idx] = Integer.parseInt(st.nextToken());
				}

				// a 를 iter 돌면서 확인
				Arrays.sort(b); //b 배열 한번 정리해줘야함 정렬
				int result = 0;
				for (int nowA : a) {
					int idx = Arrays.binarySearch(b, nowA);

					// 음수면, 그곳에 넣으면 되는 index 값 반환됨.
					int count = 0;
					if(idx < 0) {
						count = idx * -1 - 1;
					} else {
						while(idx > 0 && b[idx -1] == nowA) {
							idx--;
						}
						count = idx;
					}

					result += count;
				}

				sb.append(result).append("\n");
			}

			System.out.println(sb);
		}
	}
}

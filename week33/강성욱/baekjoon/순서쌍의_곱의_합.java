package week33.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week33
 * FileName    : 순서쌍의_곱의_합
 * Author      : Baekgwa
 * Date        : 25. 12. 16.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 16.     Baekgwa               Initial creation
 */
public class 순서쌍의_곱의_합 {
	public class Main {
		// 100,000C2
		// 10000000000 / 2
		// 5,000,000,000 50억? 불가능.

		// [2, 3, 4, 5, 6, 7] 이면
		// (2 * 3) + (2 * 4) + (2 * 5) + (2 * 6) + (2 * 7)
		// 6 + 8 + 10 + 12 + 14 = 50
		// 이걸 바꾸면?
		// 2 * (3 + 4 + 5 + 6 + 7) 으로 대체 가능?
		// = 50
		// 아 이렇게 풀면 될듯?
		// 그럼, 미리 1번인덱스 부터 n 인덱스 까지 합을 구하고, 하나씩 처리하면 되겠네

		// 이거 더해놓는거 long 써야할듯? 10,000 이, 100,000 번 나오면?
		// 1,000,000,000
		// 아 상관없네
		// 아 정답이 long 이어야 하것네

		public static void main(String[] args) throws IOException {
			int sum = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int count = Integer.parseInt(br.readLine());
			int[] map = new int[count];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < count; i++) {
				map[i] = Integer.parseInt(st.nextToken());
				if(i == 0) continue;
				sum += map[i];
			}

			long result = 0;
			for(int idx=1; idx<count; idx++) {
				result += (long)map[idx - 1] * sum;
				sum -= map[idx];
			}

			System.out.println(result);
		}
	}

}

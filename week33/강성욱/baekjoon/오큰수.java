package week33.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * PackageName : week33.강성욱.baekjoon
 * FileName    : 오큰수
 * Author      : Baekgwa
 * Date        : 25. 12. 16.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 16.     Baekgwa               Initial creation
 */
public class 오큰수 {
	public class Main {
		// 오큰수
		// 0 번부터 시작해서 처리못하면, stack 에 넣기
		// 즉, stack 에 쌓이는 순서는, 항상 더 작은거 부터 나오게 됨
		// 따라서 가다가 어? 이건 오큰수가 아닌데 하면, 스택에 남아있는 모든건 현재 탐색에서는 오큰수 판별이 불가.
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int count = Integer.parseInt(br.readLine());

			int[] map = new int[count];
			int[] result = new int[count];
			Arrays.fill(result, -1);

			ArrayDeque<Integer> stack = new ArrayDeque<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < count; i++) {
				// 입력 받기
				map[i] = Integer.parseInt(st.nextToken());

				while (!stack.isEmpty()) {
					// 인덱스 들어있음
					// 2, 3
					if (map[stack.peek()] >= map[i])
						break;
					result[stack.pop()] = map[i];
				}

				stack.push(i);
			}

			// 출력 정리
			StringBuilder sb = new StringBuilder();
			for (int now : result) {
				sb.append(now).append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb);
		}
	}

}

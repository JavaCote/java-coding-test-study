package week34.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PackageName : week34.강성욱.baekjoon
 * FileName    : 두_용액
 * Author      : Baekgwa
 * Date        : 25. 12. 22.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 22.     Baekgwa               Initial creation
 */
public class 두_용액 {
	public class Main {
		// 어짜피 두개만 선택함.
		// -2, 4, -99, -1, 98
		// 정렬해둘까?
		// -99, -2, -1, 4, 98
		// 다 확인하면? 100,000^2 = 10,000,000,000 = 백억은 좀;
		// 투포인터?

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int N = Integer.parseInt(br.readLine()); //용액 종류
			int[] map = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			// 정렬
			Arrays.sort(map);

			// 투포인터 탐색
			int left = 0;
			int right = N-1;
			int nowMin = Integer.MAX_VALUE;
			List<Integer> result = new ArrayList<>();

			while(left < right) {
				int leftVal = map[left];
				int rightVal = map[right];

				int sum = leftVal + rightVal;

				// 현재값이 가장 작은 값인지 확인해보기
				// 0에 가까운걸 찾기 때문에, 절대값으로 변환해서 사용
				if(nowMin > Math.abs(sum)) {
					nowMin = Math.abs(sum);
					result.clear();
					result.add(leftVal);
					result.add(rightVal);
				}

				// 현재 값에 따라서, 포인터 움직이기
				if(sum == 0) {
					// 0 이면 더 이상 탐색할 필요도 없이, 완벽한 혼합용액
					break;
				} else if(sum < 0) {
					// 음수인 경우에는 left 를 늘려야함
					left++;
				} else {
					right--;
				}
			}

			System.out.println(result.get(0) + " " + result.get(1));
		}
	}
}

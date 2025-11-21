package week29.강성욱.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * PackageName : week29.강성욱.backjoon
 * FileName    : 수_묶기
 * Author      : Baekgwa
 * Date        : 25. 11. 21.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 21.     Baekgwa               Initial creation
 */
public class 수_묶기 {
	public class Main {
		// 음, 거의 대부분의 상황에서 묶는게 정배
		// 음수는 음수끼리 묶는게 베스트 -> 그럽 곱했을 때, 양수로 변경되잖아.
		// 양수도, 큰수끼리 묶는게 베스트 ->
		// 그럼, 양수, 음수 집합을 만들고
		// 최대끼리 합해서 처리하면 되는거 아냐?
		// 음 집합을 만드려면 O(n)?
		// 아 근데 입력받을때, PQ 두개에 넣고 돌리면 될듯?

		public static int result = 0;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			PriorityQueue<Integer> positivePq = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> negativePq = new PriorityQueue<>();

			int count = Integer.parseInt(br.readLine());
			for (int i = 0; i < count; i++) {
				int num = Integer.parseInt(br.readLine());
				if(num > 0) positivePq.add(num);
				else negativePq.add(num);
			}

			// 양수부터 차례로, 2개씩 빼서 처리.
			// 마지막 내부적으로, 더했을때 곱했을때 비교해서 result 에 반영해야함
			calc(positivePq);

			// 음수처리.
			// 음수는 가장 작은수끼리 곱해서 음수로 만들어서 처리해야함
			calc(negativePq);

			System.out.println(result);
		}

		private static void calc(PriorityQueue<Integer> pq) {
			while(pq.size() > 1) { //2개 이상 있을때만
				int a = pq.poll();
				int b = pq.poll();

				int sum = a + b;
				int prod = a * b;
				result += Math.max(sum, prod);
			}
			if(!pq.isEmpty()) {
				result += pq.poll();
			}
		}
	}
}

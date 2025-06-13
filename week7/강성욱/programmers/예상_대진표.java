package week7.강성욱.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * PackageName : week7.강성욱.programmers
 * FileName    : 예상_대진표
 * Author      : Baekgwa
 * Date        : 2025-06-12
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-12     Baekgwa               Initial creation
 */
public class 예상_대진표 {
	//반복문으로 해결이 가능한가?
	//N = 2^20 = 1,048,576
	//1,048,576 + 500,000 + 250,000, + 125000 .... + 2
	//그냥 가능할 듯?
	//A와 B는 항상 이기기 때문에, 결승에서는 무조건 만나서 못만나는 경우는 없음!

	class Solution
	{
		public int solution(int n, int a, int b)
		{
			Queue<Integer> q = new LinkedList<>();
			int depth = 0;
			for(int i=1; i<=n; i++) {
				q.offer(i);
			}

			while(q.size() > 1) {
				depth++;
				List<Integer> next = new ArrayList<>();
				while(q.size() >= 2) {
					int p1 = q.poll();
					int p2 = q.poll();
					if ((p1 == a && p2 == b) || (p1 == b && p2 == a)) {
						return depth;
					}
					// a, b 둘 다 아니면 한 명 아무나 진출(여기서는 p1)
					if (p1 == a || p1 == b) next.add(p1);
					else if (p2 == a || p2 == b) next.add(p2);
					else next.add(p1); // 중요X, 어차피 a/b 아니면 신경X
				}
				// 다음 라운드 큐 채움 (새로운 번호 부여 효과)
				for(int num : next) {
					q.offer(num);
				}
			}
			return depth;
		}
	}
}

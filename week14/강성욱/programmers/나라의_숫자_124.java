package week14.강성욱.programmers;

/**
 * PackageName : week14.강성욱.programmers
 * FileName    : 나라의_숫자_124
 * Author      : Baekgwa
 * Date        : 2025-07-28
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-28     Baekgwa               Initial creation
 */
public class 나라의_숫자_124 {
	// 124진법? 새로만든 진법을 10->124진법으로 변경해야됨.
	// 사실상 4진법인데, 3을 4로만 바꾸면 되는거 아닌가?
	// toString(n, 4) 하고
	// replace 하기
	// 는, 4부터 안되네. 사실 4진법은, 0,1,2,3 을 쓰는구나. 그럼 안되겠네.
	// 사실 3개씩 반복되는거니 계산으로 처리?
	// 1 % 3 == 1

	// 이거 진짜 이해 안되서 GPT 도움 좀 많이 받음..ㅠ

	public class Solution {
		public String solution(int n) {
			String[] nums = {"4", "1", "2"};
			StringBuilder sb = new StringBuilder();

			while (n > 0) {
				sb.append(nums[n % 3]);
				n = (n - 1) / 3;
			}

			return sb.reverse().toString();
		}
	}
}

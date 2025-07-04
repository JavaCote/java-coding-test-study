package week10.강성욱.programmers;

/**
 * PackageName : week10.강성욱.programmers
 * FileName    : 부족한_금액_계산하기
 * Author      : Baekgwa
 * Date        : 2025-07-02
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-02     Baekgwa               Initial creation
 */
public class 부족한_금액_계산하기 {
	class Solution {
		public long solution(int price, int money, int count) {

			long total = 0;
			for(int i=1; i<=count; i++) {
				total += (long) price * i;
			}

			return Math.max(0, total - (long)money);
		}
	}
}

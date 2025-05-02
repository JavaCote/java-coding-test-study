//10씩 나누자?
//123 / 10 = 12 이건 다음에 전달
//123%10 = 3 이건 더하고

import java.util.*;

public class Solution {
	public int solution(int n) {
		int sum = 0;

		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}

		return sum;
	}
}
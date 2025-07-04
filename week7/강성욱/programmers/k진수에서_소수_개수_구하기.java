package week7.강성욱.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week7.강성욱.programmers
 * FileName    : k진수에서_소수_개수_구하기
 * Author      : Baekgwa
 * Date        : 2025-06-11
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-11     Baekgwa               Initial creation
 */
public class k진수에서_소수_개수_구하기 {
	//문제가 좀 헷갈리네
	//그러니깐, 즉, 3진수로 바꾸고
	//그걸 파싱해서 쭉 확인을 하는데, 0이 나올때까지 문자를 쭉 이어 붙이면?
	//그리고 그게 소수인지 판별을 하면 해결될 거 같은데?
	// k진수로 변환하는게 필요. String 으로 처리하자.
	// 미리 소수를 구해두고..? 대체 어디까지? -> 최악의 조건에서 3진수로 바꿧을때 어디까지 나오려나...?
	// 2222222222220(3) -> 1,594,320(10) 너무 많이 캐싱해야되는데?
	// 그리고 너무 복잡함...
	// 소수를 판별하려면?
	// 그냥 값이 들어오면 반복문으로 해결하자. 만약 너무 큰값 (222222222220 같은게 들어오면 한번이 조금 많이 돌지만 어짜피 한번만 돌면 되서 ㄱㅊ)
	// 그럼 1, 2, 조건만 확인하고, 루트까지 반복해서 나눠지는지 검사해보면 될듯 ㅇㅇ

	class Solution {
		public int solution(int n, int k) {
			int result = 0;

			//k진수 변환
			String kString = Integer.toString(n, k);

			//0 기준으로 끊음
			//211, 2, 1, 1, 11
			String[] kStringToken = tokenizerString(kString);

			//위의 토큰을 소수 판별
			for(String token : kStringToken) {
				if(isPrime(Long.parseLong(token))) result++;
			}

			return result;
		}

		private boolean isPrime(long num) {
			if (num == 1) return false;
			if (num == 2) return true;
			if (num % 2 == 0) return false;
			long sqrt = (long)Math.sqrt(num);
			for (long i = 3; i <= sqrt; i += 2) {
				if (num % i == 0) return false;
			}
			return true;
		}

		//String 값을 0 기준으로 token 처럼 끊는 함수
		private String[] tokenizerString(String kString) {
			List<String> tokens = new ArrayList<>();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < kString.length(); i++) {
				char c = kString.charAt(i);
				if (c != '0') {
					sb.append(c);
				} else {
					if (sb.length() > 0) {
						tokens.add(sb.toString());
						sb.setLength(0);
					}
				}
			}
			// 마지막 토큰 처리
			if (sb.length() > 0) {
				tokens.add(sb.toString());
			}

			return tokens.toArray(new String[0]);
		}
	}
}

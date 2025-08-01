package week13_a.김누리.progarmmers;

/**
 * PackageName : week13_a.김누리.progarmmers
 * FileName    : 옹알이_2
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-01
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 01.     김누리(NRKim)               Initial creation
 */

public class 옹알이_2 {
	public int solution(String[] babbling) {
		int answer = 0;
		String[] babb = {"aya", "ye", "woo", "ma"};

		for(int i = 0; i < babbling.length; i++) {
			String target = babbling[i];

			//  연속 발음 있는지 체크용 bool
			boolean invalid = false;

			for(String b : babb) {
				if(target.contains(b+b)) {
					invalid = true;
					break;
				}
			}

			//  연속 발음 있으면 다음 타겟으로
			if(invalid) continue;

			for(String b : babb) target = target.replaceAll(b," ");

			//  공백 제거 후 문자열이 비어있으면 answer++;
			if(target.trim().isEmpty()) answer++;
		}

		return answer;
	}
}

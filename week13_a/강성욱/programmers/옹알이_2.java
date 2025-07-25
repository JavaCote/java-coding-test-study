package week13_a.강성욱.programmers;

/**
 * PackageName : week13_a.강성욱.programmers
 * FileName    : 옹알이_2
 * Author      : Baekgwa
 * Date        : 2025-07-25
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-25     Baekgwa               Initial creation
 */
public class 옹알이_2 {
	class Solution {
		public int solution(String[] babbling) {
			String[] canSpeak = new String[4];
			canSpeak[0] = "aya";
			canSpeak[1] = "ye";
			canSpeak[2] = "woo";
			canSpeak[3] = "ma";
			int result = 0;

			for(String word : babbling) {
				String lastWord = "";

				//StartWith 로 비교해가면서 그만큼 지우기.
				//방금 지운건, 저장해놓고 다음에 연속된 발음 안되는거에 적용
				while(word.length() != 0) {
					boolean speakCheckComplete = false;
					for(int i=0; i<4; i++) {
						if(word.startsWith(canSpeak[i]) && !canSpeak[i].equals(lastWord)) {
							speakCheckComplete = true;
							lastWord = canSpeak[i];
							word = word.substring(canSpeak[i].length());
							break;
						}
					}

					if(speakCheckComplete == false) break; //4가지 옹알이 유형중 하나라도 해당하지 않으면 while 문 나가기
				}

				if(word.length() == 0) result++;
			}

			return result;
		}
	}
}

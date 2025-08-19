package week17.김누리.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week17.김누리.programmers
 * FileName    : 단어_변환
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 17.     김누리(NRKim)               Initial creation
 */

/*

1.  words 만큼 반복 ㄱㄱ
2.  체크 항목
  2-1.  words[i]가 기존에 나왔나?
  2-2.  words[i]의 시작 글자가 직전 단어의 마지막 글자와 동일한가
3.  반환 배열 [player 번호, turn 수]

*/

public class 단어_변환 {

	//  예전에 Set 방식으로 풀이를 진행했었음. 그러나 이 때눈 극 초심자 시기였고,
	//  무지성으로 clone coding 했었기 때문에 내 정답이 아님.
	//  그러나 참조가 될 수 있기 때문에 풀이 공유.
	/*public int[] solution(int n, String[] words) {
		Set<String> usedWords = new HashSet<>(); // 중복 단어 체크
		int[] answer = new int [2];
		String lastWord = "";

		for (int i = 0; i < words.length ; i ++) {
			int p = (i%n) + 1; // 사람 수
			int t = (i/n) + 1; // 턴 수
			String w = words[i];

			if(usedWords.contains(w)) {
				answer[0] = p;
				answer[1] = t;
				break;
			}

			if (i > 0 && lastWord.charAt(lastWord.length() - 1) != w.charAt(0)) {
				answer[0] = p;
				answer[1] = t;
				break;
			}
			usedWords.add(w);
			lastWord = w;
		}

		return answer;
	}*/

	//  입력 조건만 보면, 플레이어는 최대 10명 까지고, 게임 진행 턴수도 100 이다 보니,
	//  Set을 써도 좋겠지만, 그냥 이중 for문 돌려서도 풀이가 가능할거라 판단함
	//  왜냐 다돌려도 결국 최대 값이 10 * 1000 >> 1000건 이기 때문이지...
	public int[] solution(int n, String[] words) {
		for(int i = 0; i < words.length; i++) {
			int player = (i%n) + 1;
			int turn = (i/n) + 1;
			String now = words[i]; //  현재 글자.

			//  2번째 이후 순번 부터
			if(i > 0) {
				String prev = words[i-1];

				//  체크항목 2-2번
				if(prev.charAt(prev.length()-1) != now.charAt(0)) {
					return setReturn(player,turn);
				}

				//  체크항목 2-1번
				for(int j = 0; j < i; j++) {
					if(words[j].equals(now)) {
						return setReturn(player,turn);
					}
				}
			}
		};

		return setReturn(0,0);
	}

	//  int[] answer가 굳이 없어도 될것 같아
	//  기교 한번 부려봄.
	private int[] setReturn(int player, int turn) {
		return new int[] {player,turn};
	}
}

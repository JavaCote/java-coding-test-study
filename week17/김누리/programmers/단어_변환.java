package week17.김누리.programmers;

import java.util.LinkedList;
import java.util.Queue;

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
begin : hit
target : cog

words : ["hot", "dot", "dog", "lot", "log", "cog"]

hit > hot > dot > dog > cog

hit > hot : 가운데 값만 변환
hot > dot : 첫 글자만 변환
dot > dog : 마지막 글자 변환
dog > cog : 첫 글자만 변환

그럼 진행 순서

target 값이 words 배열에 없다? >> return 0

target 값이 words 배열에 있다? >> 프로세스 진행

※  단어는 자음 모음 자음 모음 ~~~ 순번
모음을 먼저 변경해 본다 >> 모음 동일 ? >> 첫번째 글자 확인 >> 다음번 자음 확인 >> 변환 진행.

얘는 bfs가 맞는듯....

왜냐 최단 거리 계산이기 때문..

h i t > h o t 변환 경우

자릿수 마다 글자 비교 > 다른 부분이 있다면 해당 부분만 변경 (1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.)

*/

public class 단어_변환 {
	public int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length]; //  방문 체크
		Queue<String[]> q = new LinkedList<>();
		q.offer(new String[] {begin,"0"}); //  시작 단어 && 변환 카운트 큐에 적재

		while(!q.isEmpty()) {
			String[] now = q.poll();
			String b = now[0]; //  현재 단어
			int cnt = Integer.parseInt(now[1]); //  변환 횟수

			//  현재 단어가 변환 대상 타겟인 경우 변환 횟수 반환.
			if (b.equals(target)) return cnt;

			//  words 배열 순회 시작
			for(int i = 0; i < words.length; i++) {
				//  해당 위치를 방문하지 않았고, 변환도 가능한 경우
				if(!visited[i] && canConvert(b,words[i])) {
					visited[i] = true;
					q.offer(new String[] {words[i],Integer.toString(cnt+1)});
				}
			}
		}

		return 0;
	}

	private boolean canConvert(String a, String b) {
		int diff = 0;

		for(int i = 0; i < a.length(); i++) {
			//  현재 단어와 비교 대상 단어가 다른 곳이 1자리 이상인 경우
			if(a.charAt(i) != b.charAt(i) && ++diff > 1) return false;
		}

		return true;
	}
}

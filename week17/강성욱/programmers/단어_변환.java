package week17.강성욱.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week17.강성욱.programmers
 * FileName    : 단어_변환
 * Author      : Baekgwa
 * Date        : 2025-08-21
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-21     Baekgwa               Initial creation
 */
public class 단어_변환 {
	// 현재 단어에서, words 에 있는 것들 중, 한글자만 바꿔서 가능한걸 찾아야함...
	// 그리고 한번 바꾼건, 다시 안바꾸게 visited 처리가 필요.
	// 가장 짧은 방향으로 가면 되니깐, bfs 로 하는게 더 좋아보임.
	// 각 bfs 의 item 은 각자만의 visited 배열을 가지고 있어야함. class 로 선언해두는게 편할듯?

	class Solution {
		public int solution(String begin, String target, String[] words) {
			Queue<Item> q = new LinkedList<>();
			q.offer(new Item(words.length, begin));

			while(!q.isEmpty()) {
				Item item = q.poll();
				// 종료 조건에 걸리는 경우.
				if(item.getNowWord().equals(target)) return item.getDepth();

				//words 를 돌면서, 한단어만 바꿔서 갈 수 있는걸 모두 가보기. bfs
				for(int i=0; i<words.length; i++) {
					String word = words[i];
					if(!possibleToChange(item.getNowWord(), word)) continue;
					if(item.visited[i]) continue;
					item.setTrueVisited(i);
					q.offer(new Item(item, word));
					item.setFalseVisited(i);
				}
			}

			return 0;
		}

		private boolean possibleToChange(String nowWord, String targetWord) {
			int diffCnt = 0;

			for(int i=0; i<nowWord.length(); i++) {
				char a = nowWord.charAt(i);
				char b = targetWord.charAt(i);

				if(a != b) diffCnt++;
				if(diffCnt > 1) {
					return false;
				}
			}
			// 혹시모르니, 같은 문자열 비교하는 경우, false 로 처리... 그럴수는 없긴 하지만
			return diffCnt == 1 ? true : false;
		}

		public static class Item {
			private boolean[] visited;
			private String nowWord;
			private int depth;

			public Item(int n, String nowWord) {
				this.visited = new boolean[n];
				this.nowWord = nowWord;
				this.depth = 0;
			}

			public Item(Item item, String nextWord) {
				this.visited = Arrays.copyOf(item.getVisited(), item.getVisited().length);
				this.nowWord = nextWord;
				this.depth = item.getDepth() + 1;
			}

			public int getDepth() { return this.depth; }
			public String getNowWord() { return this.nowWord; }
			public boolean[] getVisited() { return this.visited; }

			public void setTrueVisited(int index) { this.visited[index] = true; }
			public void setFalseVisited(int index) { this.visited[index] = false; }
		}
	}
}

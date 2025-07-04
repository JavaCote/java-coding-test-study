package week5.김상진.programmers;

import java.util.Arrays;

/**
 * PackageName : week5.김상진.programmers
 * FileName    : 피로도
 * Author      : sangxxjin
 * Date        : 2025. 5. 26.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 26.     sangxxjin               Initial creation
 */
public class 피로도 {
	// 1차 시도: 최소 필요 피로도, 소모 피로도 기준으로 각각 정렬 후 탐험 가능한 던전 수를 계산
	// → 하지만 이 방식은 탐험 순서가 고정되기 때문에 일부 케이스에서 최대값을 구하지 못함 (예: 특정 순서에서만 가능한 조합이 존재함)
	// → 이 문제는 "던전 탐험 순서"에 따라 결과가 달라지므로, 모든 순열을 탐색해야 함
	// 따라서 DFS(백트래킹)를 사용해 가능한 모든 경로를 탐색하고, 최대로 탐험한 개수를 추적함
	import java.util.*;
	class Solution {
		public int solution(int k, int[][] dungeons) {
			Arrays.sort(dungeons,(a,b) -> a[0]-b[0]);
			int sub=k;
			int firstResult =0;
			for(int[] arr : dungeons){
				if(arr[0]<=k){
					k-=arr[1];
					firstResult++;
				}
			}
			int secondResult = 0;
			Arrays.sort(dungeons,(a,b) -> a[1]-b[1]);
			for(int[] arr : dungeons){
				if(arr[0]<=sub){
					sub-=arr[1];
					secondResult++;
				}
			}
			return Math.max(firstResult, secondResult);
		}
	}
	// dfs
	import java.util.*;
	class Solution {
		boolean[] visited;
		int max = 0;
		public int solution(int k, int[][] dungeons) {
			visited = new boolean[dungeons.length];
			dfs(k,dungeons,0);
			return max;
		}
		void dfs(int k, int[][] dungeons, int depth){
			max = Math.max(max,depth);
			for(int i=0; i<dungeons.length; i++){
				if(!visited[i] && k>=dungeons[i][0]){
					visited[i]=true;
					// 피로도를 소모한 k 전달, depth 증가 즉 다음 값 진입
					dfs(k-dungeons[i][1],dungeons, depth+1);
					visited[i]=false;
				}
			}

		}
	}
}

package week39.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PackageName : week39.강성욱.baekjoon
 * FileName    : 이전_순열
 * Author      : Baekgwa
 * Date        : 26. 2. 2.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 2. 2.     Baekgwa               Initial creation
 */
public class 이전_순열 {
	public class Main {
		// 5 4 3 1 2 일때는?
		// 5 4 2 3 1 이 바로 그전임
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] numbArray = new int[N];
			for(int i=0; i<N; i++) {
				numbArray[i] = Integer.parseInt(st.nextToken());
			}

			// 변경해야 하는 인덱스 지점 확인
			// 이 지점은, 뒤에서부터 확인하는데 가장 먼저 오름차순이 되는 구간
			int beforeVal = Integer.MAX_VALUE;
			int targetIdx = -1;
			for(int idx=N-1; idx>=0; idx--) {
				// 이전과 대비해서 이번께 더 크다면?
				if(beforeVal < numbArray[idx]) {
					targetIdx = idx;
					break;
				}

				beforeVal = numbArray[idx];
			}

			// 만약 쭉 내림차순으로 진행되면, 이전 순열은 존재하지 않음.
			if(targetIdx == -1) {
				System.out.println(-1);
				return;
			}

			// targetIdx 기준으로, 아래쪽 탐색해면서 가장 큰거 찾기
			// 그친구랑 바꿔야함
			// 나머지는 모두 List 에 담아뒀다가 정렬해서 붙이기
			List<Integer> tempList = new ArrayList<>();
			tempList.add(numbArray[targetIdx]);
			for(int idx=targetIdx+1; idx<N; idx++) {
				tempList.add(numbArray[idx]);
			}

			tempList.sort((a, b) -> Integer.compare(b, a));

			int targetVal = numbArray[targetIdx];
			int bestCandidate = -1;

			for(int i=0; i<tempList.size(); i++) {
				if(tempList.get(i) < targetVal) {
					bestCandidate = tempList.get(i);
					tempList.remove(i);
					break;
				}
			}

			// 정렬해서 만들기
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<targetIdx; i++) {
				// 그 전까지는 그대로 고정
				sb.append(numbArray[i]).append(" ");
			}

			// 가장 큰거 넣기
			sb.append(bestCandidate).append(" ");

			// 나머지는 정렬해서 넣기
			// 더 큰순서대로 정렬해서 넣는게 맞음.
			tempList.sort((a, b) -> Integer.compare(b, a));

			for (int now : tempList) {
				sb.append(now).append(" ");
			}

			System.out.println(sb);
		}
	}
}

package week33.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * PackageName : week33.강성욱.baekjoon
 * FileName    : 카약과_강풍
 * Author      : Baekgwa
 * Date        : 25. 12. 16.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 16.     Baekgwa               Initial creation
 */
public class 카약과_강풍 {
	public class Main {
		// 5팀
		// 2팀 부서짐
		// 1팀 여분
		// 1팀 ... 5팀
		// 1, 0, 2, 0, 1
		// 1, 1, 1, 0, 1
		// 범위도 안크고 그냥 구현하면 되지 않나?
		// 뒤에꺼 빌려올 수 있음? 아니면 앞에꺼? 확인해서 처리하면 될듯
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st  = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 팀수
			int S = Integer.parseInt(st.nextToken());// 손상된 카약 개수
			int R = Integer.parseInt(st.nextToken()); // 더 가져온 팀의 개수

			int[] map = new int[N];
			Arrays.fill(map, 1);

			// 손상된 팀 처리
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<S; i++) {
				int index = Integer.parseInt(st.nextToken()) - 1;
				--map[index];
			}

			// 더 가져온 팀 개수 처리
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<R; i++) {
				int index = Integer.parseInt(st.nextToken()) - 1;
				++map[index];
			}

			// 탐색하면서 처리
			int failCount = 0;
			for(int i=0; i<N; i++) {
				if(map[i] >= 1) continue; // 1개 이상 있으면 넘어가

				// 앞뒤로 확인해서 빌려올 수 있는지 확인
				if(i != 0 && map[i-1] >= 2) {
					--map[i-1];
					continue;
				}
				if(i != N-1 && map[i+1] >= 2){
					--map[i+1];
					continue;
				}

				failCount++;
			}

			System.out.println(failCount);
		}
	}
}

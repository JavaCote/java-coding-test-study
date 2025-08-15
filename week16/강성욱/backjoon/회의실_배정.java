package week16.강성욱.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * PackageName : week16.강성욱.backjoon
 * FileName    : 회의실_배정
 * Author      : Baekgwa
 * Date        : 2025-08-12
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-12     Baekgwa               Initial creation
 */
public class 회의실_배정 {
	public class Main {
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int n = Integer.parseInt(br.readLine());
			int[][] info = new int[n][2]; // idx 0 = 시작, idx-1 = 종료

			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(info, (a, b) -> {
				if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
				return Integer.compare(a[1], b[1]);
			});

			int endTime = 0;
			int cnt = 0;
			for(int[] now : info) {

				// 만약, 마지막에 넣은 회의가 아직 끝나지 않았다면, 처리 불가
				int nowStartTime = now[0];
				if(endTime > nowStartTime) continue;
				cnt++;
				endTime = now[1];
			}

			System.out.println(cnt);
		}
	}
}

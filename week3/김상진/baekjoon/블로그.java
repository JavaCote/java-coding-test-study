package week3.김상진.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week3.김상진.baekjoon
 * FileName    : 블로그
 * Author      : sangxxjin
 * Date        : 2025. 5. 16.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 16.     sangxxjin               Initial creation
 */
public class 블로그 {
import java.io .*;
import java.util .*;

	public class Main {
		// 문제보자마자 슬라이딩 윈도우 문제라고 판단
		// X만큼 뒷 인덱스들의 합을 for문을 사용했더니 시간 초과가 나옴 문제를 다시보니
		// X와 N은 최대 250,000 즉 250,000의 제곱은 무조건 시간을 초과할 수 밖에 없음
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			//미리 합 계산
			int sum = 0;
			for (int i = 0; i < X; i++) {
				sum += arr[i];
			}

			int max = sum;
			int count = 1;

			for (int i = X; i < N; i++) {
				//미리 계산한 합에 새로운 값을 추가하고 오래된 값을 제거
				sum = sum + arr[i] - arr[i - X];

				if (sum > max) {
					max = sum;
					count = 1;
				} else if (sum == max) {
					count++;
				}
			}

			if (max == 0)
				sb.append("SAD");
			else {
				sb.append(max).append("\n").append(count);
			}

			System.out.println(sb);
		}
	}
}
package week36.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week36.강성욱.baekjoon
 * FileName    : 도영이가_만든_맛있는_음식
 * Author      : Baekgwa
 * Date        : 26. 1. 7.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 7.     Baekgwa               Initial creation
 */
public class 도영이가_만든_맛있는_음식 {
	public class Main {
		// 먼저 생각나는건, 재료의 개수를 모든 조합에 넣어보기
		// 줄일 수 있나?
		// 정렬해두면? 너무 까다롭다.
		// 10개니깐 할만 할꺼 같기두?
		// 2^10 = 1024 조합 인데, 1개 공집합 빼면 1023개네

		private static long minDiff = Long.MAX_VALUE;
		private static int N;
		private static Material[] materials;

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			N = Integer.parseInt(br.readLine()); // 재료의 개수
			materials = new Material[N];
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st =  new StringTokenizer(br.readLine());
				long sour = Long.parseLong(st.nextToken());
				long bitter = Long.parseLong(st.nextToken());
				materials[i] = new Material(sour, bitter);
			}

			// 재귀 함수를 통한 min 값 확인
			back(0, 1, 0, 0);

			System.out.println(minDiff);
		}

		public static void back(int idx, long beforeSour, long beforeBitter, int count) {
			if (idx == N) {
				if (count == 0) return; // 다 안뽑는 경우 패스
				minDiff = Math.min(minDiff, Math.abs(beforeSour - beforeBitter));
				return;
			}

			long nowSour = beforeSour * materials[idx].getSour();
			long nowBitter = beforeBitter + materials[idx].getBitter();

			back(idx + 1, nowSour, nowBitter, count + 1);
			back(idx + 1, beforeSour, beforeBitter, count);
		}

		public static class Material {
			private final long sour; // 신맛
			private final long bitter; // 쓴맛

			public Material(long sour, long bitter) {
				this.sour = sour;
				this.bitter = bitter;
			}

			public long getSour() {
				return sour;
			}

			public long getBitter() {
				return bitter;
			}
		}
	}
}

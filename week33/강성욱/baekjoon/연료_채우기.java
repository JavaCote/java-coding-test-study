package week33.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * PackageName : week33.강성욱.baekjoon
 * FileName    : 연료_채우기
 * Author      : Baekgwa
 * Date        : 25. 12. 16.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 16.     Baekgwa               Initial creation
 */
public class 연료_채우기 {
	public class Main {

		// 이번 주유소를 들려야 하는지 아닌지는 그 뒤에 주유소의 정보들을 다 확인해야 확인 가능...
		// 뒤에서부터 확인하는게 정답이 될 수 있나?
		// 이것도 마찬가지로 최선이 아님
		// 음? 모르게다

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int N = Integer.parseInt(br.readLine()); // 주유소 개수
			PriorityQueue<Integer> oil = new PriorityQueue<>(Collections.reverseOrder()); // 지나온 곳 중, 오일 양 기준 PQ
			PriorityQueue<GasStation> pos = new PriorityQueue<>(Comparator.comparingInt(a -> a.pos)); // 주유소 위치

			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // 시작위치 에서 주유소 까지의 거리
				int b = Integer.parseInt(st.nextToken()); // 주유소에서 채울 수 있는 연료의 양
				pos.offer(new GasStation(a, b));
			}

			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); // 도착지점
			int P = Integer.parseInt(st.nextToken()); // 현재 가지고 있는 기름

			// 초반 처리
			int nowPos = P; //현재 위치는 기름만큼 갈 수 있음.
			while(!pos.isEmpty()) {
				GasStation peek = pos.peek();
				if(peek.getPos() > nowPos) break;
				oil.offer(pos.poll().getOil());
			}

			// 반복을 통한 주유소 확인
			int visitCount = 0;
			while(L > nowPos) {
				// 도달하지 못했는데, 더이상 추가로 들릴 수 있는 주유소가 없다면, 마을에 도착 불가
				if(oil.isEmpty()) {
					System.out.println(-1);
					return;
				}

				// 아직 도착지점에 도달하지 못함.
				// 가장 큰 기름을 주는 주유소를 들렸다고 가정하고, pq 에서 뽑아쓰기
				Integer heapOil = oil.poll();
				nowPos += heapOil; // 최대 기름만큼 추가로 이동
				visitCount++; // 주유소 방문 횟수 증가

				// 이동한 만큼, 주유소 정보 업데이트
				while(!pos.isEmpty()) {
					GasStation peek = pos.peek();
					if(peek.getPos() > nowPos) break;
					oil.offer(pos.poll().getOil());
				}
			}

			System.out.println(visitCount);
		}

		public static class GasStation {
			private final int pos;
			private final int oil;

			public GasStation(int pos, int oil) {
				this.pos = pos;
				this.oil = oil;
			}

			public int getPos() {
				return pos;
			}

			public int getOil() {
				return oil;
			}
		}
	}
}

package week24.강성욱.baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * PackageName : week24.강성욱.baekjoon
 * FileName    : 체스판_다시_칠하기
 * Author      : Baekgwa
 * Date        : 2025-10-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-17     Baekgwa               Initial creation
 */
public class 체스판_다시_칠하기 {
	// 8x8 이 체스판
	// 최대, 50 x 50
	// 하나 탐색하는데, 64만큼 소모
	// 50 x 50 일때?
	// (50 - 8 + 1) * (50 - 8 + 1) * 64 = 118336
	// 할만한듯
	public class Main {

		public static final String WHITE = "W";
		public static final String BLACK = "B";
		public static String[][] map;

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int maxY = Integer.parseInt(st.nextToken());
			int maxX = Integer.parseInt(st.nextToken());
			map = new String[maxY][maxX];

			for(int y = 0; y < maxY; y++) {
				String line = sc.nextLine();
				String[] xArray = line.split("");
				for(int x = 0; x < maxX; x++) {
					map[y][x] = xArray[x];
				}
			}

			// 반복해서, 최소 개수 확인
			int changeMin = Integer.MAX_VALUE;

			// 전체 순환
			for(int startY = 0; startY < (maxY - 8 + 1); startY++) {
				for(int startX = 0; startX < (maxX - 8 + 1); startX++) {
					changeMin = Math.min(changeMin, checkCount(startX, startY, WHITE));
					changeMin = Math.min(changeMin, checkCount(startX, startY, BLACK));
				}
			}

			System.out.println(changeMin);
		}

		private static int checkCount(int startX, int startY, String leftTopColor) {
			String startColor = leftTopColor;
			int nowChangeCount = 0;

			for(int y=startY; y < startY + 8; y++) {
				String nowColor = startColor;
				for(int x=startX; x< startX + 8; x++){
					if(!map[y][x].equals(nowColor)) nowChangeCount++;
					nowColor = nowColor.equals(BLACK) ? WHITE : BLACK;
				}
				startColor = startColor.equals(BLACK) ? WHITE : BLACK;
			}

			return nowChangeCount;
		}
	}
}

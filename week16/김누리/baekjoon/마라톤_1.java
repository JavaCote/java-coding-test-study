package week16.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * PackageName : week16.김누리.baekjoon
 * FileName    : 마라톤_1
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-13
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 13.     김누리(NRKim)               Initial creation
 */

/*
*
* 1번쨰 줄 : 체크 포인트 수
* 2 ~ N번쨰 줄  > x좌표 y좌표
*
* 로직 흐름
*
* 시작 ==> 0 0 : (0,0)
*
* 0,0 -> 8,3 -> 10,0 ==> 이동 거리 : 0,0 -> 8,3 (8 +3 == 11), 8,3 -> 10,0 (2 + (3) == 5) == 16
* 0,0 -> 11 ,1 -> 10,0 ==> 이동 거리 : 14
*
* 거리 = (x2 - x1) + (y2 - y1)
*/

public class 마라톤_1 {
	static class Spot {
		int x, y;

		Spot(int x, int y) {this.x = x; this.y = y;}
	}

	public static int dist(Spot a, Spot b ) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //  1번째 줄이 총 체크포인트 갯수

		//  체크 포인트 관리용 배열
		Spot[] arr = new Spot[n];

		//  배열에 위치 정리
		for(int i = 0; i < arr.length; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(token.nextToken());
			int right = Integer.parseInt(token.nextToken());
			arr[i] = new Spot(left,right);
		}

		//  전체 거리
		int total = 0;

		//  전체 거리 계산
		for(int i = 1; i < n; i++) {
			total += dist(arr[i-1],arr[i]);
		}

		int max = 0;
		//  스킵 포인트 별 거리 계산
		for(int i = 1; i < n - 1; i++) {
			int keep = dist(arr[i-1],arr[i]) + dist(arr[i],arr[i+1]);
			int skip = dist(arr[i-1],arr[i+1]);
			max = Math.max(max,keep - skip);
		}

		bw.write(String.valueOf(total-max));
		bw.flush();
		bw.close();
	}
}

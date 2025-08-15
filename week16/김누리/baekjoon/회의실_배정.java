package week16.김누리.baekjoon;

import static java.util.Arrays.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * PackageName : week16.김누리.baekjoon
 * FileName    : 회의실_배정
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
* 1번째 줄 = 사용할 수 있는 회의실의 총 갯수
*
*예) 1 4 >> 1 : 회의 시작시간 4 : 회의 끝시간
*
* 처음에  1 4 입장
*
* 다음 3 5 >> 1 4 와 시간 겹침 못씀
*
* 0 6 >> 시간이 겹치게 되어 못씀
*
* 5 7 >> 1 4와 시간이 안겹침 5 7 이용 가능 >> 현재 1 4, 5 7
*
* 3 8 >> 시간이 겹침 1  3 4 5  7 8 >> 불가
* 5 9 >> 시간이 겹침
*
* 6 10   1   4 5 6 7 >> 5-7과 시간이 겹침
*
* 8 11  >> 시간이 겹치지 않음 1   4 5  7 8   11
* 8 12 >> 8 11과 겹쳐서 안됨
* 2 13 >> 시간 겹침
* 12 14 >> 1   4 5  7 8   11 12  14
*
* ※  그래서 1 4, 5 7, 8 11, 12 14로 등록이 가능
*
*/

public class 회의실_배정 {
	static class Meeting {
		int s,e;
		Meeting(int s, int e) {this.s = s; this.e = e; };
	}

	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());

		//  회의시간 관리용 배열
		Meeting[] arr = new Meeting[n];

		//  회의시간 배열에 등록
		for(int i = 0 ;i < arr.length; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tk.nextToken());
			int end = Integer.parseInt(tk.nextToken());
			arr[i] = new Meeting(start,end);
		}

		//  끝시간 기준 배열 정렬
		sort(arr,(a1,a2) -> {
			if(a1.e != a2.e) return Integer.compare(a1.e, a2.e);
			return Integer.compare(a1.s,a2.s);
		});

		int cnt = 0;
		int lastEnd = -1;  //  아무도 회의 시간을 회의실에 기록하지 않음

		for(Meeting m : arr ) {
			//  시작시간이 마지막 회의 종료 시간 보다 큰 경우에만 cnt 증가
			if (m.s >= lastEnd) {
				cnt++;
				lastEnd = m.e;
			}
		}

		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}

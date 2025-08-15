package week16_a.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * PackageName : week16_a.김누리.baekjoon
 * FileName    : 비밀번호_찾기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-15
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 15.     김누리(NRKim)               Initial creation
 */

/*
*
* 입력
* 1번째 줄 : 사이트 주소의 수_비밀번호를 찾으려는 사이트 수
* 예 ) 16 4 >> 사이트 주소 수 : 16, 비밀번호 찾이려는 사이트 수 4
*
* 2번째 줄 ~ N번째 줄 : 사이트 주소_비밀번호
* 예 ) noj.am_IU > 사이트 주소 : noj.am, 비밀번호 : IU
*
* 출력
* 비밀번호를 찾으려는 사이트 주소의 비밀번호를 출력.
*
*
* 총 입력셋
*
* noj.am IU
* acmicpc.net UAENA
* startlink.io THEKINGOD
* google.com ZEZE
* nate.com VOICEMAIL
* naver.com REDQUEEN
* daum.net MODERNTIMES
* utube.com BLACKOUT
* zum.com LASTFANTASY
* dreamwiz.com RAINDROP
* hanyang.ac.kr SOMEDAY
* dhlottery.co.kr BOO
* duksoo.hs.kr HAVANA
* hanyang-u.ms.kr OBLIVIATE
* yd.es.kr LOVEATTACK
* mcc.hanyang.ac.kr ADREAMER
* startlink.io       >>  대상 1
* acmicpc.net        >>  대상 2
* noj.am             >>  대상 3
* mcc.hanyang.ac.kr  >> 대상 4
*
*
*/
public class 비밀번호_찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String first = br.readLine(); //  첫번째 줄 읽음
		String[] part = first.split(" ");
		int[] lines = new int[2]; //  각 라인수 정리
		lines[0] = Integer.parseInt(part[0]);
		lines[1] = Integer.parseInt(part[1]);

		Map<String,String> map = new HashMap<>();


		//  16개 사이트 비밀번호 저장
		for(int i = 0; i < lines[0]; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			String site = tk.nextToken();
			String pw = tk.nextToken();

			map.put(site,pw);
		}

		//  나머지 4 사이트에 대해pw 설정
		for(int i = 0; i < lines[1]; i++) {
			String site = br.readLine();
			bw.write(map.get(site) + "\n");
		}

		bw.flush();
		bw.close();
	}
}

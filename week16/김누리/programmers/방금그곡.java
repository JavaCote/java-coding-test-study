package week16.김누리.programmers;

/**
 * PackageName : week16.김누리.programmers
 * FileName    : 방금그곡
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 10.     김누리(NRKim)               Initial creation
 */


/*
m = 멜로디 ("ABCDEFG")

musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}

시작 = 12:00
끝 = 12:14
제목 HELLO
멜로디 = CDEFGAB

시작 = 13:00
끝 = 13:05
제목 WORLD
멜로디 = ABCDEF

근데 멜로디 1개당 1분이라 가정하면. HELLO는 멜로디 전체 사이즈가 2번 반복 되야함
근데 WORLD는 5분이거 멜로디 길이는 6이라 마지막 멜로디가 스킵됨


*/

public class 방금그곡 {
	public String solution(String m, String[] musicinfos) {
		String me = norm(m);
		int bestLen = -1;
		String bestTitle = "(None)";

		for(String s : musicinfos) {
			String[] tmp = s.split(",");
			int start = toSecond(tmp[0]);
			int end = toSecond(tmp[1]);
			int play = end - start;
			String title = tmp[2];
			String melody = tmp[3];
			if (play <= 0) continue;

			String t = norm(melody);

			StringBuilder sb = new StringBuilder(play);

			for(int i = 0; i < play ; i++) {
				sb.append(t.charAt(i % t.length()));
			}

			String played = sb.toString();

			if(played.contains(me)) {
				if(play > bestLen) {
					bestLen = play;
					bestTitle = title;
				}
			}

		}

		return bestTitle;
	}

	private int toSecond(String min) {
		String[] m = min.split(":");

		return Integer.parseInt(m[0]) * 60 + Integer.parseInt(m[1]);
	}

	private String norm (String melody) {
		return melody
			.replace("C#","c")
			.replace("D#","d")
			.replace("F#","f")
			.replace("G#","g")
			.replace("A#","a")
			.replace("B#","b");
	}
}

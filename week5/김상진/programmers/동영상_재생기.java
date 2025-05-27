package week5.김상진.programmers;

/**
 * PackageName : week5.김상진.programmers
 * FileName    : 동영상_재생기
 * Author      : sangxxjin
 * Date        : 2025. 5. 27.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 27.     sangxxjin               Initial creation
 */
public class 동영상_재생기 {
	// 문제를 잘 읽으면 큰 어려움 없는 문제였음.
	// 다만 String.format 처럼 1자리 수일때 앞에 0 붙이는 건 몰라서 구글링함
	// 전부 초 단위로 변환 후 계산
	// v, o_start, o_end는 전역으로 관리
	class Solution {
		int v;
		int o_start;
		int o_end;
		public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
			v = Integer.parseInt(video_len.split(":")[0])*60 + Integer.parseInt(video_len.split(":")[1]);
			int p = Integer.parseInt(pos.split(":")[0])*60 + Integer.parseInt(pos.split(":")[1]);
			o_start = Integer.parseInt(op_start.split(":")[0])*60 + Integer.parseInt(op_start.split(":")[1]);
			o_end = Integer.parseInt(op_end.split(":")[0])*60 + Integer.parseInt(op_end.split(":")[1]);
			if(isBetweenOpening(p))p=o_end;
			for(String command : commands){
				if(command.equals("next"))p=next(p);
				if(command.equals("prev"))p=prev(p);
				if(isBetweenOpening(p))p=o_end;
			}
			return String.format("%02d:%02d", p / 60, p % 60);
		}
		private int next(int time){
			time+=10;
			if(time>v)time=v;
			return time;
		}
		private int prev(int time){
			time-=10;
			if(time<0)time=0;
			return time;
		}
		private boolean isBetweenOpening(int time){
			if(o_start<=time && time<=o_end)return true;
			return false;
		}
	}
}

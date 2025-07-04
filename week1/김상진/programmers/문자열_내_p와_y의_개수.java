package week1.김상진.programmers;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 문자열_내_p와_y의_개수
 * Author      : sangxxjin
 * Date        : 2025. 4. 27.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 27.     sangxxjin               Initial creation
 */
public class 문자열_내_p와_y의_개수 {
	boolean solution(String s) {
		s=s.toLowerCase();
		int pCount=0;
		int yCount=0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='p')pCount++;
			if(s.charAt(i)=='y')yCount++;
		}
		if(pCount!=yCount)return false;
		return true;
	}
}

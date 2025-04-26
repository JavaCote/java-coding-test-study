package week1.김상진.programmers;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 하샤드_수
 * Author      : sangxxjin
 * Date        : 2025. 4. 28.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 28.     sangxxjin               Initial creation
 */
public class 하샤드_수 {
	public boolean solution(int x) {
		int sum = 0;
		int originalX = x;
		while(x > 0){
			sum += x % 10;
			x /= 10;
		}

		if(originalX % sum != 0) return false;

		return true;
	}
}

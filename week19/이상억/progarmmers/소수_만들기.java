/**
 * PackageName : week19.이상억.progarmmers;
 * FileName    : 소수_만들기
 * Author      : sangeok
 * Date        : 2025. 09. 01.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 01.     sangeok               Initial creation
 */



class Solution {
    public int solution(int[] nums) {
        int answer = -1;
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len - 2; i++){
            for(int j = i+1 ; j < len -1; j++){
                for(int k = j+1; k < len; k ++){
                    int sum = nums[i] + nums[j] + nums[k];

                    if(is_valid(sum)) count ++;
                }
            }
        }

        return count;
    }

    public boolean is_valid(int sum){

        int count = 0;
        for(int i = 1; i <sum; i++){
            if(sum % i == 0) count ++;
        }
        if(count == 1) return true;
        return false;

    }

}
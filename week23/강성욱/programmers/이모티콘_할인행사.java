package week23.강성욱.programmers;

/**
 * PackageName : week23.강성욱.programmers
 * FileName    : 이모티콘_할인행사
 * Author      : Baekgwa
 * Date        : 2025-10-03
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-03     Baekgwa               Initial creation
 */
public class 이모티콘_할인행사 {
	class Solution {
		private static final int[] DISCOUNT_RATES = {10, 20, 30, 40};
		private int maxPlusSubscribers = -1;
		private int maxSalesAmount = -1;

		public int[] solution(int[][] users, int[] emoticons) {
			int numEmoticons = emoticons.length;
			int[] assignedDiscountIndices = new int[numEmoticons];

			// dfs
			findBestCombination(0, users, emoticons, assignedDiscountIndices);

			return new int[]{maxPlusSubscribers, maxSalesAmount};
		}

		private void findBestCombination(int emoticonIndex, int[][] users, int[] emoticons, int[] assignedDiscountIndices) {
			if (emoticonIndex == emoticons.length) {
				calculateOutcome(users, emoticons, assignedDiscountIndices);
				return;
			}

			for (int rateIndex = 0; rateIndex < 4; rateIndex++) {
				assignedDiscountIndices[emoticonIndex] = rateIndex;
				findBestCombination(emoticonIndex + 1, users, emoticons, assignedDiscountIndices);
			}
		}

		private void calculateOutcome(int[][] users, int[] emoticons, int[] assignedDiscountIndices) {
			int currentPlusSubscribers = 0;
			int currentSalesAmount = 0;

			for (int[] user : users) {
				int userRequiredDiscount = user[0];
				int userSubscriptionThreshold = user[1];
				int userPurchaseTotal = 0;

				for (int i = 0; i < emoticons.length; i++) {
					int currentDiscountRate = DISCOUNT_RATES[assignedDiscountIndices[i]];

					if (currentDiscountRate >= userRequiredDiscount) {
						userPurchaseTotal += emoticons[i] * (100 - currentDiscountRate) / 100;
					}
				}

				if (userPurchaseTotal >= userSubscriptionThreshold) {
					currentPlusSubscribers++;
				} else {
					currentSalesAmount += userPurchaseTotal;
				}
			}

			if (currentPlusSubscribers > maxPlusSubscribers) {
				maxPlusSubscribers = currentPlusSubscribers;
				maxSalesAmount = currentSalesAmount;
			} else if (currentPlusSubscribers == maxPlusSubscribers && currentSalesAmount > maxSalesAmount) {
				maxSalesAmount = currentSalesAmount;
			}
		}
	}
}

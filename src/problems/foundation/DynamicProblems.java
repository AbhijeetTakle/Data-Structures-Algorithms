package problems.foundation;

public class DynamicProblems {
	
	static int knapSack(int[] wt, int[] val, int w, int n) {
		
		int[][] dp = new int[n+1][w+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<w+1; j++) {
				if(j >= wt[i-1]) {
					dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][w];		
		
	}
	
	static boolean subsetSum(int[] arr, int n, int sum) {
		
		boolean [][] dp = new boolean[n+1][sum+1];
		for(int i=0; i<n+1; i++) {
			dp[i][0] = true;
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1 ; j<sum+1; j++) {
				if(j>=arr[i-1]) {
					dp[i][j] = (dp[i-1][j-arr[i-1]]==true || dp[i-1][j]==true);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
		
	}
	
	static boolean equalSumPartition(int[] arr, int n) {
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += arr[i];
		}
		if(sum%2!=0) {
			return false;
		}		
		return subsetSum(arr, n, sum/2);
		
	}
	
	static int countSubsetSum(int[] arr, int n, int sum) {
		
		int[][] dp = new int[n+1][sum+1];
		for(int i=0; i<n+1; i++) {
			if(i>1 && arr[i-1]==0) {
				dp[i][0] = 2;
			}else {
				dp[i][0] = 1;				
			}
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(j>=arr[i-1]) {
					dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
		
	}
	
	static int minSubsetSumDiff(int[] arr, int n) {
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += arr[i];
		}
		int[][] dp = new int[n+1][sum+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(j>=arr[i-1]) {
					dp[i][j] = Math.min(Math.abs(sum-dp[i-1][j-arr[i-1]]+arr[i-1]), sum-dp[i-1][j]);
				}else {
					dp[i][j] = sum-dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
		
	}

	public static void main(String[] args) {
		
//		System.out.println(knapSack(new int[] {1, 3, 4, 5}, new int[] {1, 4, 5, 7}, 7, 4));
//		System.out.println(subsetSum(new int[] {1, 3, 4, 5}, 4, 2));
//		System.out.println(equalSumPartition(new int[] {1, 3, 3, 5, 14}, 5));
//		System.out.println(countSubsetSum(new int[] {1, 3, 4, 5}, 4, 2));
		System.out.println(minSubsetSumDiff(new int[] {1, 3, 4, 5}, 4));
		

	}

}

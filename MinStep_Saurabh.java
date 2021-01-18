class MinStep_Saurabh
{ 


     static int row=4,column=5; 

     // Main Method 
    public static void main(String args[]) 
   { 
	    int arr[][] = { { 1, 1, 1, 0, 1 }, 
					{ 1, 0, 0, 0, 1 }, 
					{ 0, 0, 1, 0, 1 }, 
					{ 1, 0, 1, 1, 0 } }; 

	    MinStep_Saurabh mns = new MinStep_Saurabh();

	    System.out.println( mns.minStepsForBoundary( row, column, arr)); 
   } 

// Method to get minimum steps 
public int minStepsForBoundary(int n, int m, int arr[][]) 
{ 
	
	// current position 
	int x = 1; 
	int y = 2; 

	// find '2' in the ArrayList or Matrix
	for (int i = 0; i < n; i++) { 
		for (int j = 0; j < m; j++) { 
			if (arr[i][j] == 2) { 
				x = i; 
				y = j; 
				break; 
			} 
		} 
		if (x != -1) 
			break; 
	} 

	// Initialize dp ArrayList or Matrix with -1 
	int dp[][]=new int[row][row]; 
	for(int j=0;j<row;j++) 
	for(int i=0;i<row;i++)dp[j][i]=-1; 

	// Initialize vis ArrayList or Matrix with false 
	boolean vis[][]= new boolean[row][row]; 
	for(int j=0;j<row;j++) 
	for(int i=0;i<row;i++)vis[j][i]=false; 

	// Call method to find out minimum steps  
	int res = MinStepsFind(arr, x, y, dp, vis); 

	// if steps not possible 
	if (res >= 1e9) 
		return -1; // then it will return -1
	else
		return res; 
} 

// Method to find out minimum steps 
public int MinStepsFind(int arr[][], int n, int m, int dp[][], boolean vis[][]) 
{ 
	// boundary edges reached 
	if (n == 0 || m == 0 || n == (row - 1) || m == (column - 1)) { 
		return 0; 
	} 

	// if route found , then no need to visit the position again 
	if (dp[n][m] != -1) 
		return dp[n][m]; 

	// visiting position 
	vis[n][m] = true; 

	int ans1, ans2, ans3, ans4; 

	ans1 = ans2 = ans3 = ans4 = (int)1e9; 

	// horizontally left 
	if (arr[n][m - 1] == 0) { 
		if (!vis[n][m - 1]) 
			ans3 = 1 + MinStepsFind(arr, n, m - 1, dp, vis); 
	} 

	// horizontally right 
	if (arr[n][m + 1] == 0) { 
		if (!vis[n][m + 1]) 
			ans2 = 1 + MinStepsFind(arr, n, m + 1, dp, vis); 
	} 

	// vertically up 
	if (arr[n - 1][m] == 0) { 
		if (!vis[n - 1][m]) 
			ans1 = 1 + MinStepsFind(arr, n - 1, m, dp, vis); 
	} 

	// vertically down 
	if (arr[n + 1][m] == 0) { 
		if (!vis[n + 1][m]) 
			ans4 = 1 + MinStepsFind(arr, n + 1, m, dp, vis); 
	} 

	// minimum steps of every path 
	dp[n][m] = Math.min(ans1, Math.min(ans2, Math.min(ans3, ans4))); 
	return dp[n][m]; 
} 




} 
 

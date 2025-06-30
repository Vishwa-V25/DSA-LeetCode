64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution
public class Solution {
    public int minPathSum(int[][] grid) {
       int rows=grid.length;
       int cols=grid[0].length;
       int[][] dp=new int[rows][cols];

       dp[0][0]=grid[0][0];
       for(int col=1;col<cols;col++){
        dp[0][col]=grid[0][col]+dp[0][col-1];
       }
       for(int row=1;row<rows;row++){
        dp[row][0]=grid[row][0]+dp[row-1][0];
       }
       for(int row=1;row<rows;row++){
        for(int col=1;col<cols;col++){
            dp[row][col]=grid[row][col] +Math.min(dp[row-1][col],dp[row][col-1]);
        }
       }
      return dp[rows-1][cols-1];
    }
}
  

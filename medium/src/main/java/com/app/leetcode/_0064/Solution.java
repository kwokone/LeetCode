package com.app.leetcode._0064;

import org.junit.Test;

/**
 * ðï¸ 2023/3/10
 * æå°è·¯å¾å
 * è¾å¥ï¼grid = [[1,3,1],[1,5,1],[4,2,1]]
 * è¾åºï¼7
 * è§£éï¼å ä¸ºè·¯å¾ 1â3â1â1â1 çæ»åæå°ã
 * â TODO
 * â FIXME
 *
 * @author Allen
 * @version 0.0.1
 */
public class Solution {


    @Test
    public void test(){
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
//        int res = minPathSum(grid);
        int res = minPathSumV2(grid);
        System.out.println(res);


    }


    public int minPathSumV2(int[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i =1; i < m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for(int i=1; i<m; i++){
            for (int j=1;j<n;j++){
                // ç¶æè½¬ç§»æ¹ç¨
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];

    }

    /**
     * éå½
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        return getMin(grid, m - 1, n - 1);

    }

    private int getMin(int[][] grid, int i, int j) {

        // èµ·ç¹ä½ç½®
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // ç¬¬ä¸è¡
        if (i == 0) {
            return grid[i][j] + getMin(grid, i, j - 1);
        }
        // ç¬¬ä¸å
        if (j == 0) {
            return grid[i][j] + getMin(grid, i - 1, j);
        }

        int minRow = getMin(grid, i - 1, j);
        int minColum = getMin(grid, i, j - 1);

        return grid[i][j] + Math.min(minRow, minColum);


    }


}

import org.junit.Test;

import java.util.*;

/**
 * @Created by zhang on 2021/8/21  15:28
 */
public class LeetCode {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();//网格的长
//        int n = sc.nextInt();//网格的宽
//
//        int[][] grid = new int[m][n];
//        int temp = 0;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                temp = sc.nextInt();
//                if ( temp == 0 ){
//                    grid[i][j] = 2;
//                }else if(temp == 1){
//                    grid[i][j] = 1;
//                }else {
//                    grid[i][j] = -1;
//                }
//
//            }
//        }
        int[][] grid = new int[][]{{1,1,1,1,0},{0,1,0,1,0},{1,1,2,1,1},{0,2,0,0,1}};
        System.out.println(shortestPath(grid));
    }
    public static int shortestPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int temp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp = grid[i][j];
                if ( temp == 0 ){
                    grid[i][j] = 2;
                }else if(temp == 1){
                    grid[i][j] = 1;
                }else {
                    grid[i][j] = -1;
                }
            }
        }
        int res = backtrack(grid,0,0,m,n,0,visited);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int backtrack(int[][] grid,int i,int j,int m,int n,int count,boolean[][] visited){
        if(i < 0 || i >= m || j < 0 || j >= n) return Integer.MAX_VALUE;//递归出口
        if(i == m-1 && j == n-1) return count;//结果
        if(visited[i][j]) return Integer.MAX_VALUE;
        //排除障碍物
        if(grid[i][j] == -1){
            return Integer.MAX_VALUE;
        }
        visited[i][j] = true;
        //取4个方向可能路径的最小值返回
        int min4 = Integer.MAX_VALUE;
        min4 = Math.min(min4,backtrack(grid,i-1,j,m,n,count+1,visited));
        min4 = Math.min(min4,backtrack(grid,i+1,j,m,n,count+1,visited));
        min4 = Math.min(min4,backtrack(grid,i,j-1,m,n,count+1,visited));
        min4 = Math.min(min4,backtrack(grid,i,j+1,m,n,count+1,visited));
        //回溯
        visited[i][j] = false;
        return min4;
    }

}

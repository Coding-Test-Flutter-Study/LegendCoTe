import java.util.*;

class Solution {

    static int [][] DP;
    static int N;

    public int solution(int[][] triangle) {


        N = triangle.length;
        DP = new int [N+1][N+1];

        for(int i=1; i<=N;i++){
            for(int j=1; j<=i;j++){

                DP[i][j]= Math.max(DP[i-1][j],DP[i-1][j-1])+triangle[i-1][j-1];

            }
        }
        int ans = 0;
        for(int j=1; j<=N;j++){
            ans = Math.max(DP[N][j],ans);
        }

        return ans;
    }
}
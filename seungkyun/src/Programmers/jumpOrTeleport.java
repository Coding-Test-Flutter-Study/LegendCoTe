import java.util.*;

public class Solution {

    static int[] DP;

    public int solution(int n) {


        int ans =0;
//         DP= new int[n+1];
//         DP[1]=1;

//         for(int i=2; i<=n;i++){
//             //짝수
//             if(i%2==0){
//             DP[i] = Math.min(DP[i-1]+1, DP[i/2]);
//             } else {
//             //홀수
//             DP[i] = DP[i-1]+1;
//             }
//         }

        // return DP[n];

        while(n>0){
            //짝수
            if(n%2==0){
                n=n/2;
            } else {
                //홀수
                n-=1;
                ans++;
            }
        }

        return ans;
    }
}
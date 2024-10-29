class Solution {

    static int[] DP;

    public int solution(int n) {
        int answer = 0;
        DP = new int[n+1];
        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }
        DP[1]=1;
        DP[2]=2;

        for(int i=3; i<=n;i++){
            DP[i] = (DP[i-1]+DP[i-2])%1000000007;
        }

        return DP[n];
    }
}
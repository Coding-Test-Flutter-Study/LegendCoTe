class Solution {

    static int[][] DP;
    int solution(int[][] land) {
        int answer = 0;

        DP = new int[land.length][4];

        for(int i=0; i<4;i++){
            DP[0][i] = land[0][i];
        }

        for(int i=1; i<land.length;i++){
            for(int j=0; j<4;j++){
                for(int k=0; k<4;k++){
                    if(k==j){
                        continue;
                    }
                    DP[i][j] = Math.max(DP[i-1][k],DP[i][j]);
                }
                DP[i][j] +=land[i][j];
            }
        }

        for(int i=0; i<4;i++){
            answer = Math.max(DP[land.length-1][i],answer);
        }
        return answer;
    }
}
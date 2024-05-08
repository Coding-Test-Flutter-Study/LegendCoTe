class Solution {

    static int max;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        visited = new boolean [dungeons.length];

        dfs(k,dungeons,0);


        return max;
    }


    static void dfs(int K,int[][] dungeon, int times){

        for(int i=0; i<dungeon.length;i++){

            if(!visited[i]&&K>=dungeon[i][0]){
                visited[i] = true;
                dfs(K-dungeon[i][1], dungeon, times+1);
                visited[i] = false;

            }
        }

        max = Math.max(max,times);

    }
}
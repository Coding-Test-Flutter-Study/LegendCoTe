import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int ans=0;
    public int solution(int n, int[][] computers) {

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                if(computers[i][j]==1){
                    map[i][j]=map[j][i]=1;
                }
            }
        }

        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                if(map[i][j]==1){
                    if(!visited[i][j]){
                        visited[i][j]=true;
                        bfs(i,j,n);
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    static void bfs(int i,int j,int n){

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] xy = queue.poll();

            for(int q=0;q<n;q++){
                if(map[xy[1]][q]==1&&!visited[xy[1]][q]){
                    queue.offer(new int[]{xy[1],q});
                    visited[xy[1]][q]=true;
                }
            }

        }

    }
}
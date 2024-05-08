import java.util.Queue;
import java.util.LinkedList;

class Solution {

    static int min;
    static int[][] graph;
    static boolean[] visited;

    static int N;
    static int n1Num,n2Num;
    public int solution(int n, int[][] wires) {

        N=n;

        graph = new int[N+1][N+1];

        for(int i=0; i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];

            graph[a][b]=graph[b][a]=1;

        }
        min = n;

        for(int i=0; i<wires.length;i++){
            int n1 = wires[i][0];
            int n2 = wires[i][1];

            graph[n1][n2]=graph[n2][n1]=0;

            min = Math.min(min,Math.abs(bfs(n1)-bfs(n2)));

            graph[n1][n2]=graph[n2][n1]=1;

        }

        return min;
    }

    static int bfs(int n){
        visited = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        visited[n] = true;
        queue.offer(n);

        int count = 0;

        while(!queue.isEmpty()){

            int newN = queue.poll();
            count++;

            for(int i=1;i<=N;i++ ){

                if(!visited[i]&&graph[i][newN]==1){
                    queue.offer(i);
                    visited[i]=true;
                }
            }
        }


        return count;

    }
}
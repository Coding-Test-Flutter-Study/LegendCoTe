import java.util.*;

class Solution {

    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> ans = new ArrayList<>();

    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N;i++){
            String[] strArray = maps[i].split("");
            for(int j=0; j<M;j++){
                if(strArray[j].equals("X")){
                    map[i][j]=0;
                } else {
                    map[i][j]=Integer.parseInt(strArray[j]);
                }
            }
        }


        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                if(map[i][j]!=0&&!visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        Collections.sort(ans);

        if(ans.isEmpty()){

            return new int[]{-1};
        } else {
            int[] answer = new int[ans.size()];

            for(int i=0; i<answer.length;i++){
                answer[i]=ans.get(i);
            }
            return answer;
        }

    }

    static void bfs(int x, int y){
        int days =0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        visited[x][y]=true;
        days+=map[x][y];

        while(!queue.isEmpty()){

            int[] xy = queue.poll();

            for(int i=0; i<4;i++){
                int newX = xy[0] + dx[i];
                int newY = xy[1] + dy[i];
                if(newX>=0&&newY>=0&&newX<N&&newY<M&&!visited[newX][newY]&&map[newX][newY]!=0){
                    queue.offer(new int[]{newX,newY});
                    visited[newX][newY]=true;
                    days+=map[newX][newY];
                }

            }
        }

        ans.add(days);

    }
}
import java.util.*;

class Solution {

    static int ans1=0,ans2=0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] mapLever;
    static int[][] mapExit;
    static char[][] map;
    static int[] S,E,L;
    static int answer = 0;
    public int solution(String[] maps) {


        mapLever = new int[maps.length][maps[0].length()];
        mapExit = new int[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];

        for(int i=0; i<maps.length;i++){
            for(int j=0; j<maps[0].length();j++){
                map[i][j]= maps[i].charAt(j);
                if(maps[i].charAt(j)=='S'){
                    S = new int[]{i,j};
                }
                if(maps[i].charAt(j)=='E'){
                    E = new int[]{i,j};
                }
                if(maps[i].charAt(j)=='L'){
                    L = new int[]{i,j};
                }
            }
        }

        checkLever(S[0],S[1]);

        if(ans1==0){
            return -1;
        } else {
            checkExit(L[0],L[1]);
        }

        if(ans2==0){
            return -1;
        } else {
            return ans1+ans2;
        }

    }

    static void checkLever(int x, int y){
        boolean[][] visited = new boolean[map.length][map[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){

            int[]xy = queue.poll();

            for(int i=0; i<4;i++){
                int newX = xy[0]+dx[i];
                int newY = xy[1]+dy[i];

                if(newX>=0&&newY>=0&&newX<map.length&&newY<map[0].length&&map[newX][newY]!='X'&&!visited[newX][newY]){
                    queue.offer(new int[]{newX,newY});
                    mapLever[newX][newY] = mapLever[xy[0]][xy[1]]+1;
                    visited[newX][newY]=true;
                    if(map[newX][newY]=='L'){
                        ans1 = mapLever[newX][newY];
                        return;
                    }
                }

            }
        }

        return;

    }

    static void checkExit(int x, int y){
        boolean[][] visited = new boolean[map.length][map[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){

            int[]xy = queue.poll();

            for(int i=0; i<4;i++){
                int newX = xy[0]+dx[i];
                int newY = xy[1]+dy[i];

                if(newX>=0&&newY>=0&&newX<map.length&&newY<map[0].length&&map[newX][newY]!='X'&&!visited[newX][newY]){
                    queue.offer(new int[]{newX,newY});
                    mapExit[newX][newY] = mapExit[xy[0]][xy[1]]+1;
                    visited[newX][newY]=true;
                    if(map[newX][newY]=='E'){
                        ans2 = mapExit[newX][newY];
                        return;
                    }
                }

            }
        }
        return;
    }
}
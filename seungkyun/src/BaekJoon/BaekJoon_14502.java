import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int [][] map;
    static int [][] newMap;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    static int N,M;
    static int ans;
    static ArrayList<int[]> ableWall = new ArrayList<>();
    static ArrayList<int[]> virus = new ArrayList<>();

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        //벽 3개 세우기 - newMap
        // 바이러스 퍼지게 하기 - bfs
        // 지도 0 체크

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        newMap = new int[N][M];


        for(int i=0; i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<M;j++){
                int a = Integer.parseInt(st2.nextToken());
                map[i][j]=a;
                if(a==0){
                    ableWall.add(new int[]{i,j});
                }
                if(a==2){
                    virus.add(new int[]{i,j});
//                    queue.offer(new int[]{i,j});
                }
            }
        }


        for(int i1=0; i1<ableWall.size()-2;i1++){
            for(int i2=i1+1;i2<ableWall.size()-1;i2++){
                for(int i3= i2+1; i3<ableWall.size();i3++){

//                    newMap = map.clone();

                    copy(map,newMap);

                    //  벽
                    newMap[ableWall.get(i1)[0]][ableWall.get(i1)[1]]=1;
                    newMap[ableWall.get(i2)[0]][ableWall.get(i2)[1]]=1;
                    newMap[ableWall.get(i3)[0]][ableWall.get(i3)[1]]=1;


                    for(int i=0; i<virus.size();i++){
                        queue.offer(virus.get(i));
                    }

                    bfs(newMap);

                }
            }
        }



        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void copy(int[][] map, int[][] newMap){

        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                newMap[i][j] = map[i][j];

            }
        }
    }

    static void bfs(int [][] newMaps){


        while (!queue.isEmpty()){

            int[] xy = queue.poll();

            int x = xy[0];
            int y = xy[1];

            for(int i=0; i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];

                if(newX>=0&&newY>=0&&newX<N&&newY<M&&newMaps[newX][newY]==0){
                    queue.offer(new int[]{newX,newY});
                    newMaps[newX][newY]=2;
                }
            }

        }
        checkSafe(newMaps);

    }


    static void checkSafe(int[][] newMaps){

        int safeArea = 0;
        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                if(newMaps[i][j]==0){
                    safeArea++;
                }
            }
        }

        ans = Math.max(ans,safeArea);
    }


}
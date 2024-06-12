import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M,K;
    static int x1,y1,x2,y2;
    static int ans,acre;
    static ArrayList<Integer> area = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<K;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            y1 = Integer.parseInt(st2.nextToken());
            x1 = Integer.parseInt(st2.nextToken());
            y2 = Integer.parseInt(st2.nextToken())-1;
            x2 = Integer.parseInt(st2.nextToken())-1;

            for(int x=0; x<M;x++){
                for(int y=0 ;y<N;y++){
                    if(x1<=x&&x<=x2&&y1<=y&&y<=y2){
                        map[x][y]=1;
                    }
                }
            }
        }

        for(int i=0; i<M;i++){
            for(int j=0 ;j<N;j++){
                if(!visited[i][j]&&map[i][j]!=1){
                    bfs(i,j);
                    ans++;
                    area.add(acre);
                    acre=0;
                }
            }
        }

        bw.write((ans)+"\n");
        Collections.sort(area);
        Iterator<Integer> iterator = area.iterator();
        while (iterator.hasNext()){
            bw.write(iterator.next()+" ");
        }

        bw.flush();
    }

    static void bfs(int x,int y) {

        Queue<int[]> queue = new LinkedList<>();
        visited[x][y]= true;
        queue.offer(new int[]{x,y});

        acre++;
        while (!queue.isEmpty()){

            int[] xy = queue.poll();

            for(int i=0; i<4;i++){
                int newX = xy[0]+dx[i];
                int newY = xy[1]+dy[i];

                if(newX>=0&&newY>=0&&newX<M&&newY<N&&!visited[newX][newY]&&map[newX][newY]!=1){
                    queue.offer(new int[]{newX,newY});
                    visited[newX][newY]= true;
                    acre++;
                }
            }
        }

    }

}
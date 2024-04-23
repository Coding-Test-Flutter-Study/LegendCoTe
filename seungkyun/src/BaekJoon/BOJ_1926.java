import java.io.*;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int [][] map;
    static boolean [][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int n,m;
    static int count;
    static int size;
    static ArrayList<Integer> max = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        StringTokenizer st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j=0; j<m;j++){
                int a = Integer.parseInt(st2.nextToken());
                map[i][j] = a;
            }
        }

        //max랑 count 찾기
        for(int i =0; i<n;i++){
            for(int j=0; j<m;j++){

                if(!visited[i][j]&&map[i][j]!=0){
                    bfs(i,j);

                    count++;
                }

                max.add(size);


            }
        }

        Collections.sort(max);

        bw.write(count+"\n"+max.get(max.size()-1));

        bw.flush();
    }

    static void bfs(int x, int y){

        size = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()){

            int[] array = queue.poll();


            for(int i=0; i<4;i++){
                int newX = array[0]+dx[i];
                int newY = array[1]+dy[i];

                if(newX>=0&&newY>=0){
                    if(newX<n&&newY<m){
                        if(!visited[newX][newY]&&map[newX][newY]!=0){
                            visited[newX][newY]=true;
                            queue.offer(new int[]{newX,newY});
                            map[newX][newY]=size++;
                        }
                    }
                }
            }


        }
    }

}
package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21763 {


        static String[][] map;
        static boolean[][] visited;

        static int N, M;

        static int count;
        static int startN,startM;

        static int[] dn = {1,-1,0,0};
        static int[] dm = {0,0,1,-1};
        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new String[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<N;i++){
                String str = br.readLine();
                String[] strings = str.split("");

                for(int j=0; j<M;j++){
                    map[i][j] = strings[j];
                    if(strings[j].equals("I")){
                        startN = i;
                        startM = j;
                    }
                }
            }
            bfs(startN,startM,visited);

            if(count==0){
                bw.write("TT");
            } else {
                bw.write(String.valueOf(count));

            }

            bw.flush();
        }


        static void bfs(int n, int m, boolean[][] visited) {

            Queue<int[]> queue = new LinkedList<>();
            visited[n][m] = true;

            queue.offer(new int[] {n,m});

            while (!queue.isEmpty()){

                int x = queue.peek()[0];
                int y = queue.peek()[1];



                if(map[x][y].equals("P")){
                    count++;
                }

                queue.poll();

                for(int i=0; i<4;i++){

                    int newN = x+dn[i];
                    int newM = y+dm[i];

                    if(newN>=0&&newM>=0){
                        if(newN<N&&newM<M){
                            if (!visited[newN][newM]&&!map[newN][newM].equals("X")){
                                visited[newN][newM]= true;
                                queue.offer(new int[ ]{newN,newM});
                            }
                        }
                    }
                }
            }

        }

}

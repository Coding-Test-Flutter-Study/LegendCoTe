import java.io.*;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int n, m;

    static int count = 1;
    static int startX, startY;
    static ArrayList<int[]> fireArrayList = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str1 = br.readLine();
            String[] strings = str1.split("");
            for (int j = 0; j < m; j++) {
                String str = strings[j];
                map[i][j] = str;

                //불 좌표 저장
                if (str.equals("F")) {
                    fireArrayList.add(new int[]{i, j});
                }
                //지훈 좌표 저장
                if (str.equals("J")) {
                    startX = i;
                    startY = j;
                }

            }
        }

        //fire
        Queue<int[]> queue = new LinkedList<>();
        //jihoon
        Queue<int[]> queueJ = new LinkedList<>();

        //지훈 시작점
        visited[startX][startY] = true;
        //지훈 큐
        queueJ.offer(new int[]{startX, startY});


        //불 위치 큐 저장
        for (int i = 0; i < fireArrayList.size(); i++) {
            int[] ff = fireArrayList.get(i);
            visited[ff[0]][ff[1]] = true;

            queue.offer(ff);

        }



        if(startX==0||startY==0||startX==n||startY==m){
            bw.write("1");
        } else {

            int ans = bfs(queue,queueJ);

            if(ans ==-1){
                bw.write("IMPOSSIBLE");
            } else {
                bw.write(String.valueOf(ans));
            }
        }




        bw.flush();
    }

    static int bfs(Queue<int[]> queue, Queue<int[]> queueJ){






        while (!queueJ.isEmpty()){

            int fireSize = queue.size();

            //불 위치 이동
            for (int i = 0; i < fireSize; i++) {
                int[] fireXY = queue.poll();

                for (int d = 0; d < 4; d++) {

                    int newFireX = 0;
                    if (fireXY != null) {
                        newFireX = fireXY[0] + dx[d];
                    }
                    int newFireY = 0;
                    if (fireXY != null) {
                        newFireY = fireXY[1] + dy[d];
                    }

                    if (newFireX >= 0 && newFireY >= 0) {
                        if (newFireX < n && newFireY < m) {
                            if (!map[newFireX][newFireY].equals("#") && !visited[newFireX][newFireY]) {
                                visited[newFireX][newFireY] = true;
                                map[newFireX][newFireY] = "F";
                                queue.offer(new int[]{newFireX, newFireY});
                            }
                        }
                    }

                }
            }
            count++;

            int JSize = queueJ.size();


            for(int i=0; i<JSize;i++){
                int[] JiHoonXY = queueJ.poll();

                for (int d = 0; d < 4; d++) {

                    int newJiHoonX = 0;
                    if (JiHoonXY != null) {
                        newJiHoonX = JiHoonXY[0] + dx[d];
                    }
                    int newJiHoonY = 0;
                    if (JiHoonXY != null) {
                        newJiHoonY = JiHoonXY[1] + dy[d];
                    }
                    if (newJiHoonX >= 0 && newJiHoonY >= 0) {
                        if (newJiHoonX < n && newJiHoonY < m) {
                            if (map[newJiHoonX][newJiHoonY].equals(".") && !visited[newJiHoonX][newJiHoonY]) {
                                visited[newJiHoonX][newJiHoonY] = true;


                                map[newJiHoonX][newJiHoonY] = String.valueOf(count);
                                queueJ.offer(new int[]{newJiHoonX, newJiHoonY});

                                if(newJiHoonX==0||newJiHoonX==n-1||newJiHoonY==0||newJiHoonY==m-1){

                                    return Integer.parseInt(map[newJiHoonX][newJiHoonY]);
                                }
                            }
                        }
                    }

                }

            }


        }

        return -1;
    }


}
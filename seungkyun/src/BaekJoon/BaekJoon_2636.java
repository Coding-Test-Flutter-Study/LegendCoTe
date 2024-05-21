import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static int cheezePiece;
    static int cheeze;
    static ArrayList<Integer> cheezesArray = new ArrayList<>();
    static int X, Y;
    static boolean[][] visited;
    static int[][] map;
    static int ans;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new int[X][Y];

        for (int i = 0; i < X; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < Y; j++) {
                int a = Integer.parseInt(st2.nextToken());
                map[i][j] = a;
            }
        }


        while (true){
            cheezePiece=0;
            cheeze=0;
            checkPieces();
            cheezesArray.add(cheeze);
            if(cheezePiece==0){
                break;
            }
            check(0,0);
            melt();

            ans++;
        }

        bw.write(String.valueOf(ans)+"\n"+cheezesArray.get(cheezesArray.size()-2));
        bw.flush();
    }

    static void checkPieces(){
        visited = new boolean[X][Y];

        for(int i=0; i<X;i++){
            for(int j=0; j<Y;j++){
                if(map[i][j]==1&&!visited[i][j]){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] =true;

                    while (!queue.isEmpty()) {

                        cheeze++;

                        int[] xy = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int newX = xy[0] + dx[d];
                            int newY = xy[1] + dy[d];

                            if (newX >= 0 && newY >= 0 && newX < X && newY < Y&&map[newX][newY] == 1&&!visited[newX][newY]) {
                                queue.offer(new int[]{newX,newY});
                                visited[newX][newY]=true;
                            }
                        }
                    }
                    cheezePiece++;
                }
            }
        }
    }

    static void check(int x, int y) {

        visited =new boolean[X][Y];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y]=true;

        while (!queue.isEmpty()) {

            int[] xy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = xy[0] + dx[i];
                int newY = xy[1] + dy[i];

                if (newX >= 0 && newY >= 0 && newX < X && newY < Y) {
                    if (map[newX][newY] == 0&&!visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY]=true;
                    }
                    if (map[newX][newY] == 1) {
                        map[newX][newY] = 2;
                    }
                }
            }
        }
    }

    static void melt() {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
    }
}
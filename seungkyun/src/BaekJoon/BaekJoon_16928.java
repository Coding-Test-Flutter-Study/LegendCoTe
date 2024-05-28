import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static HashMap<Integer,Integer> ladders = new HashMap<>();
    static HashMap<Integer,Integer> snakes = new HashMap<>();

    static int N,M;
    static int[] dice = {1,2,3,4,5,6};
    static int ans;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[101];
        //ladder
        for(int i=0; i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st2.nextToken());
            int after = Integer.parseInt(st2.nextToken());
            ladders.put(before,after);
        }

        //snake
        for(int i=0; i<M;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st3.nextToken());
            int after = Integer.parseInt(st3.nextToken());
            snakes.put(before,after);
        }


        ans=100;
        bfs();


        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void bfs(){
        Queue<int[]> queue= new LinkedList<>();

        queue.offer(new int[]{1,0});

        while (!queue.isEmpty()){

            int[] info = queue.poll();
            int now = info[0];
            int times = info[1];

            visited[now]=true;

            if (now==100){
                ans = Math.min(times,ans);
                return;
            }

            for (int i=0; i<6;i++){
                int newNow = now+dice[i];

                if (ladders.containsKey(newNow)){
                    newNow = ladders.get(newNow);
                } else if (snakes.containsKey(newNow)) {
                    newNow = snakes.get(newNow);
                }

                if(newNow<=100&&!visited[newNow]){
                    visited[newNow]= true;
                    queue.offer(new int[]{newNow,times+1});
                }


            }
        }

    }
}
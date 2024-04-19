package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2161 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static Queue<Integer> queue = new LinkedList<>();

        public static void main(String[] args) throws IOException {

            int N = Integer.parseInt(br.readLine());

            for(int i=1; i<=N;i++){
                queue.offer(i);
            }
            bw.write(queue.poll()+" ");
            while (!queue.isEmpty()){

                queue.offer(queue.poll());
                bw.write(queue.poll()+" ");
            }


            bw.flush();
        }


}

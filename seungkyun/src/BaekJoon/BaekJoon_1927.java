package BaekJoon;

import java.io.*;
import java.util.PriorityQueue;

public class BaekJoon_1927 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {

            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

            for(int i=0; i<N;i++){
                int x = Integer.parseInt(br.readLine());

                if(x==0){
                    if(priorityQueue.isEmpty()){
                        bw.write("0"+"\n");
                    } else {
                        bw.write(String.valueOf(priorityQueue.poll())+"\n");
                    }
                } else {
                    priorityQueue.offer(x);
                }
            }

            bw.flush();
        }

}

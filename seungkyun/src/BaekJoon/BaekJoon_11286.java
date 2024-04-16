package BaekJoon;

import java.io.*;
import java.util.PriorityQueue;

public class BaekJoon_11286 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {

            long N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a1, a2)->{

                if(Math.abs(a1)==Math.abs(a2)){
                    return a1-a2;
                } else {
                    return Math.abs(a1)-Math.abs(a2);
                }


            });

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

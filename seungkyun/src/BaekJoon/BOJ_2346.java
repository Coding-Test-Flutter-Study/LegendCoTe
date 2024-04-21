package BaekJoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2346 {



        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static int paper;
        static Deque<Integer> deque = new ArrayDeque<>();
        static int [] array ;

        public static void main(String[] args) throws IOException {

            int N = Integer.parseInt(br.readLine());

            array = new int[N+1];
            for(int i=0; i<N;i++){
                deque.offerLast(i+1);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N;i++){
                int papers = Integer.parseInt(st.nextToken());

                array[i+1]=papers;

            }

            bw.write(deque.pollFirst()+" ");

            paper = array[1];

            for(int i=0; i<N-1;i++){

                if(paper>0){


                    for(int j=1; j<=paper-1;j++){
                        if(!deque.isEmpty()){
                            deque.offerLast(deque.pollFirst());
                        }
                    }
                    int out = deque.pollFirst();
                    paper = array[out];
                    bw.write(out+" ");
                } else {

                    for(int j=1; j<=Math.abs(paper+1);j++){
                        if(!deque.isEmpty()) {
                            deque.offerFirst(deque.pollLast());
                        }
                    }
                    int out = deque.pollLast();

                    paper = array[out];
                    bw.write(out+" ");
                }

            }

            bw.flush();
        }



}

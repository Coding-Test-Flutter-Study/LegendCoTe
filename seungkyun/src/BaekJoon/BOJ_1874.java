package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_1874 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {

            ArrayList<String> arrayList = new ArrayList<>();

            Stack<Integer> stack = new Stack<>();
            int N = Integer.parseInt(br.readLine());
            int order = 0;
            int [] array = new int[N];

            for(int i=0; i<N;i++){
                array[i]= Integer.parseInt(br.readLine());
            }

            for(int i=1; i<=N;i++){
                stack.push(i);
                arrayList.add("+");

                while (!stack.isEmpty()){
                    if(stack.peek()==array[order]){
                        stack.pop();
                        arrayList.add("-");
                        order+=1;
                    } else {
                        break;
                    }

                }


            }
            if(!stack.isEmpty()){
                bw.write("NO");
            } else {
                for(String str : arrayList){
                    bw.write(str+"\n");
                }
            }


            bw.flush();
        }




}

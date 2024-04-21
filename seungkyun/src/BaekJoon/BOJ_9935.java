package BaekJoon;

import java.io.*;
import java.util.Stack;

public class BOJ_9935 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {


            String str = br.readLine();
            String popStr = br.readLine();

            boolean ok = false;

            Stack<Character> stack = new Stack<>();

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<str.length();i++){
                stack.push(str.charAt(i));

                ok = false;
                if(stack.size()>=popStr.length()){

                    for(int j=0;j<popStr.length();j++){
                        if(stack.get(stack.size()-popStr.length()+j)==popStr.charAt(j)){
                            ok = true;
                        } else {
                            ok = false;
                            break;
                        }
                    }

                    if(ok){
                        for(int j=0; j<popStr.length();j++){
                            stack.pop();
                        }
                    }


                }

            }

            for(int i=0; i< stack.size();i++){
                sb.append(stack.get(i));
            }
            if(sb.length()==0){
                bw.write("FRULA");
            } else {
                bw.write(sb.toString());
            }

            bw.flush();
        }




}

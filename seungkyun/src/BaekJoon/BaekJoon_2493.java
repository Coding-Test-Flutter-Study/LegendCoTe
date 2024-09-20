import java.io.*;
import java.sql.Array;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static Stack<Integer> stack = new Stack<>();
    static HashMap<Integer,Integer> hashMap = new HashMap<>();

    static int N;
    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            int t = Integer.parseInt(st.nextToken());
            hashMap.put(t,i+1);
            check(t);
        }
        bw.flush();
    }


    static void check(int t) throws IOException {

        if(stack.isEmpty()){
            bw.write("0"+" ");
            stack.push(t);
        } else if (stack.peek()>t) {

            bw.write(hashMap.get(stack.peek()).toString()+" ");

            stack.push(t);
        } else {

            while(true){
                if(stack.isEmpty()){
                    bw.write("0"+" ");
                    stack.push(t);
                    return;
                }

                if(stack.peek()<t){
                    stack.pop();
                } else {
                    bw.write(hashMap.get(stack.peek()).toString()+" ");
                    stack.push(t);
                    return;
                }
            }
        }


    }

}
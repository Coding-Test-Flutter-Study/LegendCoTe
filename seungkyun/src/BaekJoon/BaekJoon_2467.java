import java.io.*;
import java.sql.Array;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int[] fluid;

    static int N;
    static int ans;
    static int[]answer;
    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());

        fluid = new int[N];
        answer = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = Integer.MAX_VALUE;
        for(int i=0; i<N;i++){
            int t = Integer.parseInt(st.nextToken());
            fluid[i]=t;
        }

        twoPointer();

        bw.write(answer[0]+" "+answer[1]);
        bw.flush();
    }


    static void twoPointer(){
        int left = 0;
        int right = N-1;

        answer[0]=fluid[left];
        answer[1]=fluid[right];

        while(left<right){

            int newNum = fluid[left]+fluid[right];

            if(Math.abs(ans)<Math.abs(newNum)){
                if(newNum>0){
                    right--;
                } else  {
                    left++;
                }

            }else if(Math.abs(ans)>Math.abs(newNum)){
                answer[0]=fluid[left];
                answer[1]=fluid[right];
                if(newNum>0){
                    right--;
                } else  {
                    left++;
                }
                ans = newNum;
            } else {
                if(newNum>0){
                    right--;
                } else  {
                    left++;
                }
            }


        }
    }


}
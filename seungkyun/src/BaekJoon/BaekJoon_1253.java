import java.io.*;
import java.sql.Array;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int [] numList;
    static int ans,N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        numList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            numList[i]=n;
        }

        Arrays.sort(numList);

        for(int i=0; i<N;i++){
            twoPointer(numList[i],i);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }


    static void twoPointer(int n,int i){

        int left = 0;
        int right = N-1;

        while(left<right){
            int sum = numList[left]+numList[right];

            if(left==i){
                left++;
            } else if(right==i){
                right--;
            } else {
                if(n<sum){
                    right--;
                }else if(n>sum){
                    left++;
                } else {
                    ans++;
                    return;
                }
            }

        }
    }
}
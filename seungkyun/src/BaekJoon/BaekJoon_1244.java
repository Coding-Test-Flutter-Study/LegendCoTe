import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,M;
    static int boyNum,girlNum;

    static int [] array;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        array= new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            array[i]= Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            if(st2.nextToken().equals("1")){
                boyNum = Integer.parseInt(st2.nextToken());

                boy(boyNum-1);

            } else {
                girlNum =Integer.parseInt(st2.nextToken());

                girl(girlNum-1);
            }


        }

        for(int i=0,count =1; i< array.length;i++,count++){
            bw.write(array[i]+ " ");

            if(count%20==0){
                bw.write("\n");
            }
        }



        bw.flush();
    }

    static void boy(int n){
        int count=0;
        while (n + count < N) {
            if (array[n + count] == 1) {
                array[n + count] = 0;
            } else {
                array[n + count] = 1;
            }

            count += boyNum;

        }
    }

    static void girl(int n){

        if(array[n]==1){
            array[n]=0;
        } else {
            array[n]=1;
        }

        int count = 1;

        while (true) {

            if (n - count >= 0 && n + count < N&&array[n - count] == array[n + count]) {

                if (array[n - count] == 1) {
                    array[n - count] = 0;
                    array[n + count] = 0;

                } else if (array[n - count] == 0) {
                    array[n - count] = 1;
                    array[n + count] = 1;

                }

            } else {
                break;
            }
            count++;
        }

    }




}
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N,findOrder;
    static int [][] array;

    static int[] orderArray;
    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        findOrder = Integer.parseInt(st.nextToken());

        array = new int[N+1][3];

        //등수 저장 배열
        orderArray = new int[N+1];

        info(N);


        find();

        int ans = orderArray[findOrder];


        bw.write(String.valueOf(ans));


        bw.flush();
    }

    //정보 저장
    static void info(int n) throws IOException {
        for(int i=0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            array[country][0]=gold;
            array[country][1]=silver;
            array[country][2]=bronze;
        }
    }

    //찾기
    static void find(){

        for(int i=1; i<=N;i++){
            int order =1;
            for(int j=1; j<=N;j++){
                if(array[i][0]<array[j][0]
                        ||array[i][0]==array[j][0]&&array[i][1]<array[j][1]
                        ||array[i][0]==array[j][0]&&array[i][1]==array[j][1]&&array[i][2]<array[j][2]){

                    order++;

                }
            }
            orderArray[i]=order;
        }
    }




}
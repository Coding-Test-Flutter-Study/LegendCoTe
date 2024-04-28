import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static int[][] array;
    static int[][] newArray;
    static int N,M,R;

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        newArray = new int[N][M];
//        newArray = array;
        for(int i=0; i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<M;j++){
                int a = Integer.parseInt(st2.nextToken());
                array[i][j] = a;
                newArray[i][j] = a;

            }
        }


        evenNevenM();


        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){

                bw.write(array[i][j]+" ");
            }
            bw.write("\n");
        }




        bw.flush();
    }

    //둘다 짝수
    static void evenNevenM(){

        //끝 모서리
        int[] upStart = {0,0};
        int[] leftStart= {N-1,0};
        int[] downStart = {N-1,M-1};
        int[] rightStart= {0,M-1};

        for(int i=0; i<R;i++){
            while(upStart[0]<downStart[0]&&rightStart[1]>leftStart[1]){

                //위
                for(int up=upStart[1]; up<rightStart[1];up++){
                    array[upStart[0]][up] = newArray[upStart[0]][up+1];

                }
                //왼쪽
                for(int left=leftStart[0];left>=upStart[0];left--){
                    array[left][leftStart[1]] = newArray[left-1][leftStart[1]];
                }
                //아래
                for(int down=downStart[1];down>=leftStart[1];down--){
                    array[downStart[0]][down] = newArray[downStart[0]][down-1];
                }
                //오른쪽
                for(int right=rightStart[0];right<downStart[0];right++){
                    array[right][rightStart[1]] = newArray[right+1][rightStart[1]];
                }
                upStart[0]++;
                upStart[1]++;
                downStart[0]--;
                downStart[1]--;
                rightStart[0]++;
                rightStart[1]--;
                leftStart[0]--;
                leftStart[1]++;

            }
            for(int n=0; n<N;n++){
                for(int m=0; m<M;m++){
                    newArray[n][m] = array[n][m];

                }
            }



        }

    }
    //N홀수
    static void oddNevenM(){

    }
    //M홀수
    static void evenNoddM(){

    }





}
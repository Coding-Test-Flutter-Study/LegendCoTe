import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static int H,W;

    static int ans;
    static int water;

    static int [] array;
    static int max;
    static int leftColumn,rightColumn;



    public static void main(String[] args) throws IOException {


        //왼쪽부터 a보다 작으면 빗물 저장
        //같거나 크면 답 +=, 저장한 빗물 지우기,a갱신
        //max 나올때까지 실행

        //오른쪽도 같음

        //max가 여러개일 경우
        //max사이 빗물도 똑같이


        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        array = new int[W];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<W;i++){
            int h = Integer.parseInt(st2.nextToken());
            array[i] = h;
            max = Math.max(h,max);
        }

        left();
        right();
        betweenMax();



        bw.write(String.valueOf(ans));
        bw.flush();
    }


    static void left(){

        leftColumn = array[0];


        for(int i=0; i<W;i++){

            if(array[i]<leftColumn){

                water+=(leftColumn-array[i]);

            } else if(array[i]>=leftColumn&&array[i]!=max){

                ans+=water;
                water=0;
                leftColumn = array[i];
            } else if (array[i]==max) {
                ans+=water;
                water=0;
                break;
            }

        }

    }

    static void right(){

        rightColumn = array[W-1];


        for(int i=W-1; i>=0;i--){

            if(array[i]<rightColumn){

                water+=(rightColumn-array[i]);

            } else if(array[i]>=rightColumn&&array[i]!=max){

                ans+=water;
                water=0;
                rightColumn = array[i];
            } else if (array[i]==max) {
                ans+=water;
                water=0;
                break;
            }

        }

    }

    static void betweenMax(){

        for(int i=0; i<W;i++){

            if(array[i]==max){

                for(int j=i; j<W;j++){
                    water+= (max - array[j]);

                    if(array[j]==max){
                        ans+=water;
                        water=0;
                    }
                }

                break;
            }

        }
    }

}
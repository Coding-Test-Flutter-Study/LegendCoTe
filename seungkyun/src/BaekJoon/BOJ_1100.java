package BaekJoon;

import java.io.*;

public class BOJ_1100 {




        static String[][] array;
        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {


            int count =0;
            array= new String[8][8];

            for(int i=0; i<8;i++){
                String a = br.readLine();
                String[] aa = a.split("");
                for(int j=0;j<8;j++){
                    array[i][j]=aa[j];
                }
            }


            for(int i=0; i<8;i++){

                for(int j=0;j<8;j++){

                    if(i%2==0){
                        if(j%2==0){
                            if(array[i][j].equals("F")){
                                count++;
                            }
                        }
                    } else {
                        if(j%2!=0){
                            if(array[i][j].equals("F")){
                                count++;
                            }
                        }
                    }
                }
            }
            bw.write(String.valueOf(count));
            bw.flush();
        }





}

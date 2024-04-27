import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static int [][] array;


    static int testCase;
    static int myRank;

    static int teams,questions,myTeam,entry;

    public static void main(String[] args) throws IOException {



        //팀 넘버, 팀 점수, 점수 제출 횟수, 마지막 제출자

        //1. 점수 비교-> 내 팀보다 점수 높으면 등수++,
        //2. 같다면 점수 제출 횟수  적으면 등수++,
        //3. 점수도 같고 횟수도 같으면 마지막 제출자 작으면 등수 ++;
        testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            teams = Integer.parseInt(st.nextToken());
            questions = Integer.parseInt(st.nextToken());
            myTeam = Integer.parseInt(st.nextToken());
            entry = Integer.parseInt(st.nextToken());

            array = new int[teams+1][4];
            int[][] scoreArray = new int [teams+1][questions+1];
            for(int j=0; j<entry;j++){

                StringTokenizer st2 = new StringTokenizer(br.readLine());

                int teamID = Integer.parseInt(st2.nextToken());
                int questionN = Integer.parseInt(st2.nextToken());
                int score = Integer.parseInt(st2.nextToken());

                array[teamID][0]= teamID;

                scoreArray[teamID][questionN]=Math.max(scoreArray[teamID][questionN],score);

                array[teamID][2] ++;
                array[teamID][3]=j;


            }

            for(int t=1; t<=teams;t++){
                for(int q =1; q<=questions;q++){
                    array[t][1] += scoreArray[t][q];
                }
            }




            ranking();
            bw.write(myRank+"\n");


        }


        bw.flush();
    }


    static void ranking(){
        myRank=1;

        for(int i=1;i<=teams;i++){


            if(array[i][1]>array[myTeam][1]){
                myRank++;
            } else if(array[i][1]==array[myTeam][1]&&array[i][2]<array[myTeam][2]){
                myRank++;
            }else if(array[i][1]==array[myTeam][1]&&array[i][2]==array[myTeam][2]&&array[i][3]<array[myTeam][3]){
                myRank++;
            }

        }

    }
}
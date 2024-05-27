import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //알파벳 개수 배열체크
    //개수 2 이상이면 A부터 처음과 끝에 놓기
    //아니면 다음 알파벳, 처음 끝 같거나 역전되면 종료,
    //남은 알파벳이 없거나, 1개인 경우 출력

    static int[] alphabetNum = new int[26];
    static int start,end;
    static String str;
    static char[] ans;


    public static void main(String[] args) throws IOException {

        str= br.readLine();

        ans = new char[str.length()];

        start=0;
        end= ans.length-1;

        put(str);
        int index=0;

        while (true){

            if(alphabetNum[index]>=2){
                ans[start]=(char) (index+65);
                ans[end]=(char) (index+65);

                start++;
                end--;
                alphabetNum[index]-=2;
            } else {
                index++;
            }

            if(start>=end||index>=26){
                break;
            }
        }

        int ok=0;
        for(int i=0; i< alphabetNum.length;i++){
            ok+=alphabetNum[i];
        }

        if(ok==0){

            bw.write(ans(ans));
        } else if(ok==1){

            for(int i=0; i< alphabetNum.length;i++){
                if(alphabetNum[i]==1){
                    char  c=(char) (i+65);
                    ans[start]=c;
                }
            }
            bw.write(ans(ans));
        } else {
            bw.write("I'm Sorry Hansoo");

        }


        bw.flush();
    }

    static void put(String str){
        for (int i=0; i<str.length();i++){
            alphabetNum[str.charAt(i)-65]++;
        }
    }

    static String ans(char[] chars){

        String string="";
        for(int i=0; i< chars.length;i++){
            string+=chars[i];
        }
        return string;

    }

}

import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Character> quick = new ArrayList<>();

    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N;i++){

            String str = br.readLine();

            String[] array = str.split(" ");

            check(array);

            bw.write("\n");
        }


        bw.flush();
    }

    static void check(String[] array) throws IOException {
        for(int j=0; j< array.length;j++){
            char c = array[j].charAt(0);

            if(c<97){
                if(!quick.contains(c)){
                    quick.add(c);
                    bw.write(write(array,j,0));
                    return;
                }
            } else {
                char c2 = (char) (c-32);
                if(!quick.contains(c2)){
                    quick.add(c2);
                    bw.write(write(array,j,0));
                    return;
                }
            }

        }

        for(int i=0; i< array.length;i++){
            String word = array[i];
            for(int j=0; j<word.length();j++){
                char c = word.charAt(j);

                if(c<97){
                    if(!quick.contains(c)){
                        quick.add(c);
                        bw.write(write(array,i,j));
                        return;
                    }
                } else {
                    char c2 = (char) (c-32);
                    if(!quick.contains(c2)){
                        quick.add(c2);
                        bw.write(write(array,i,j));
                        return;
                    }
                }

            }
        }

        bw.write(write(array,-1,-1));
    }

    static String write(String[] array, int wordIndex,int charIndex){
        String ans ="";
        for(int i=0; i<array.length;i++){
            if(i==wordIndex){

                for(int j=0; j<array[i].length();j++){
                    if(j==charIndex){
                        ans+=String.valueOf("["+array[i].charAt(j)+"]");
                    } else {
                        ans+=String.valueOf(array[i].charAt(j));
                    }
                }

            } else {

                ans+=array[i];
            }
            ans+=" ";
        }

        return ans;
    }

}
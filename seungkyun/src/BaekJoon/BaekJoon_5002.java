import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int d;
    static int ans;
    static int m,w;

    static String last;
    //wwwmmmwwwmmm
    //w w m m w m w w m m w m
    //0-5 1-3 2-4

    public static void main(String[] args) throws IOException {

        d = Integer.parseInt(br.readLine());
        String str =br.readLine();
        String[] line = str.split("");

        for(int i=0; i< line.length-1;i++){

            if (line[i].equals("W")){
                last = "W";
                w++;
            } else {
                last = "M";
                m++;
            }

            if(Math.abs(w-m)<=d){
                ans++;
            } else {
                if(!line[i].equals(line[i+1])){
                    ans++;
                    String temp = line[i];
                    line[i]=line[i+1];
                    line[i+1]=temp;

                    if(line[i].equals("W")){
                        w++;
                        m--;
                        last = "W";
                    } else {
                        w--;
                        m++;
                        last = "M";

                    }
                } else {
                    break;
                }
            }
        }

        if(Math.abs(w-m)>d||Math.abs(w-m)==d&&last.equals(line[line.length-1])){
            bw.write(String.valueOf(ans));
        } else {
            bw.write(String.valueOf(ans+1));

        }


        bw.flush();
    }




}
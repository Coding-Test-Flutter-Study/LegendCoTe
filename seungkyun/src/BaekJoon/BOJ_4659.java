import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        while (true){
            String str = br.readLine();
            if(str.equals("end")){
                break;
            } else {
                bw.write(check(str));
            }
        }


        bw.flush();
    }

    static String check(String string){

        //조건1
        if(!string.contains("a")&&!string.contains("e")&&!string.contains("i")&&!string.contains("o")&&!string.contains("u")){
            return "<"+string+">"+" is not acceptable."+"\n";
        }
        //조건2
        for(int i=0; i<string.length()-2;i++){
            int noJStack =0;
            int noMStack =0;

            for(int j=i; j<3+i;j++){
                //자음
                if(string.charAt(j)!='a'&&string.charAt(j)!='e'&&string.charAt(j)!='i'&&string.charAt(j)!='o'&&string.charAt(j)!='u'){
                    noJStack++;
                }
                //모음
                if(string.charAt(j)=='a'||string.charAt(j)=='e'||string.charAt(j)=='i'||string.charAt(j)=='o'||string.charAt(j)=='u'){
                    noMStack++;
                }
            }
            if(noJStack==3){
                return "<"+string+">"+" is not acceptable."+"\n";
            }
            if(noMStack==3){
                return "<"+string+">"+" is not acceptable."+"\n";
            }
        }
        //조건3
        for(int i=0; i<string.length()-1;i++){
            if(string.charAt(i)==string.charAt(i+1)){
                if(string.charAt(i)!='e'&&string.charAt(i)!='o'){
                    return "<"+string+">"+" is not acceptable."+"\n";
                }
            }
        }

        return "<"+string+">"+" is acceptable."+"\n";

    }




}
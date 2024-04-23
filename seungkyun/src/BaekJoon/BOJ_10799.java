//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        static int count;

        public static void main(String[] args) throws IOException {

            Stack<Character> stack = new Stack<>();

            String str = br.readLine();




            for(int i=0; i<str.length();i++){

                if(str.charAt(i)==('(')){
                    stack.push(str.charAt(i));
                } else {
                    if(str.charAt(i-1)=='('){
                        stack.pop();
                        count+= stack.size();
                    } else {
                        stack.pop();
                        count++;
                    }
                }
            }


            bw.write(String.valueOf(count));

            bw.flush();
        }



}
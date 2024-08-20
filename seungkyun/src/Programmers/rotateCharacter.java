import java.util.*;


class Solution {

    static int ans=0;
    public int solution(String s) {

        Queue<Character> nowS = new LinkedList<>();

        for(int i=0; i<s.length();i++){
            nowS.offer(s.charAt(i));
        }

        for(int i=0; i<s.length();i++){

            check(nowS);

            nowS.offer(nowS.poll());
        }

        return ans;
    }

    static void check(Queue<Character> queue){

        String newString = "";

        for(int i=0; i<queue.size();i++){
            char a = queue.poll();
            newString +=a;
            queue.offer(a);
        }

        Stack<Character> checkS = new Stack<>();

        for(int i=0; i<newString.length();i++){

            char S = newString.charAt(i);

            if(checkS.isEmpty()){
                checkS.push(S);
            } else {
                char peekS =  checkS.peek();

                if(S==']'){
                    if(peekS=='['){
                        checkS.pop();
                    } else {
                        return;
                    }

                } else if(S==')'){
                    if(peekS=='('){
                        checkS.pop();
                    } else {
                        return;
                    }
                } else if(S=='}'){
                    if(peekS=='{'){
                        checkS.pop();
                    } else {
                        return;
                    }
                } else {
                    checkS.push(S);
                }

            }
        }

        if(checkS.isEmpty()){
            ans++;

        }

    }
}
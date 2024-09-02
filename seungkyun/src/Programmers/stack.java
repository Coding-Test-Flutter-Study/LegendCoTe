import java.util.*;

class Solution {

    boolean solution(String s) {

        char[] strArray = s.toCharArray();
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();

        if(strArray.length%2!=0){
            return false;
        }


        for(int i=0; i<strArray.length;i++){



            Character str = strArray[i];
            if(str=='('){
                left++;
            } else {
                right++;
            }

        }

        if(left!=right){
            return false;
        }

        for(int i=0; i<strArray.length;i++){



            Character str = strArray[i];


            if(str=='('){
                stack.push(str);
            } else {
                if(stack.isEmpty()){
                    stack.push(str);
                } else {
                    if(stack.peek()=='('){
                        stack.pop();
                    } else {
                        return false;
                    }
                }

            }

        }

        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }


    }
}
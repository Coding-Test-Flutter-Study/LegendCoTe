import java.util.*;

class Solution {

    static HashSet<String> hashSet = new HashSet<>();

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int phone_book_num = phone_book.length;

        for(int i=0; i<phone_book_num;i++){
            String num = phone_book[i];
            hashSet.add(num);
        }

        for(int i=0; i<phone_book_num;i++){
            String num = phone_book[i];

            for(int j=0;j<num.length();j++){
                if(hashSet.contains(num.substring(0,j))){
                    return false;
                }
            }
        }
        return answer;
    }
}
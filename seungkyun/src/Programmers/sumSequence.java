import java.util.*;

class Solution {

    static int [] answer = new int[2];

    public int[] solution(int[] sequence, int k) {
        twoPointer(sequence,k);
        return answer;
    }

    static void twoPointer(int[] sequence, int k){
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int length =1;
        int minlength =sequence.length+1;
        while(left<=right){




            if(sum<k){
                right++;
                if(right==sequence.length){
                    return;
                }
                sum+=sequence[right];
                length++;
            } else if(sum==k){

                if(length<minlength){
                    answer[0]=left;
                    answer[1]=right;
                    minlength=length;
                }

                right++;
                if(right==sequence.length){
                    return;
                }
                sum+=sequence[right];
                length++;

            } else {
                sum-=sequence[left];
                left++;
                length--;
            }

        }
    }
}
import java.util.*;

class Solution {

    static int ans = 0;
    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        twoPointer(people,limit);

        return ans;

    }

    static void twoPointer(int[] people, int limit){

        int left = 0;
        int right = people.length-1;

        while(left<=right){

            if(left==right){
                ans++;
                return;
            }
            if(people[left]+people[right]>limit){
                ans++;
                right--;
            } else {
                ans++;
                left++;
                right--;
            }
        }
    }
}
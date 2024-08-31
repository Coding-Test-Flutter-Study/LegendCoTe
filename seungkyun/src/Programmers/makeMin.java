import java.util.*;

class Solution
{
    static int ans =Integer.MAX_VALUE;
    public int solution(int []A, int []B)
    {


        int ans=0;
        Arrays.sort(A);

        Arrays.sort(B);
        for(int i=0; i<A.length;i++){
            ans+=(A[i]*B[B.length-1-i]);
        }

        return ans;
    }

}
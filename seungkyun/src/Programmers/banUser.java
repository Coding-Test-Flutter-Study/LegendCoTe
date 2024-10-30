import java.util.*;

class Solution {
    static int ans=0;
    static HashSet<String> hashSet = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        dfs(0,banned_id,user_id,"");
        return hashSet.size();
    }


    static void dfs(int nowBanId,String[] banned_id, String[] user_id,String str){
        if(nowBanId==banned_id.length){

            String[] a = str.split("");
            Arrays.sort(a);
            String news = "";
            for(String s : a){
                news+=s;
            }
            hashSet.add(news);
            return;
        }
        String ban_id = banned_id[nowBanId];
        for(int i=0; i<user_id.length;i++){

            String id = user_id[i];
            if(id=="******"){

            } else if(ban_id.length()==id.length()){
                boolean ok = true;
                //비교
                for(int j=0; j<id.length();j++){
                    if(ban_id.charAt(j)!='*'){
                        if(ban_id.charAt(j)!=id.charAt(j)){
                            ok = false;
                            break;
                        }
                    }
                }
                //일치하는 경우
                if(ok){
                    String temp = user_id[i];
                    user_id[i]="******";
                    dfs(nowBanId+1,banned_id,user_id,str+i);
                    user_id[i] =temp;
                }
            }
        }
    }
}
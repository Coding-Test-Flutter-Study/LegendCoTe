import java.util.*;

class Solution {

    static ArrayList<String> ansList = new ArrayList<>();
    static int person, turn;
    static char lastWord;

    public int[] solution(int n, String[] words) {


        person = 2;
        turn = 1;
        lastWord = words[0].charAt(words[0].length() - 1);
        ansList.add(words[0]);

        int[] answer = {0, 0};

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            char firstWord = word.charAt(0);

            if (lastWord != firstWord) {
                return new int[]{person, turn};
            } else if (ansList.contains(word)) {
                return new int[]{person, turn};
            } else {
                ansList.add(word);
                lastWord = words[i].charAt(words[i].length() - 1);
                person++;
                if (person > n) {
                    person = 1;
                    turn++;
                }
            }
        }

        return answer;
    }
}
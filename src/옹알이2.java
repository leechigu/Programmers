import java.util.HashSet;

public class 옹알이2 {

    public static HashSet<String> hashSet = new HashSet<String>();
    public static String[] words = {"aya","ye","woo","ma"};

    public static void dfs(int cur, int select, String word){
        if(word.length()>30){
            hashSet.add(word);
            return;
        }
        for(int i=0;i<words.length;i++){
            if(select==i)
                continue;
            String temp = word;
            word = word+words[i];
            hashSet.add(word);
            dfs(cur+1,i,word);
            word = temp;
        }

    }


    public static int solution(String[] babbling) {

        int answer = 0;

        dfs(0,-1,"");

        for(int i=0;i< babbling.length;i++){
            if(hashSet.contains(babbling[i]))
                answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] st = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        solution(st);
    }
}

import java.util.*;


public class 오픈채팅방 {

    public String[] solution(String[] record) {

        String[][] st = new String[record.length][];
        for(int i =0;i<record.length;i++){
            st[i] = record[i].split(" ");
        }
        HashMap<String,String> hash = new HashMap<>();

        for(int i=0;i<st.length;i++){
            if(st[i].length==3){
                hash.put(st[i][1],st[i][2]);
            }
        }
        ArrayList<String> answer = new ArrayList<>();

        for(int i=0;i<st.length;i++){
            if(st[i][0].equals("Enter")){
                answer.add(hash.get(st[i][1])+"님이 들어왔습니다.");
            }
            else if(st[i][0].equals("Leave")){
                answer.add(hash.get(st[i][1])+"님이 나갔습니다.");
            }
        }

        Iterator<String> it = answer.iterator();
        String[] ans = new String[answer.size()];

        int x =0;
        while(it.hasNext()){
            ans[x] = it.next();
            x++;
        }

        return ans;
    }


}

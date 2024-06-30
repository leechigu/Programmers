package 프로그래머스.LEVEL1;

import java.util.*;

public class 제출_내역 {

    public int solution(String[] friends, String[] gifts) {

        List<String> nextGift =new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        //선물 주고 받는 경우의 수
        List<String> cases = new ArrayList<>();
        for(int i=0;i< friends.length;i++){

            String giver = friends[i];

            for(int j=0;j< friends.length;j++){
                if(i==j) {
                    continue;
                }
                String recipient = friends[j];
                map.put(giver + " " + recipient,0);
                cases.add(giver + " " + recipient);
            }
        }

        //선물 주고 받은 리스트
        Arrays.sort(gifts);

        //선물 지수용 Map
        Map<String, Integer> headMap= new HashMap<>();
        Map<String, Integer> tailMap= new HashMap<>();

        for(int i=0;i< friends.length;i++){
            headMap.put(friends[i],0);
            tailMap.put(friends[i],0);
        }


        for(int i=0;i< gifts.length;i++){
            String gift = gifts[i];
            String head = gift.split(" ")[0];
            String tail = gift.split(" ")[1];

            headMap.put(head,headMap.get(head)+1);
            tailMap.put(tail,tailMap.get(tail)+1);
            map.put(gift,map.get(gift)+1);


        }

        for(int i=0;i<cases.size();i++){

            //선물 주고받은거 비교
            String case1 = cases.get(i);
            String case2 = switchStr(case1);

            String head = case1.split(" ")[0];
            String tail = case1.split(" ")[1];

            int val1 = map.containsKey(case1)?map.get(case1):0;
            int val2 = map.containsKey(case2)?map.get(case2):0;



            if(val1==val2){
                //선물 지수 체크
                int headVal = headMap.get(head)-tailMap.get(head);
                int tailVal = headMap.get(tail)-tailMap.get(tail);

                if(headVal==tailVal){
                    continue;
                }else{
                    if(headVal>tailVal){
                        nextGift.add(head);
                    }else{
                        nextGift.add(tail);
                    }
                }
            }else{
                if(val1>val2)
                    nextGift.add(head);
                else
                    nextGift.add(tail);
            }

        }
        Map<String,Integer> answerMap = new HashMap<>();

        for(int i=0;i<nextGift.size();i++){

            String next = nextGift.get(i);

            if(answerMap.containsKey(next)){
                answerMap.put(next,answerMap.get(next)+1);
            }else{
                answerMap.put(next,1);
            }
        }

        int max = -1;

        for(Integer val : answerMap.values()){
            if(val>max)
                max = val;
        }

        return max/2;
    }

    private String switchStr(String string){

        String[] strSplit = string.split(" ");

        return strSplit[1] + " " + strSplit[0];
    }

}

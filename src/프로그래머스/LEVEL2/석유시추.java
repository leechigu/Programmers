package 프로그래머스.LEVEL2;

import java.util.*;

public class 석유시추 {

    static int[][] add;
    static List<HashSet<Integer>> lists;
    static Map<Integer,Integer> ansMap;
    public void cal(int[][] land, int[]cur){


        int size =1;
        int a = cur[0];
        int b = cur[1];
        land[a][b]=0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a,b});


        HashSet<Integer> list = new HashSet<>();
        list.add(b);
        while(true){

            if(queue.isEmpty())
                break;

            int[] temp = queue.poll();

            for(int i=0;i<4;i++){
                int ta = temp[0]+add[i][0];
                int tb = temp[1]+add[i][1];

                if(tb<0||tb>=land[0].length)
                    continue;

                if(ta<0||ta>=land.length)
                    continue;

                if(land[ta][tb]==1){
                    land[ta][tb]=0;
                    list.add(tb);
                    queue.add(new int[]{ta, tb});
                    size++;
                }

            }
        }
        lists.add(list);

        for(int temp : list){
            ansMap.put(temp,ansMap.getOrDefault(temp,0)+size);
        }
    }


    public int solution(int[][] land) {

        add = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        lists = new ArrayList<>();
        ansMap = new HashMap<>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==1){
                    cal(land,new int[]{i,j});
                }
            }
        }

        int answer = ansMap.values()
                .stream()
                .mapToInt(i->i)
                .max()
                .getAsInt();
        return answer;
    }

}

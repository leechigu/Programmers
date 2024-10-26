package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준10845 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int n = Integer.parseInt(input);
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            input = br.readLine();
            String[] splitStr = input.split(" ");
            String text = splitStr[0];

            if("push".equals(text)) {
                int num = Integer.parseInt(splitStr[1]);
                queue.add(num);
            }else if("pop".equals(text)){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.poll());
                }
            }else if("size".equals(text)){
                System.out.println(queue.size());
            }
            else if("empty".equals(text)){
                System.out.println(queue.isEmpty()?1:0);
            }
            else if("front".equals(text)){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.peek());
                }
            }
            else if("back".equals(text)){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.toArray()[queue.size()-1]);
                }
            }
        }

    }

}

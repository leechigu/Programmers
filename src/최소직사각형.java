import java.util.Arrays;

public class 최소직사각형 {

    public int solution(int[][] sizes) {

        for(int i=0;i<sizes.length;i++){
            int x = Math.max(sizes[i][0],sizes[i][1]);
            int y = Math.min(sizes[i][0],sizes[i][1]);
            sizes[i][0] =x;
            sizes[i][1] =y;
        }
        int[] x = new int[sizes.length];
        int[] y = new int[sizes.length];

        for(int i=0;i<sizes.length;i++){

            x[i] = sizes[i][0];
            y[i] = sizes[i][1];
        }
        Arrays.sort(x);
        Arrays.sort(y);

        return x[sizes.length-1]*y[sizes.length-1];
    }




}

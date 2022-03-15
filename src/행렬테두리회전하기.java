public class 행렬테두리회전하기 {
    public int[][] rotation(int[][] arr ,int[] pos){
        int[][] temp = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[0].length;j++)
                temp[i][j] = arr[i][j];
        int x1,x2,y1,y2;
        x1 = pos[0]-1;y1=pos[1]-1;x2=pos[2]-1;y2=pos[3]-1;
        for(int i=y1;i<=y2;i++){
            if(i==y1){
                temp[x1][i]=arr[x1+1][i];
                continue;
            }
            temp[x1][i] = arr[x1][i-1];
        } // 위에 x줄 rotation
        for(int i=x1;i<=x2;i++){
            if(i==x1){
                continue;
            }
            temp[i][y2] =arr[i-1][y2];
        }//오른쪽 rotation
        for(int i=y2;i>=y1;i--){
            if(i==y2)
                continue;
            temp[x2][i] = arr[x2][i+1];
        }//아래줄
        for(int i=x2;i>=x1;i--){
            if(i==x2)
                continue;
            temp[i][y1] = arr[i+1][y1];
        }//왼쪽줄
        return temp;
    }
    public int findMin(int[][] arr,int[] pos) {
        int x1,x2,y1,y2;
        x1 = pos[0]-1;y1=pos[1]-1;x2=pos[2]-1;y2=pos[3]-1;
        int min = arr[x1][y1];
        for(int i=y1;i<=y2;i++){
            if(arr[x1][i]<min)
                min = arr[x1][i];
            if(arr[x2][i]<min)
                min = arr[x2][i];
        }
        for(int i=x1;i<=x2;i++){
            if(arr[i][y1]<min)
                min = arr[i][y1];
            if(arr[i][y2]<min)
                min = arr[i][y2];
        }
        return min;

    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = (i)*columns+j+1;
            }
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            arr = rotation(arr,queries[i]);
            ans[i] = findMin(arr,queries[i]);
        }
        return ans;
    }
}

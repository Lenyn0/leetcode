package lc59;

import org.apache.commons.collections4.Get;

public class Main {
    public static void main(String[] args) {
        int n=5;
        int [][]result=generateMatrix(n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(result[i][j]+"  ");
            }
            System.out.println();
        }

        int [][]result_cite=generateMatrix_cite(n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(result_cite[i][j]+"  ");
            }
            System.out.println();
        }

        int [][]result_cite2=generateMatrix_cite2(n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(result_cite2[i][j]+"  ");
            }
            System.out.println();
        }
    }


    //定义四个边界
    static int Max_W=0;
    static int Max_D=0;
    static int Max_A=0;
    static int Max_S=0;

    //初始化边界
    public static void initMax(int n){
        Max_W=0;
        Max_D=n-1;
        Max_A=0;
        Max_S=n-1;
    }

    //更新边界
    public static void updateMax(){
        Max_W++;
        Max_D--;
        Max_A++;
        Max_S--;
    }

    //获取下一个坐标
    public static int[] GetNextPosition(int n,int x,int y){
        int[]result=new int[2];
        if(x==Max_W&&y<Max_D){
            result[0]=x;
            result[1]=y+1;
            return result;
        }
        else if (y==Max_D&&x<Max_S){
            result[0]=x+1;
            result[1]=y;
            return result;
        } else if (x==Max_S&&y>Max_A) {
            result[0]=x;
            result[1]=y-1;
            return result;
        } else if (y==Max_A&&x>Max_W) {
            result[0]=x-1;
            result[1]=y;
        }
        return result;
    }


    //填充数组
    public static int[][] generateMatrix(int n) {
        int temp_n=n;
        int front_n=0;
        initMax(n);
        int [][]result=new int[n][n];
        int x=0;    //数组下标
        int y=0;    //数组下标
        //循环填充
        for (int i=1;i<=n*n;i++){
            //判断什么时候更新边界
            if(i-front_n==temp_n*4-4){
                updateMax();
                front_n=front_n+temp_n*4-4;
                temp_n=temp_n-2;
            }
            //System.out.println(x+"  "+y);
            result[x][y]=i;
            int[]temp=GetNextPosition(n,x,y);
            x=temp[0];
            y=temp[1];
        }
        return result;
    }


    //参考写法 核心是外层循环圈数或填充数字 <内层循环四条边>
    public static int[][] generateMatrix_cite(int n) {
        int [][]result=new int[n][n];

        int StartX=0;
        int StartY=0;
        int loop=n/2;
        int length=n-1;
        int count=1;
        while (loop>0){
            int x=StartX;
            int y=StartY;

            for(;y<length;y++){
                System.out.println(x+"  "+y);
                result[x][y]=count++;
            }

            for (;x<length;x++){
                System.out.println(x+"  "+y);
                result[x][y]=count++;
            }

            for (;y>n-length-1;y--){
                System.out.println(x+"  "+y);
                result[x][y]=count++;
            }
            for (;x>n-length-1;x--){
                System.out.println(x+"  "+y);
                result[x][y]=count++;
            }
            loop--;
            length--;
            StartX++;
            StartY++;

        }
        if (n%2==1){
            result[n/2][n/2]=count;
        }
        return result;
    }

    public static int[][] generateMatrix_cite2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

}

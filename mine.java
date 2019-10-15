import java.util.Random;
import java.util.Scanner;

public class MineSweeper
{
    public static void main(String[] args)
    {

        int[][] board=new int[9][9];

        char[][] copyBoard= new char[9][9];

        System.out.println("  0  1  2  3  4  5  6  7  8");
        placeRandomMines(board);
        countAdjacentMines(board);

        Scanner console = new Scanner(System.in);
        int m;
        int n;

        boolean isWin=true;
        while(isWin)
        {
           m = Integer.parseInt(console.nextLine());
           n = Integer.parseInt(console.nextLine());
            for (int i = 0; i <board.length ; i++)
            {
                for (int j = 0; j <board[i].length ; j++)
                {
                    if(isMine(m,n,board))
                    {
                        isWin=false;
                    }
                    else if(!isMine(m,n,board))
                    {
                        continue;
                    }
                }
            }
            open(m,n,board);
        }
    }


    public static void openZeroCells(int x,int y, int[][] arr)
    {
            if ((x>0)&&(y<8)&&(!isMine(x-1,y+1, arr)))
                System.out.print(arr[x-1][y+1]);
            if ((y>0)&&(!isMine(x,y-1, arr)))
                System.out.print(arr[x][y-1]);
            if ((x<8)&&(y>0)&&(!isMine(x+1,y-1, arr)))
                System.out.print(arr[x+1][y-1]);
            if ((x>0)&&(!isMine(x-1,y, arr)))
                System.out.print(arr[x-1][y]);
            if ((x<8)&&(!isMine(x+1,y, arr)))
                System.out.print(arr[x+1][y]);
            if ((y<8)&&(y>0)&&(x>0)&&(!isMine(x-1,y-1, arr)))
                System.out.print(arr[x-1][y-1]);
            if ((y<8)&&(!isMine(x,y+1, arr)))
                System.out.print(arr[x][y+1]);
            if ((y<8)&&(x<8)&&(!isMine(x+1,y+1, arr)))
                System.out.print(arr[x+1][y+1]);
    }

    public static void countAdjacentMines(int[][]arr)
    {
        for (int i = 0; i <arr.length ; i++)
        {
            System.out.print(i);
            for (int j = 0; j <arr[i].length ; j++)
            {
                System.out.print(" * ");
                if(!isMine(i,j,arr))
                {

                    int nCount=0;
                    if ((i>0)&&(j<8)&&(isMine(i-1,j+1, arr)))
                        nCount++;
                    if ((j>0)&&(isMine(i,j-1, arr)))
                        nCount++;
                    if ((i<8)&&(j>0)&&(isMine(i+1,j-1, arr)))
                        nCount++;
                    if ((i>0)&&(isMine(i-1,j, arr)))
                        nCount++;
                    if ((i<8)&&(isMine(i+1,j, arr)))
                        nCount++;
                    if ((j<8)&&(j>0)&&(i>0)&&(isMine(i-1,j-1, arr)))
                        nCount++;
                    if ((j<8)&&(isMine(i,j+1, arr)))
                        nCount++;
                    if ((j<8)&&(i<8)&&(isMine(i+1,j+1, arr)))
                        nCount++;
                    arr[i][j]=nCount;
                }
            }
            System.out.println();
        }
    }

    public static void placeRandomMines(int [][]arr)
    {
        int count=1;
        while(count<=10)
        {
            Random rand = new Random();
            int randomNum = rand.nextInt(9);
            int randomNum2=rand.nextInt(9);
            if (mineOrNot(randomNum, randomNum2))
            {
                arr[randomNum][randomNum2] = 9;
                count++;
            }

        }
    }
    public  static  boolean  mineOrNot(int a, int b)
    {
        int[][] ground=new int[9][9];
        if(ground[a][b] == 0)
        {
            ground[a][b] = 1;
            return true;
        }
        else
            return false;
    }

    public static boolean isMine(int a, int b, int[][]arr)
    {
        for (int i = 0; i <arr.length ; i++)
        {
            for (int j = 0; j <arr[i].length ; j++)
            {
                if(a==i && b==j && arr[a][b]==9)
                    return true;
            }
        }
        return false;
    }

    public static void print(int[][]arr)
    {
        for (int i = 0; i <arr.length ; i++)
        {
            for (int j = 0; j <arr[i].length ; j++)
            {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void open(int a, int b, int[][]arr)
    {
        System.out.println("  0  1  2  3  4  5  6  7  8");
        for (int i = 0; i <arr.length ; i++)
        {
            System.out.print(i);
            for (int j = 0; j <arr[i].length ; j++)
            {

                //if(i==a && j==b && arr[a][b]==0)
                //{
                //    openZeroCells(a,b,arr);
               // }
                if(i==a && j==b)
                {
                    System.out.print(" "+arr[a][b]+" ");
                    arr[a][b]-=10;
                }
                else if (arr[i][j]<0)
                {
                    System.out.print(" "+(arr[i][j]+10)+" ");
                }
                else
                    System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
import java.util.Scanner;

public class Print1SolOfNQueenPrlb {
    
    public static boolean nQueens(char board[][], int row){
        //base case
        if(row == board.length){
            printBoard(board);
            count++;
            return true;
        }

        //recursion
        //col loop
        for(int j=0; j<board.length; j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
            if(nQueens(board, row+1)){
                return true;
            }
            board[row][j] = 'x';
            }
            

        }
        return false;
    }

    public static boolean isSafe(char board[][], int row, int col){
        //vertical checking
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //Left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            
        }

       

    }
     return true;
}

    public static void printBoard(char board[][]){
        System.out.println("----------------CHESS BOARD-----------------------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length ;j++){
                System.out.print(board[i][j] + "   ");
            }
            System.out.println();
        
        }
        // System.out.println();
    }



    static int count =0;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = sc.nextInt();
        // int n = 4;
        char board [][] = new char [n][n];
        for(int i=0; i<n ; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'x';
            }
        }
        nQueens(board,0);
        System.out.println();
        System.out.println("Total Number of Ways : " + count);
        sc.close();

    }
    
}

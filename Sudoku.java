public class Sudoku {
    public static boolean isSafe(int sudukuBox[][], int row, int col, int digit){
        //col
        for(int i=0; i<=8; i++){
            if(sudukuBox[i][col] == digit){
                return false;
            }
        }

        //row
        for(int j=0; j<=8; j++){
            if(sudukuBox[row][j] == digit){
                return false;
            }
        }

        //grid
        // we need to calculate starting index of small matrix i.e starting row and col
        int startingRow  = (row/3)*3;
        int startingCol = (col/3)*3;

        for(int i=startingRow; i<startingRow+3; i++){
            for(int j=startingCol; j<startingCol+3; j++){
                if(sudukuBox[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static void Print(int sudukuBox[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print("|"+sudukuBox[i][j] + "|");
            }
            System.out.println();
        }
    }


    public static boolean workingFunction(int sudukuBox[][], int row, int col){
        //base case
        if(row == 9 ){
            return true;
        }

        //recursion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row + 1;
            nextCol = 0;
        }
        if(sudukuBox[row][col] != 0){
            return workingFunction(sudukuBox, nextRow, nextCol);
        }
        for(int digit = 1 ; digit<=9; digit++){
            if(isSafe(sudukuBox, row, col, digit)){
                sudukuBox[row][col] = digit;
                if(workingFunction(sudukuBox, nextRow, nextCol)){
                    return true;
                }
                sudukuBox[row][col] = 0;
            }
        }
        return false;
    }



    public static void main(String args[]){
        int sudukuBox [][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
    {1, 8, 5, 0, 6, 0, 0, 2, 0},
{0, 0, 0, 0, 2, 0, 0, 6, 0},
{9, 6, 0, 4, 0, 5, 3, 0, 0},
{0, 3, 0, 0, 7, 2, 0, 0, 4},
{0, 4, 9, 0, 3, 0, 0, 5, 7},
{8, 2, 7, 0, 0, 9, 0, 1, 3}};
if(workingFunction(sudukuBox,0,0)){
    System.out.println("Solution Exist");
    Print(sudukuBox);
}
else{
    System.out.println("Solution doesn't Exist");
    
}



    }
    
}

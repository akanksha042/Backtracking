public class GridWays {
    public static int CountWays(int i, int j,int n, int m){
        //base case
        //Target is our starting point
        //in that case we have 1 way to reach there
        if(i==n-1 || j==m-1){
            return 1;
        }
        //boundary condition
        //agar boundary line touch hui toh no need to do futher recursion
        else if(i==n || j==m){
            return 0;
        }

        //recursion
        int w1 = CountWays(i+1, j, n, m);
        int w2 = CountWays(i, j+1, n, m);
        int w3 = w1+w2;
        return w3;

    }

    //Time Complexity = O(2^n+m) ----> Worst 

    public static void main (String args[]){
        int n=3, m=3;
        System.out.println(CountWays(0, 0, n, m));


    }
    
}

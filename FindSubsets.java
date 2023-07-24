public class FindSubsets {

    public static void Finding(String str, String ans, int i){
        //base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");

            }
            else{
                System.out.println(ans);
            }
            return;
        }

        //recursion
        //yes choice i.e that particular character at ith index want to come 
        Finding(str, ans+str.charAt(i), i+1);

        //no choice i.e that particular character at ith index don't want to come 
        Finding(str, ans, i+1);

    }


    public static void main(String args[]){
        String str = "abc";
        Finding(str, "", 0);
    }

}
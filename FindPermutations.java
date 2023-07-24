public class FindPermutations {
    public static void Finding(String str, String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }


        //recursion TC => O(n * n!)
        for(int i=0; i<str.length();i ++){
            char currentChar = str.charAt(i);
            //"abcde" = > c ko remove karna hai toh we can do
            // "ab"  + "de" =>  abde
            //so here we will be using string substring function 

            String Newstr = str.substring(0, i) + str.substring(i+1);
            //lastindex is exclusive and if we do not mention the ending index it will assueme end of string
            Finding(Newstr, ans+currentChar);
        }

    }


    public static void main(String args[]){
        String str = "abc";
        Finding(str, "");

    }   
}

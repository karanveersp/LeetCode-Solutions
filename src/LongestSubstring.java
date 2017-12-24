import java.util.Scanner;
import java.io.File;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0)
            return 0;
        else if (s.length() == 1)
            return 1;
        
        char[] ch = s.toCharArray();
        String substr = "";
        String longest = "";
        
        for (int i = 0; i < ch.length; i++){
            substr = "" + ch[i];
            for (int j = i+1; j < ch.length; j++){
                //System.out.println(substr + " : " + "i = " + i + ", " + "j = " + j);
                if (substr.indexOf(ch[j]) != -1){
                    if (substr.length() > longest.length()) longest = substr;
                    //System.out.println("Break at ch[" + j + "] = " + ch[j] + " where substr = " + substr);
                    break;
                }
                else if (substr.indexOf(ch[j]) == -1){
                    substr += ch[j];
                }
            }
            if (substr.length() > longest.length()){
                longest = substr;
            }
            if (longest.length() > (ch.length-i-1)) // if remaining items in string are smaller than the current recorded substring, break
                break;
        }
        
        //System.out.println("Longest of " + s + ": " + longest + ", " + longest.length());
        return longest.length();
    }

    public static void main(String[] args) {

        // test1 has really really large input in the file
        String test1 = "";
        try {
            Scanner sc = new Scanner(new File("largeInput.txt"));
            while (sc.hasNext()){
                String s = sc.next();
                test1 += s;
            }
            sc.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        String test4 = "c";
        String test5 = "dvdf";
        String test6 = "anviaj";
        String test7 = "au";
        String test8 = "jbpnbwwd";

        System.out.println(lengthOfLongestSubstring(test1));
        System.out.println();
        System.out.println(lengthOfLongestSubstring(test2));
        System.out.println();
        System.out.println(lengthOfLongestSubstring(test3));
        System.out.println();
        System.out.println(lengthOfLongestSubstring(test4));
        System.out.println();
        System.out.println(lengthOfLongestSubstring(test5));
        System.out.println();
        System.out.println(lengthOfLongestSubstring(test6));
        System.out.println();
        System.out.println(lengthOfLongestSubstring(test7));
        System.out.println();
        System.out.println(lengthOfLongestSubstring(test8));
        System.out.println();
    }
}
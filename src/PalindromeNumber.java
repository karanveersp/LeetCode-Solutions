class PalindromeNumber {

    /*
    runs in O(1) since argument 
    can only contain a max of 10 digits
    of which only half must be processed
    to see if palindrome.
    This solution does utilize more space
    extra space in memory because of
    conversion to string and character array.
    */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        char[] ch = String.valueOf(x).toCharArray();
        char[] reversed_ch = new char[ch.length/2]; 
        
        for (int i = 0; i < reversed_ch.length; i++){
            // store digits in reverse and compare with begining
            reversed_ch[i] = ch[ch.length-1-i];
            if (ch[i] != reversed_ch[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] tests = new int[]{1001, 32123, 1224, 10101, 65457};

        for (int i : tests){
            System.out.println(i + " is palindrome? " + isPalindrome(i));
        }
    }
}
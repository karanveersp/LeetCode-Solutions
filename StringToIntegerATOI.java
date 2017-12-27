class StringToIntegerATOI {

    // runs in O(n) where n is
    // the length of the string
    public static int myAtoi(String str) {
        
        str = str.trim();
        if (str.isEmpty()) return 0;
        
        char[] ch = str.toCharArray();
        boolean isNegative = false;
        String numString = "";
        int result = 0;

        for (int i = 0; i < ch.length; i++){
            // handle leading positive/negative symbol
            if (i == 0 && ch[i] == '-' && i+1 < ch.length){
                isNegative = true;
                continue;
            }
            else if ((i == 0 && ch[i] == '+' && i+1 < ch.length)) continue;
            
            // ignore anything thats not a digit
            if (!Character.isDigit(ch[i])) break;
            else numString += ch[i];
        }        
        
        try {
            if (!numString.isEmpty()) result = Integer.valueOf(numString);
        }
        catch (NumberFormatException e){
            if (isNegative) return Integer.MIN_VALUE *-1;
            else return Integer.MAX_VALUE;
        }
        
        if (isNegative) return result * -1;
        else return result;    
    }

    public static void main(String[] args) {
        String[] tests = new String[]{"123", "+1000", "-252345", "-0"};
        for (String s : tests){
            System.out.println("String is " + s + " : Int is " +  myAtoi(s));
        }
    }
}
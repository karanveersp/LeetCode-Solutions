class ReverseInteger {

    // runtime of O(10) with 10
    // as the maximum number of digits
    // in the int parameter
    public static int reverse(int x) {
        
        String myInt = String.valueOf(x);
        String reversed = "";
        int result = 0;
        
        char[] ch = myInt.toCharArray();
        
        if (x < 0)
            reversed += "-";
        
        for (int i = ch.length-1; i >= 0; i--){
            // ignore leading zeros
            if ((reversed == "" || reversed == "-") && ch[i] == '0') continue;
            // ignore '-' sign
            if (ch[i] == '-') continue;
            reversed += ch[i];
        }
        
        try {
            result = Integer.parseInt(reversed);
        }
        catch (NumberFormatException e){
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tests = new int[]{1234, 3201, 123, 543, -100};

        for (int i : tests){
            System.out.println(i + " : " + reverse(i));
        }

    }
}
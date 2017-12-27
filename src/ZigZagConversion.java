

class ZigZagConversion {
    public static String convert(String s, int numRows) {
        // edge case
        if (s.length() <= 1 || numRows == 1){
            return s;
        }
        
        // find number of columns
        int numColumns = (s.length()%2 == 0) ? s.length()/2 : (s.length()/2) + 1;
        
        char[][] matrix = new char[numRows][numColumns];
        
        int i = 0; 
        int j = 0;
        int count = 0;
        char[] ch = s.toCharArray();
        
        boolean goDown = true;
        
        // O(n) runtime
        while (count < s.length()){
            if (i == 0){
                goDown = true;
                matrix[i][j] = ch[count];
                count++;
                i++;
                continue;
            }
            
            if (!goDown){
                matrix[i][j] = ch[count];
                count++;
                i--; 
                j++;
                continue;
            }

            if (i == numRows-1){
                goDown = false;
                matrix[i][j] = ch[count];
                count++;
                i--;
                j++;
                continue;
            }
            
            if (i > 0 && i < numRows-1 && goDown){
                matrix[i][j] = ch[count];
                count++;
                i++;
                continue;
            }
        }
        
        String result = "";
        
        // runs in O(n/2 * C) where n is s.length and C is number of rows
        for (int row = 0; row < numRows; row++){
            for (int col = 0; col < numColumns; col++){
                if (matrix[row][col] != Character.UNASSIGNED) 
                    result += matrix[row][col];
            }
        }
        
        return result;
        
    }


    public static void main(String[] args) {
        String[] tests = new String[]{"PAYPALISHIRING", "abcdef"};
        int testRows = 3;

        for (String s : tests){
            System.out.println(convert(s, testRows));
        }

        /* Correct answers (read line by line)
        P  A  H  N
        A PL SI IG
        Y  I  R

        a  e
        b df
        c
        */
    }
}
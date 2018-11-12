class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        
        String strX = new Integer(x).toString();
        int len = strX.length();
        char [] digits = new char[len];
        for (int i = 0; i < len; i++){
            digits[len - i - 1] = strX.charAt(i);
        }
        String revStr = "";
        if (x < 0){
            revStr += "-";
            len -= 1;
        }
        for (int j = 0; j < len; j++){
            revStr += digits[j];
        }
        try{
            Integer revInt = Integer.parseInt(revStr);
            return revInt.intValue();
        }catch(NumberFormatException e){
            return 0;
        }
    }
    
    // shorter solution
    public int reverse(int x){
        int ret = 0;
        while (x != 0){
            // handle overflow/underflow
            if (Math.abs(x) > 214748364){
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}
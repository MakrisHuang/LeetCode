class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        String aRev = new StringBuffer(a).reverse().toString();
        String bRev = new StringBuffer(b).reverse().toString();
        int idx = 0;
        String result = "";
        int carry = 0;
        String dig = null;
        while (idx < lenA && idx < lenB){
            if (aRev.charAt(idx) == '1' && bRev.charAt(idx) == '1'){
                if (carry == 1) {
                    dig = "1"; carry = 1;
                }else{
                    dig = "0"; carry = 1;
                }
            }else if (aRev.charAt(idx) == '1' || bRev.charAt(idx) == '1'){
                if (carry == 1){
                    dig = "0"; carry = 1;
                }else{
                    dig = "1";
                }
            }else{ // both are 0
                if (carry == 1){
                    dig = "1"; carry = 0;
                }else{
                    dig = "0";
                }
            }
            idx++;
            result += dig;
        }
        dig = null;
        if (lenA > lenB){
            while(idx < lenA){
                if (aRev.charAt(idx) == '1'){
                    if (carry == 1){
                        dig = "0"; carry = 1;
                    }else{
                        dig = "1"; carry = 0;
                    }
                }else{
                    if (carry == 1){
                        dig = "1"; carry = 0;
                    }else{
                        dig = "0";
                    }
                }
                idx++;
                result += dig;
            }

        }
        if (lenB > lenA){
            while(idx < lenB){
                if (bRev.charAt(idx) == '1'){
                    if (carry == 1){
                        dig = "0"; carry = 1;
                    }else{
                        dig = "1"; carry = 0;
                    }
                }else{
                    if (carry == 1){
                        dig = "1"; carry = 0;
                    }else{
                        dig = "0";
                    }
                }
                System.out.println("dig = " + dig);
                result += dig;
                idx++;
            }
        }
        if (carry == 1) result += "1"; // append remaining number
        return new StringBuffer(result).reverse().toString();
    }
}

class Solution {
    public String intToRoman(int num) {
        String str = Integer.toString(num);
        int strLen = str.length();
        String output = new String();
        for (int i = 0; i < strLen; i++){
            int aNum = Integer.parseInt(str.substring(i, i+1));
            output = output + romanChar(aNum, strLen - i); 
        }
        return output;
    }
    
    private String romanChar(int aNum, int pos){
        if (aNum == 0){
            return "";
        }
        String str = new String();
        switch(pos){
            case 4:{ // thousand
                while (aNum-- > 0) str = "M" + str;
                break;
            }
            case 3:{ // hundred
                if (aNum == 9){
                    str = "CM";
                }else if (aNum > 5){ // 6, 7, 8
                    str = "D";
                    aNum -= 5;
                    while (aNum-- > 0) str = str + "C";
                }else if (aNum == 5){ // 5
                    str = "D";
                }else if (aNum == 4){ // 4
                    str = "CD";
                }else{ // 1, 2, 3
                    while (aNum-- > 0) str = "C" + str;
                }
                break;
            }
            case 2:{ // tens
                if (aNum == 9){
                    str = "XC";
                }else if (aNum > 5){ // 6, 7, 8
                    str = "L";
                    aNum -= 5;
                    while (aNum-- > 0) str = str + "X";
                }else if (aNum == 5){ // 5
                    str = "L";
                }else if (aNum == 4){ // 4
                    str = "XL";
                }else{ // 1, 2, 3
                    while (aNum-- > 0) str = "X" + str;
                }
                break;
            }
            case 1:{ // tens
                if (aNum == 9){
                    str = "IX";
                }else if (aNum > 5){ // 6, 7, 8
                    str = "V";
                    aNum -= 5;
                    while (aNum-- > 0) str = str + "I";
                }else if (aNum == 5){ // 5
                    str = "V";
                }else if (aNum == 4){
                    str = "IV";
                }else{ // 1, 2, 3
                    while (aNum-- > 0) str = "I" + str;
                }
                break;
            }
        }
        return str;
    }
}
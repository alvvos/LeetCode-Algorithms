class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int i=0, j=0;
        char c_prev=0, c_aux=0;
        if(strs[0].isEmpty() || !(strs.length>0)){
            return "";
        }
        while(j<strs[0].length()){
            c_prev=strs[0].charAt(j);
            for(i=0; i<strs.length; i++){
                if(j<strs[i].length()){
                    c_aux = strs[i].charAt(j);
                    if(c_aux!=c_prev){
                        return prefix.toString();
                    }
                    c_prev = c_aux;
                } else {
                    return prefix.toString();
                }
            }
            prefix.append(c_aux);
            j++;
        }  
        return prefix.toString(); 
    }
}

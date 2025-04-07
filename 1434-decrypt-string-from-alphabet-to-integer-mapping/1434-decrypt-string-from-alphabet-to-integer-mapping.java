import java.util.*;

class Solution {
    public String freqAlphabets(String s) {
        String[] q = new String[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
            q[i] = Character.toString(s.charAt(i)); 
        }

        String result = "";
        int i = 0;
        while(i < q.length)
        {
            if(i+2 < q.length && q[i+2].equals("#"))
            {
                int t = Integer.parseInt(q[i]+q[i+1]) + 96;
                result += Character.toString((char) t);
                i+=3;
            }else{
                int t = Integer.parseInt(q[i]) + 96;
                result += Character.toString((char) t);
                i++;
            }
        }
        return result;
        
    }
}
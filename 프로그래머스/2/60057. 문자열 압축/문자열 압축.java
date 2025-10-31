import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length(); 
        for(int i = 1; i < s.length(); i++)
        {
            int start = 0;
            int end = i;
            HashMap<String, Integer> map = new HashMap<>();
            
            String prev = "";
            String ans = "";
            while(end <= s.length())
            {
                String toadd = s.substring(start,end);
                
                if(prev.equals(toadd) || prev.equals(""))
                {
                    map.put(toadd, map.getOrDefault(toadd,0)+1 );
                }else if(!map.isEmpty() && !prev.equals(toadd)){
                    Set<String> keyset = map.keySet();
                   
                    for(String st : keyset)
                    {
                        if(map.get(st)!=1) ans += String.valueOf(map.get(st));
                        ans += st;
                    }
                    map = new HashMap<>();
                    map.put(toadd, map.getOrDefault(toadd,0)+1 );
                }
                
                start += i;
                end += i;
                prev = toadd;
            }
             Set<String> keyset = map.keySet();
                   
            for(String st : keyset)
            {
                if(map.get(st)!=1) ans += String.valueOf(map.get(st));
                ans += st;
            }
            
            end -= i;
            ans += s.substring(end,s.length());
            answer = Math.min(answer ,ans.length()); 
            
        }
        
        
      
        return answer;
    }
}
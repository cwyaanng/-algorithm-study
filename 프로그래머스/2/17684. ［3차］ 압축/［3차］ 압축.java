import java.util.*;

class Solution {
    public int[] solution(String msg) {
        String ss = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<String , Integer> dict = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int a = 0; a < ss.length(); a++)
        {
            dict.put(Character.toString(ss.charAt(a)),a+1);
        }
        
        int index = 27;
        for(int i = 0; i < msg.length();)
        {
            int toadd = 0;
            int len = 0;
            for(String key : dict.keySet())
            {
                //사전에 저장된 값이 substring임 
                if(i+key.length() <= msg.length() && msg.substring(i,i+key.length()).equals(key))
                {
                    if(dict.get(key) > toadd)
                    {
                        toadd = dict.get(key);
                        len = key.length();
                    }
                    
                }
            }

            ans.add(toadd);
            if(i+len+1 <= msg.length())
            {
                dict.put(msg.substring(i,i+len+1) , index);
                index++;
            }
            i+=len;
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++ )
        {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
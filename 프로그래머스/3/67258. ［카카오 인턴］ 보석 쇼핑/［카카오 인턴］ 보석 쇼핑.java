import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        HashSet<String> set = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for(String st : gems)
        {
            set.add(st);
        }
        
        int start = 0;
        int length = Integer.MAX_VALUE;
        
        for(int end = 0; end < gems.length; end++)
        {
            map.put(gems[end] , map.getOrDefault(gems[end],0)+1);
            
            while(map.get(gems[start]) > 1)
            {
                map.put(gems[start], map.get(gems[start])-1);
                start++;
            }
            
            if(map.size() == set.size() && length > end - start)
            {
                length = end-start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }
        
        
        return answer;
    }
}
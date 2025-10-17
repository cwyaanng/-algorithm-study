import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String op : operations)
        {
            String[] s = op.split(" ");
            int key = Integer.parseInt(s[1]);
            
            if(s[0].equals("I"))
            {
                map.put(key, map.getOrDefault(key, 0)+1);
            }else{
                if(key == -1 && !map.isEmpty())
                {
                    int firstkey = map.firstKey();
                    int firstvalue = map.get(firstkey);
                    if(firstvalue == 1) map.remove(firstkey);
                    else map.put(firstkey, firstvalue-1);
                }else if(key == 1 && !map.isEmpty()){
                    int lastkey = map.lastKey();
                    int lastvalue = map.get(lastkey);
                    if(lastvalue == 1) map.remove(lastkey);
                    else map.put(lastkey , lastvalue -1);
                }
            }
        }
        
        if(map.size() == 0) return new int[]{0,0};
        else return new int[]{map.lastKey() , map.firstKey()};
    }
}
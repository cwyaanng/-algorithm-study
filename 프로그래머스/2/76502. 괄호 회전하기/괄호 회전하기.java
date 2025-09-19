import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            Stack<Character> q1 = new Stack<>();
            Stack<Character> q2 = new Stack<>();
            
            for(int j = i; j < i+s.length(); j++)
            {
                int pos = j % s.length();
                char target = s.charAt(pos);
                
                if(target == '[' || target == '(' || target == '{')
                {
                    q1.add(target);
                }else{
                    if(q1.isEmpty())
                    {
                        q2.add(target);
                    }else{
                        char comp = q1.peek();
                        if(comp == '[' && target == ']')
                        {
                            q1.pop();
                        }else if(comp == '(' && target == ')')
                        {
                            q1.pop();
                        }else if(comp == '{' && target == '}')
                        {
                            q1.pop();
                        }else{
                            q2.add(target);
                        }
                    }
                }    
            }
            if(q2.isEmpty() && q1.isEmpty()) answer++;
        }
        
        return answer;
    }
}
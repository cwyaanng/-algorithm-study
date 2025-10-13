import java.util.*;

class FileName implements Comparable<FileName>{
    public String head;
    public int number;
    public String tail;
    public int order;
    public String name;
    
    public FileName(String head, int number, String tail , int order, String name)
    {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.order = order;
        this.name = name;
    }
    
    public int compareTo(FileName fileName)
    {
        if(!this.head.toUpperCase().equals(fileName.head.toUpperCase()))
        {
            return this.head.compareToIgnoreCase(fileName.head);
        }else if(this.number != fileName.number)
        {
            return this.number - fileName.number;
        }else{
            return this.order - fileName.order;
        }
    }
    
    
}


class Solution {
    public String[] solution(String[] files) {
        
        ArrayList<FileName> fileNames = new ArrayList<>();
        
        int order = 0;
        for(String file : files)
        {
            int st_index = -1;
            int ed_index = -1;
            for(int i = 0; i < file.length(); i++)
            {
                if(file.charAt(i) >= 48 && file.charAt(i) <= 57)
                {
                    st_index = i;
                    break;
                }
            }
            
            for(int i = st_index; i < file.length(); i++)
            {
                if(file.charAt(i) < 48 || file.charAt(i) > 57)
                {
                    ed_index = i;
                    break;
                }
            }
            
         
            if(st_index != -1 && ed_index != -1)
            {
                String h = file.substring(0,st_index);
                int n = Integer.parseInt(file.substring(st_index , ed_index));
                String t = file.substring(ed_index,file.length());
                fileNames.add(new FileName(h,n,t,order,file));
            }else if(ed_index == -1 && st_index != -1)
            {
                String h = file.substring(0,st_index);
                int n = Integer.parseInt(file.substring(st_index,file.length()));
                fileNames.add(new FileName(h,n,"",order,file));
            }
            order++;
        }
        Collections.sort(fileNames);
        String[] answer = new String[files.length];
        int k = 0;
        for(FileName n : fileNames)
        {
            answer[k] = n.name;
            k++;
        }
        
        
        return answer;
    }
}
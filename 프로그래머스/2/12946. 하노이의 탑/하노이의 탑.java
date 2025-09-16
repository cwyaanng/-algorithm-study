import java.util.*;

class Solution {
    static ArrayList<int[]> arr = new ArrayList<>();
    public int[][] solution(int n) {
        
        hanoi(n,1,2,3);
        int[][] answer = new int[arr.size()][2];
        int i = 0;
        for(int[] a : arr)
        {
            answer[i][0] = a[0];
            answer[i][1] = a[1];
            i++;
        }
        return answer;
    }
    
    public void hanoi(int n , int start, int mid, int end)
    {
        if(n == 1) 
        {
            arr.add(new int[]{start,end});
            return;
        }
        
        hanoi(n-1,start,end,mid);
        arr.add(new int[]{start,end});
        hanoi(n-1,mid,start,end);
    }
}
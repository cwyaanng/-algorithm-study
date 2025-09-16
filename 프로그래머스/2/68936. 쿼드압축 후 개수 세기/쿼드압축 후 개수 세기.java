class Solution {
    
    static int[][] ans;
    static boolean[][] board;
    static int one = 0;
    static int zero = 0;
    
    public int[] solution(int[][] arr) {
        ans = arr;
        press(0,0,arr.length -1,arr.length-1);
        int[] answer = new int[]{zero,one};
        return answer;
    }
    
    public void press(int st_x ,int st_y , int ed_x, int ed_y)
    {
        if(st_x == ed_x && st_y == ed_y)
        {
            if(ans[st_x][st_y] == 0) zero++;
            else one++;
            return;
        }
        
        
        // 숫자가 같은지 판별하기 
        boolean flag = true;
        int vertify = ans[st_x][st_y];
        for(int i = st_x; i <= ed_x; i++)
        {
            for(int j = st_y; j <= ed_y; j++)
            {
                if(vertify != ans[i][j]) flag = false;
            }
        }        
        // 숫자가 같지 않다면 쪼개기 필요 
        if(!flag)
        {
            int mid_x = (st_x+ed_x+1)/2;
            int mid_y = (st_y+ed_y+1)/2;
            // 1
            press(st_x,st_y,mid_x-1,mid_y-1) ;
            // 4
            press(mid_x,mid_y, ed_x,ed_y) ;
            // 2 
            press(mid_x, st_y , ed_x, mid_y-1);
            // 3 
            press(st_x , mid_y  , mid_x-1, ed_y);   
        }else{ //숫자가 같다면 그냥 +1 해주고 끝내기
            if(vertify == 1) one++;
            else zero++;
            return;
        }
        
    }
}
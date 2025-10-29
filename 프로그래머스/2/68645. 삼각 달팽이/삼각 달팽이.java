class Solution {
    
    public static boolean[][] visited;
    public static int[][] table;
    public static int num;
    public static int[][] dir = {{1,0},{0,1},{-1,-1}};
    public static int value = 1;
    
    public int[] solution(int n) {
        int size = ((n+1)*n)/2;
        int[] answer = new int[size];
        
        num = n;
        visited = new boolean[n][n];
        table = new int[n][n];
        
        int a = 0;
        
        int x = 0; 
        int y = 0;
        int d = 0;
        
        while(value <= size)
        {
            int[] next = run(x,y,d);
            x = next[0];
            y = next[1];
            d = next[2];
        }
        
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(table[i][j] != 0)
                {
                    answer[a] = table[i][j];
                    a++;
                }
            }
        }
        
        
        
        return answer;
    }
    
  
    public static int[] run(int x, int y, int d)
    {
        int nx = x;
        int ny = y;
        
        while(nx >= 0 && ny >= 0 &&
          nx < num && ny < num && !visited[nx][ny])
        {
            table[nx][ny] = value;
            visited[nx][ny] = true;
            value++;
            nx = nx + dir[d][0];
            ny = ny + dir[d][1];
        }
        
        return new int[]{nx-dir[d][0]+dir[(d+1)%3][0], ny-dir[d][1]+dir[(d+1)%3][1],(d+1)%3};
    }
    
    
    
    
    
}
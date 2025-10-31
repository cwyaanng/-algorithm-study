class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] map = new int[n+1][m+1];
        
        map[1][1] = 1; 
        
        
        for(int i = 0; i < puddles.length; i++)
        {
            int y = puddles[i][0];
            int x = puddles[i][1];
            
            map[x][y] = -1;
        }
        
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(map[i][j] != - 1)
                {
                    if(map[i-1][j] >= 0) map[i][j] +=  map[i-1][j] % 1000000007;
                    if(map[i][j-1] >= 0) map[i][j] +=  map[i][j-1] % 1000000007;
                }
                map[i][j] = map[i][j]  % 1000000007;
            }
            
        }
        
        int answer = map[n][m];
        return answer;
    }
}
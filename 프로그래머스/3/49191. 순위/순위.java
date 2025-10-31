class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] table = new int[n+1][n+1];
        int answer = 0;
        //table을 채워넣기 
        for(int i = 0; i < results.length; i++)
        {
            int A = results[i][0];
            int B = results[i][1];
            
            table[A][B] = 1;
            table[B][A] = -1;
        }
        
        for(int i = 1 ; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                for(int k = 1; k <= n; k++)
                {
                    if(table[i][j] == 1 && table[j][k] == 1)
                    {
                        table[i][k] = 1;
                        table[k][i] = -1;
                    }
                    if(table[i][k] == -1 && table[k][j] == -1)
                    {
                        table[i][j] = -1;
                        table[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++)
        {
            int zero = 0;
            for(int j = 1; j <= n; j++)
            {
                if(table[i][j] == 0) zero++;
            }
            if(zero == 1) answer +=1;
        }
    
        return answer;
    }
}
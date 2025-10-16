class Solution {
    
    static boolean[] visited;
    static int[][] comp;
    static int num;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        comp = computers; 
        num = n;
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
    
    
    
    public void dfs(int i)
    {
        for(int a = 0; a < num; a++)
        {
            if(!visited[a] && comp[i][a] == 1 && i != a)
            {
                visited[a] = true;
                dfs(a);
            }
        }
        
    }
    
}
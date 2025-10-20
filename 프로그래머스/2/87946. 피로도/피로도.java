
class Solution {
    public int[][] dg;
    public boolean[] visited;
    public int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dg = dungeons;
        
        dfs(0,0,k);
        return answer;
    }
    
    
    public void dfs(int index, int depth, int k)
    {
        for(int i = 0; i < dg.length; i++)
        {
            if(!visited[i] && k >= dg[i][0])
            {
                visited[i] = true;
                dfs(i , depth+1 , k-dg[i][1]);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, depth);
        return;
    }
}
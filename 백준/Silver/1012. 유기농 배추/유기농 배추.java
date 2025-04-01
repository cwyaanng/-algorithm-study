import java.util.*;
import java.io.*;

public class Main {

  static int[][] arr;
  static boolean[][] visited;
  static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
  static int M;
  static int N;

  public static class Location{
    int x;
    int y;
    public Location(int x , int y)
    {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int count = Integer.parseInt(br.readLine());


    for(int i = 0; i < count ; i++)
    {
      Queue<Location> queue = new LinkedList<>();
      int result = 0;
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      arr = new int[N][M];
      visited = new boolean[N][M];
      for(int j = 0; j < K; j++)
      {
        st = new StringTokenizer(br.readLine() , " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        arr[x][y] = 1;
        queue.add(new Location(x,y));
      }

      for(Location loc : queue)
      {
        if(!visited[loc.x][loc.y]){
          dfs(loc.x , loc.y);
          result++;
        }
      }
      bw.write(result+"\n");
    }
    bw.flush();

  }

  public static void dfs(int x , int y)
  {
    visited[x][y] = true;
    for(int[] element : dir)
    {
      int nx = x + element[0];
      int ny = y + element[1];
      if( nx >= 0 && ny >= 0 && nx < N && ny < M)
      {
        if(!visited[nx][ny] && arr[nx][ny] == 1) dfs(nx,ny);
      }

    }


  }
}

import java.util.*;
import java.io.*;

public class Main{

  public static boolean[] visited;
  public static int[] arr;
  public static int result = 0;
  public static int N;
  public static int target;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    N = Integer.parseInt(st.nextToken());
    target = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine(), " ");

    visited = new boolean[N];
    arr = new int[N];

    for(int i =0; i < N; i++)
    {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0,0);
    if(target == 0) result = result -1;
    bw.write(result+"");
    bw.flush();

  }

  public static void dfs(int depth, int sum)
  {

    if(depth == N)
    {
      if(sum == target)
      {
        result +=1;
      }
      return;
    }

    dfs(depth+1, sum+arr[depth]);
    dfs(depth+1, sum);
  }
}
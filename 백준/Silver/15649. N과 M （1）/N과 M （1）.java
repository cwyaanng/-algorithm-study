import java.util.*;
import java.io.*;

public class Main{
  static int N;
  static int M;
  static boolean[] visited;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N+1];

    dfs(0 , "");
    bw.flush();
  }

  /*
  idx : 몇번 인덱스부터 추가하면서 검사를 시킬지
  depth : 숫자를 몇개 뽑았는지
   */
  public static void dfs(int depth , String get) throws IOException {
    if(depth == M)
    {
      bw.write(get+"\n");
      return;
    }

    for(int i = 1; i <= N; i++)
    {
      if(!visited[i])
      {
        visited[i] = true;
        dfs(depth+1, get+i+" ");
        visited[i] = false;
      }

    }

  }
}
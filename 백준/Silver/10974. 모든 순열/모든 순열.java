import java.util.*;
import java.io.*;

public class Main{

  //순열의 방문 여부 저장 필요
  static boolean[] visited;

  //순열 숫자 개수
  static int N;

  static StringBuilder ans = new StringBuilder();

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    visited = new boolean[N+1];

    dfs(0, new StringBuilder());
    bw.write(ans.toString());
    bw.flush();
  }

  public static void dfs(int depth , StringBuilder st)
  {
    if(depth == N)
    {
      ans.append(st).append("\n");
    }

    for(int i = 1; i <= N; i++)
    {
      if(!visited[i])
      {
        visited[i] = true;
        int before = st.length();
        dfs(depth+1, st.append(i).append(" "));
        st.setLength(before);
        visited[i] = false;
      }
    }
  }
}
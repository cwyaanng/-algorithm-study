import java.util.*;
import java.io.*;

public class Main{
  static int dp[][] = new int[30][30];

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    for(int i = 0; i < N; i++)
    {
      StringTokenizer st = new StringTokenizer(br.readLine() , " ");
      int s = Integer.parseInt(st.nextToken()); // 1
      int d = Integer.parseInt(st.nextToken()); // 5

      int result = combination(d,s);
      bw.write(result+"\n");
    }
    bw.flush();

  }
  public static int combination(int n, int r) {
    if(n == r || r == 0)
      return dp[n][r] = 1;
    else if(dp[n][r] > 0)
      return dp[n][r];
    else
      return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
  }
}
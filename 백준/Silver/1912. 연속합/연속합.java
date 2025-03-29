import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] value = new int[N+1];

    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    for(int i = 1; i < N+1; i++)
    {
      value[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N+1];

    for(int i = 1; i < N+1; i++)
    {
      dp[i] = Math.max(dp[i-1] + value[i] , value[i]);
    }

    int result = Integer.MIN_VALUE;
    for(int i = 1; i <N+1; i++)
    {
      result = Math.max(result,dp[i]);
    }
    bw.write(result+"");
    bw.flush();

  }
}
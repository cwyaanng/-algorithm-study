import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] time = new int[N+1];
    int[] pay = new int[N+1];
    int[] dp = new int[N+1];

    for(int i = 0; i < N; i++)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      time[i] = Integer.parseInt(st.nextToken());
      pay[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < N+1; i++)
    {
      for(int j = i+time[i]; j < N+1; j++)
      {
        if(dp[j] < dp[i] + pay[i]) dp[j] = dp[i] + pay[i];
      }
    }

    bw.write(dp[N]+"");
    bw.flush();

  }
}
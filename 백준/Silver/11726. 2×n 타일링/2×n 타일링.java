import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    long[] arr = new long[N+1];

    arr[0] = 1;
    arr[1] = 2;

    for(int i = 2; i < N; i++)
    {
      arr[i] = (arr[i-1]+arr[i-2])%10007;
    }

    bw.write(arr[N-1]+"");
    bw.flush();

  }
}
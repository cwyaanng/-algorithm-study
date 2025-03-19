import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][2];
    int[] answer = new int[N];


    for(int i = 0; i < N ; i++)
    {
      StringTokenizer st = new StringTokenizer(br.readLine() , " ");
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < N; i++)
    {
      for(int j = 0; j < N; j++)
      {
        if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1] && i != j)
        {
          answer[i] += 1;
        }
      }
      bw.write(answer[i]+1+" ");
    }
    bw.flush();
  }
}
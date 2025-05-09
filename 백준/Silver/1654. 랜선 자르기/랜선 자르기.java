import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //입력을 받기
    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    //가장 작은 숫자로 일단 잘러
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    long[] arr = new long[N];

    long min = 1;
    long max = Long.MIN_VALUE;

    for(int i = 0; i < N; i++)
    {
      arr[i] = Integer.parseInt(br.readLine());
      max = Math.max(max , arr[i])+1;
    }


    long result = 0;
    long target = 0;

    while(min < max)
    {
      result = 0;
      target = (min+max) / 2;
      for(int i = 0; i < N; i++)
      {
        result += arr[i] / target;
      }

      //결과가 더 커 -> 길이 늘여서 잘라
      if(result >= M) min = target+1;
      //결과가 작아 -> 길이 줄여서 잘라
      else max = target;
    }

    bw.write(min-1+"");
    bw.flush();
  }
}
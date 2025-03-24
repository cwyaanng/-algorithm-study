import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    int[] arr = new int[N];

    for(int i = 0; i < N; i++)
    {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int result = arr[N-1];
    int cha = 0;

    for(int i = 0; i < N-1; i++)
    {
      //이웃한 값들의 중간값 구하기
      int middle = (arr[i] + arr[i+1])/2;

      //중간값과의 차 구하기
      int d = Math.min(Math.abs(arr[i]-middle) , Math.abs(arr[i+1] - middle));

      //이전 차, 이전 값을 기억해 두고 만약에 차가 더 크면 값 갱신
      if(d > cha)
      {
        result = middle;
        cha = d;
      }else if(d == cha)
      {
        result = Math.min(result,middle);
      }
    }

    if(cha != 0) bw.write(result+"");
    else bw.write(-1+"");

    bw.flush();

  }

}
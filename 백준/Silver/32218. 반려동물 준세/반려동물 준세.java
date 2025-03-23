import java.util.*;
import java.io.*;


public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] a = new int[n];
    int[] b = new int[n];
    for(int i = 0; i < n; i++)
    {
      a[i] = Integer.parseInt(st.nextToken());
    }
    int count = 0;

    while(true)
    {
      //값 갱신
      boolean flag = true;
      count++;

      for(int i = 0; i < n; i++)
      {
        int num = 0;
        for(int j = i+1; j < n; j++)
        {
          if(a[i] < a[j]) num+=1;
        }
        b[i] = num;
      }

      //체크
      for(int i = 0; i < n; i++)
      {
        //만약에 값이 다른게 하나라도 있으면 false 처리
        if(!(a[i] == b[i])) flag = false;
      }

      //값이 다른게 있었다면 값 갱신
      if(!flag)
      {
        for(int i = 0; i < n; i++)
        {
          a[i] = b[i];
        }
      }else{
        bw.write(count+"");
        break;
      }

      if(count >= 201)
      {
        bw.write(-1+"");
        break;
      }
    }
    
    bw.flush();

  }
}
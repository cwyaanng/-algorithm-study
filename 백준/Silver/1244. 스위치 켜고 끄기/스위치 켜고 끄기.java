import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    //스위치 수
    int N = Integer.parseInt(st.nextToken());
    //스위치 배열
    int[] arr = new int[N+1];
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 1; i < N+1; i++)
    {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    //학생 수
    int students = Integer.parseInt(br.readLine());

    for(int i = 0; i < students; i++)
    {
      st = new StringTokenizer(br.readLine() , " ");
      int s = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());

      if(s == 1)
      {
        int count = num;
        while (count <= N) {

          if(arr[count]==0) arr[count] = 1;
          else arr[count] = 0;

          count = count+num;
        }
      }else if(s == 2)
      {

        int front = num +1;
        int end = num-1 ;

        while(front < N+1 && end > 0)
        {
          if(arr[front] == arr[end]) {
            front++;
            end--;
          }else if(arr[front] != arr[end])  break;

        }


        for(int j = end+1; j < front; j++)
        {
          if(arr[j] == 0) arr[j] = 1;
          else arr[j] = 0;
        }
      }
    }

    for(int i = 1; i < N+1; i++)
    {
      
      if(i% 20 == 0) bw.write(arr[i]+"\n");
      else bw.write(arr[i]+" ");
    }

    bw.flush();

  }
}
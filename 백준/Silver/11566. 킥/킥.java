import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] sound = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++)
    {
      sound[i] = Integer.parseInt(st.nextToken());
    }
    int m = Integer.parseInt(br.readLine());
    int[] dream_sound = new int[m];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < m; i++)
    {
      dream_sound[i] = Integer.parseInt(st.nextToken());
    }

    int k = m / (n-1);
    //k에 대해서 반복
    int min_dream = 3000;
    int max_dream = -1;


    for(int i = 1; i <= k+1; i++)
    {
      //dream sound로 반복
      for(int j = 0; j < m; j++)
      {
        //만약에 sound[0] 랑 같은 인덱스가 발견이 되면
        //거기서부터 패턴 매칭 시작
        if(dream_sound[j] == sound[0])
        {
          int flag = 1;
          int index = j;
          for(int l = 1; l < n; l++)
          {
            index += i;
            //만약 인덱스가 초과거나 패턴이 안 맞는다면 나가!
            if(index >= m || dream_sound[index] != sound[l]){
              flag = 0;
              break;
            }
          }

          //만약 패턴이 다 맞아서 잘 나왔으면 갱신
          if(flag == 1)
          {
            min_dream = Math.min(i-1,min_dream);
            max_dream = Math.max(i-1,max_dream);
          }
        }
      }
    }
    if(max_dream == -1)
    {
      bw.write(-1+"");
    }else{
      bw.write(min_dream+" "+max_dream);
    }
    bw.flush();
  }
}
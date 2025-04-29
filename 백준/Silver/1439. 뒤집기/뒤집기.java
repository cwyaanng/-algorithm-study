import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    char[] arr = br.readLine().toCharArray();

    //0 덩어리 세고 1덩어리 세기
    // 그 다음에 둘중 작은거 리턴

    int zero = 0;
    int one = 0;
    for(int i = 0; i < arr.length-1; i++)
    {
      if(arr[i] != arr[i+1])
      {
        if(arr[i] == '0') zero+=1;
        else one +=1;
      }

    }

    if(arr[arr.length-1] == '0') zero+=1;
    else one +=1;


    bw.write(Math.min(zero,one)+"");
    bw.flush();



  }
}
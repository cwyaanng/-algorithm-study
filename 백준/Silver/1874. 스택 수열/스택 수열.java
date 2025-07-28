import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    Stack<Integer> stack = new Stack<>();
    boolean pass = true;
    int current = 1;
    StringBuilder sb = new StringBuilder();

    //넣기
    for(int i = 0; i < N; i++)
    {
      arr[i] = Integer.parseInt(br.readLine());
    }


    for(int i = 0; i < N; i++)
    {
      while(current <= arr[i])
      {
        stack.push(current++);
        sb.append("+").append("\n");
      }

      if(stack.peek() == arr[i])
      {
        stack.pop();
        sb.append("-").append("\n");
      }else{
        bw.write("NO");
        bw.flush();
        pass = false;
        return;
      }
    }
    bw.write(sb.toString());
    bw.flush();

  }
}
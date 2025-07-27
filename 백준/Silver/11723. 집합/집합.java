import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int M = Integer.parseInt(br.readLine());
    HashSet<Integer> set = new HashSet<>();
    String command ="";
    int x = 0;
    for(int i =0; i <M; i++)
    {
      String[] arr = br.readLine().split(" ");
      if(arr.length == 2)
      {
        command = arr[0];
        x = Integer.parseInt(arr[1]);
      }else{
        command = arr[0];
      }


      switch(command)
      {
        case "add":
          if(!set.contains(x)) set.add(x);
          break;
        case "remove":
          if(set.contains(x)) set.remove(x);
          break;
        case "check":
          if(set.contains(x)) bw.write("1\n");
          else bw.write("0\n");
          break;
        case "toggle":
          if(!set.contains(x)) set.add(x);
          else set.remove(x);
          break;
        case "all":
          set.clear();
          for(int a = 1; a <= 20; a++) set.add(a);
          break;
        case "empty":
          set.clear();
          break;
      }

    }
    bw.flush();


  }
}
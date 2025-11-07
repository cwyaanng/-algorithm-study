import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{

    // 모든 트럭이 다리를 건너는 최단시간?

    // w 대의 트럭만 동시에 올라갈 수 있다
    // w = 다리의 길이
    // 하나의 단위시간동안 하나의 단위길이 만큼만 이동
    // 다리 위에 올라가있는 트럭들의 무게의 합 <= 다리의 최대하중 L

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    int n = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    Queue<Integer> trucks = new LinkedList<>();
    Queue<Integer> bridge = new LinkedList<>();

    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < n; i++)
    {
      trucks.add(Integer.parseInt(st.nextToken()));
    }

    for(int i = 0; i < w; i++)
    {
      bridge.add(0);
    }

    int tick = 0;
    int weight = 0;
    while(!bridge.isEmpty())
    {
      tick++;
      weight -= bridge.poll();
      if(!trucks.isEmpty())
      {
        if (weight + trucks.peek() <= L ){
          int new_weight = trucks.poll();
          weight += new_weight;
          bridge.add(new_weight);
        }
        else{
          bridge.add(0);
        }
      }
    }

    bw.write(tick+"");
    bw.flush();
  }
}
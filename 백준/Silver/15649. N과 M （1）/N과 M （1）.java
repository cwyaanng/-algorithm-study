import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean visited[];
    static int b;
    static List<String> target = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = bf.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        b = Integer.parseInt(arr[1]);

        visited = new boolean[a];


        dfs(0,"");

        for(String s : target){
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void dfs(int cnt, String s){
        //b(순열을 뽑아야 하는 횟수와 카운트 횟수가 같으면 집어넣고 중지)
        if(cnt == b){
            target.add(s);
            return;
        }

        //아니라면 재귀 호출, 카운트 횟수를 올려서 매개변수로 넣어주기
        for(int j = 0; j < visited.length; j++){
            //안되면 들어가면 안돼!!!!되는 것만 재귀를 호출해야 한다.
            if(!visited[j])
            {
                visited[j] = true;
                if (s.length()==0) dfs(cnt+1,s+(j+1));
                else dfs(cnt+1,s+" "+(j+1));
                visited[j] = false;
            }

        }
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static boolean visited[];
    static int b;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = bf.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        b = Integer.parseInt(arr[1]);

        visited = new boolean[a];

        dfs(0,"",0);

    }

    //시작점 추가
    public static void dfs(int cnt, String s ,int start){
        //b(순열을 뽑아야 하는 횟수와 카운트 횟수가 같으면 집어넣고 중지)
        if(cnt == b){
            System.out.println(s);
            return;
        }
        //아니라면 재귀 호출, 카운트 횟수를 올려서 매개변수로 넣어주기
        for(int j = start; j < visited.length; j++){
            if(!visited[j])
            {
                visited[j] = true;
                if (s.length()==0) dfs(cnt+1,s+(j+1) , j+1);
                else dfs(cnt+1,s+" "+(j+1),j+1);
                visited[j] = false;
            }
        }
    }
}
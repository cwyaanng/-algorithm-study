import java.util.*;


class Solution {
    public int solution(int[][] routes) {
        
        //끝 지점 기준으로 정렬을 한다음에 
        Arrays.sort(routes , new Comparator<int[]>(){
            public int compare(int[] a , int[] b)
            {
                return a[1] - b[1];
            }
        });
        
        //일단 맨 처음 끝 지점에 설치하고
        int answer = 1;
        int camera = routes[0][1];
        //그 다음에 설치한 카메라 위치가 시작 지점보다 뒤면 설치 x
        //앞이면 다시 끝 지점에 새로 설치
        for(int i = 0;  i < routes.length; i++)
        {
            if(camera < routes[i][0])
            {
                answer += 1;
                camera = routes[i][1];
            }
        }
        
        
        
        
        
        return answer;
    }
}
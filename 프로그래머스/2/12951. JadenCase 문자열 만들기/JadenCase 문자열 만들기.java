class Solution {
    public String solution(String st) {
        String answer = "";
        //쪼개서 String[] 로 넣기
        String[] arr = st.split(" ");
        for(String s : arr)
        {
            if(s.length() == 0)
            {
                answer += " ";
            }else{
                answer += s.substring(0,1).toUpperCase();
                answer += s.substring(1).toLowerCase();
                answer += " ";
            }
        }
        
        if(st.substring(st.length()-1, st.length()).equals(" ")) return answer;
        answer = answer.substring(0,answer.length()-1);
        
        return answer;
    }
}
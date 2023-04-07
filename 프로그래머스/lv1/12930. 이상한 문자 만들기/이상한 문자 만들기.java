class Solution {
    public String solution(String s) {
        String answer = "";
        String s_ca= s.toUpperCase();
        char[] ch = s_ca.toCharArray();
        
        for(int i = 1; i< ch.length; i++){
            if(Character.isUpperCase(ch[i-1])){
                ch[i] = Character.toLowerCase(ch[i]);
            }
        }
        answer = String.valueOf(ch);
        return answer;
    }
}

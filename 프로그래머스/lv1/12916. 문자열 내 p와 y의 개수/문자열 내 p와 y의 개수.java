class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String s_l= s.toLowerCase();
        
        if(s_l.chars().filter(a -> 'p'== a).count() == s_l.chars().filter(b -> 'y'== b).count()){
            answer = true;
        }
        else{
            answer = false;
        }
        return answer;
    }
}


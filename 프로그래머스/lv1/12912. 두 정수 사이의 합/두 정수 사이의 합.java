class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long a_l = a;
        long b_l = b;
        
        answer = (Math.abs(a_l-b_l)+1)*(a_l+b_l)/2;
        return answer;
    }
}


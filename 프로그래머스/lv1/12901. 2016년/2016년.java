class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int yr_f = 20;
        int yr_b = 16;
        if (a==1 || a == 2){
            yr_b -= 1;
            a+= 12;
        }
        int zeller = ((21*yr_f/4) + (5*yr_b/4) + (26*(a+1)/10) + b - 1)%7;
        answer = days[zeller];
        return answer;
    }
}

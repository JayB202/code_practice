class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String [] x_str = String.valueOf(x).split("");
        int sum=0;
        for(String s:x_str) {
            sum+=Integer.parseInt(s);
            }
        return x%sum==0; 
        
    }
}

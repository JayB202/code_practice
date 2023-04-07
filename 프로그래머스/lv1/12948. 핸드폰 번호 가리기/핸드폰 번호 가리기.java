class Solution {
    public String solution(String phone_number) {
        int a = phone_number.length() -4;      
         
        return phone_number.substring(0,a).replaceAll(".","*")+phone_number.substring(a);
    }
}
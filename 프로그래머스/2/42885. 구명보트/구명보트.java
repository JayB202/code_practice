import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int n = 0;
        int ln = people.length - 1;
        
        while (n <= ln) {
            answer++;
            if (people[ln] + people[n] <= limit) {
                n++;
            }
            ln--;
        }
        
        return answer;
    }
}

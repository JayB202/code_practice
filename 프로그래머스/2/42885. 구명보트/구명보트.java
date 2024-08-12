import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0; // 구명보트의 개수를 저장할 변수
        Arrays.sort(people); // 몸무게 배열을 오름차순으로 정렬
        int n = 0; // 배열의 시작 인덱스
        int ln = people.length - 1; // 배열의 끝 인덱스
        
        // 배열의 시작 인덱스가 끝 인덱스보다 작거나 같을 때까지 반복
        while (n <= ln) {
            answer++; // 새로운 구명보트를 추가
            // 가장 무거운 사람(끝 인덱스)과 가장 가벼운 사람(시작 인덱스)을 함께 태울 수 있는지 확인
            if (people[ln] + people[n] <= limit) {
                n++; // 가벼운 사람을 다음으로 이동
            }
            ln--; // 무거운 사람을 다음으로 이동
        }
        
        return answer; 
    }
}

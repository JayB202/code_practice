import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        // 장르별로 노래의 재생 횟수와 고유 번호를 저장할 맵
        Map<String, List<int[]>> genrePlayMap = new HashMap<>();
        // 장르별 총 재생 횟수를 저장할 맵
        Map<String, Integer> genreSumMap = new HashMap<>();
        
        // 각 노래의 장르별 재생 횟수와 고유 번호를 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            // 해당 장르가 맵에 없으면 새로운 리스트를 생성하여 추가
            genrePlayMap.putIfAbsent(genre, new ArrayList<>());
            // 노래의 고유 번호와 재생 횟수를 리스트에 추가
            genrePlayMap.get(genre).add(new int[]{i, play});
            // 해당 장르의 총 재생 횟수 업데이트
            genreSumMap.put(genre, genreSumMap.getOrDefault(genre, 0) + play);
        }
        
        // 장르별 총 재생 횟수로 정렬
        List<String> sortedGenres = new ArrayList<>(genreSumMap.keySet());
        sortedGenres.sort((a, b) -> genreSumMap.get(b) - genreSumMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        // 각 장르 내에서 재생 횟수로 정렬 후 고유 번호를 결과에 추가
        for (String genre : sortedGenres) {
            List<int[]> songs = genrePlayMap.get(genre);
            // 재생 횟수로 내림차순 정렬, 재생 횟수가 같으면 고유 번호로 오름차순 정렬
            songs.sort((a, b) -> b[1] - a[1] != 0 ? b[1] - a[1] : a[0] - b[0]);
            // 최대 2개의 노래를 선택하여 결과에 추가
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                result.add(songs.get(i)[0]); // 고유 번호 추가
            }
        }
        
        // 결과를 배열로 변환하여 반환
        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
}
}
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool solution(vector<string> phone_book) {
    // 벡터를 정렬
    sort(phone_book.begin(), phone_book.end());
    
    // 정렬된 벡터에서 인접한 두 요소를 비교
    for (int i = 0; i < phone_book.size() - 1; i++) {
        // 다음 요소가 현재 요소로 시작하는지 확인
        if (phone_book[i + 1].find(phone_book[i]) == 0) {
            return false;
        }
    }
    
    return true;
}

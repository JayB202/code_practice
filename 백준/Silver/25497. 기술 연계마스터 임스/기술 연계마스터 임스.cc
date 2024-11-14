#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
#define endl '\n'

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int sz, cnt = 0;
    int Lon = 0, Son = 0;  // L과 S 기술의 개수를 추적
    string skill;
    cin >> sz >> skill;
    
    for (int n = 0; n < sz; n++) {
        if (skill[n] >= '1' && skill[n] <= '9') {
            // 연계 없이 사용할 수 있는 기술
            cnt++;
        } else {
            switch (skill[n]) {
                case 'L':  // 사전 기술 L
                    Lon++;  // L 추가
                    break;
                    
                case 'R':  // 연계 기술 R
                    if (Lon > 0) {  // L이 존재할 때만 연계 가능
                        cnt++;
                        Lon--;  // 연계된 L을 하나 제거
                    } else {
                        cout << cnt << endl;  // 연계 실패시 바로 출력
                        return 0;  // 즉시 종료
                    }
                    break;
                    
                case 'S':  // 사전 기술 S
                    Son++;  // S 추가
                    break;
                    
                case 'K':  // 연계 기술 K
                    if (Son > 0) {  // S가 존재할 때만 연계 가능
                        cnt++;
                        Son--;  // 연계된 S를 하나 제거
                    } else {
                        cout << cnt << endl;  // 연계 실패시 바로 출력
                        return 0;  // 즉시 종료
                    }
                    break;
            }
        }
    }
    
    cout << cnt << endl;  // 정상적으로 발동한 기술 수 출력
    return 0;
}

#include <iostream>
#include <string>
#include <queue>
#include <sstream> // stringstream 사용을 위해 추가
using namespace std;

int main(void)
{
    int n;
    cin >> n;
    cin.ignore(); // 줄바꿈 문자를 처리하기 위해 사용

    queue<int> readyLine; // 대기줄을 위한 큐
    int maxLineCnt = 0; // 최대 대기줄 수
    int minBackStudy = 0; // 최대 대기줄일 때 맨 뒤에 있는 학생 번호

    for (int i = 0; i < n; i++)
    {
        string input;
        getline(cin, input); // 한 줄을 입력 받음

        stringstream ss(input); // 입력을 분리하기 위해 stringstream 사용
        int type;
        ss >> type; // 명령 유형을 읽음

        if (type == 1)
        {
            int num;
            ss >> num; // 학생 번호를 읽음
            readyLine.push(num); // 학생을 대기줄에 추가

            // 현재 대기줄의 크기 확인
            int size = readyLine.size();
            if (maxLineCnt < size)
            {
                maxLineCnt = size;
                minBackStudy = num; // 맨 뒤에 있는 학생 번호 기록
            }
            else if (maxLineCnt == size)
            {
                if (minBackStudy > num)
                    minBackStudy = num; // 대기줄의 크기가 같으면 번호가 작은 학생으로 업데이트
            }
        }
        else if (type == 2)
        {
            readyLine.pop(); // 식사가 준비되면 대기줄에서 맨 앞의 학생을 제거
        }
    }

    // 결과 출력
    cout << maxLineCnt << ' ' << minBackStudy << endl;

    return 0;
}

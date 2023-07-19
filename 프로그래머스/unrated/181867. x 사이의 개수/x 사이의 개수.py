def solution(myString):
    answer = []
    myStringList = myString.split("x")
    for i in myStringList:
        answer.append(len(i))
    return answer
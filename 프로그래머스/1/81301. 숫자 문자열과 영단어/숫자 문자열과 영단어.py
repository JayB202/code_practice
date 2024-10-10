def check_letter(array):
    test = "".join(array)
    if test == 'zero':
        return '0'
    elif test =='one':
        return '1'
    elif test == 'two':
        return '2'
    elif test =='three':
        return '3'
    elif test == 'four':
        return '4'
    elif test =='five':
        return '5'
    elif test =='six':
        return '6'
    elif test =='seven':
        return '7'
    elif test =='eight':
        return '8'
    elif test == 'nine':
        return '9'
    else:
        return ''

def solution(s):

    answer = []
    temp =[]
    for letter in s:
        if letter in "0123456789":
            answer.append(letter)
        else:
            temp.append(letter)
            if check_letter(temp).isdigit():
                answer.append(check_letter(temp))
                temp=[]
    final = int("".join(answer))
    return final
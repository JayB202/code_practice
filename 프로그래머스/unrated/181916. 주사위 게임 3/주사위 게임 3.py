def solution(a, b, c, d):
    answer = 0
    if a==b==c==d:
        answer = 1111 * a
    elif a==b==c or a==b== d or a==c==d or b==c==d:
        if a== b== c :
            answer = (10*a +d)**2
        elif a==b==d:
            answer = (10*a + c)**2
        elif a==c==d:
            answer = (10*a + b)**2
        else:               
            answer = (10*b + a)**2
    elif (a==b and c==d) or (a==c and b==d) or (a==d and b==c):
        if (a==b and c==d) or (a==c and b==d):
            answer = (a+d)*abs(a-d)
        else:
            answer = (a+b)*abs(a-b)
    elif a==b or a==c or a==d or b==c or b==d or c==d:
        if a==b:
            answer = c *d
        elif a==c :
            answer = b*d
        elif a== d:
            answer = b*c
        elif b==c:
            answer = a*d
        elif b==d :
            answer = a*c
        else:
            answer = a*b
    else:
        answer = min([a,b,c,d])
    return answer
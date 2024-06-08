def findratio(x, y):
    left = 0
    right = x

    ratio = int((100*y)//x)
    
    if 99 <= ratio:
        return -1
    else:
        while left <= right:
            mid = (left+right)//2
            newratio = (y+mid) * 100 // (x+mid)
            if  ratio < newratio:
                right = mid - 1
            else: 
                left = mid+1
        
    return left

x, y = map(int, input().split())
print(findratio(x, y))